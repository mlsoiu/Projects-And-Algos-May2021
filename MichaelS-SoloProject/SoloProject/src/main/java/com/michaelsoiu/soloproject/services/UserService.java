package com.michaelsoiu.soloproject.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelsoiu.soloproject.models.CtRecipe;
import com.michaelsoiu.soloproject.models.FdRecipe;
import com.michaelsoiu.soloproject.models.User;
import com.michaelsoiu.soloproject.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return this.uRepo.save(user);
	}
	
	public User find(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	
	public List<User> allUsers() {
		return this.uRepo.findAll();
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	public List<FdRecipe> allUsersRecipes(User currentUser) {
		List<FdRecipe> usersRecipes = currentUser.getFdRecipes();
		//System.out.println(usersRecipes);
		return usersRecipes;
	}
	
	public List<CtRecipe> allUsersCocktails(User currentUser) {
		List<CtRecipe> usersCocktails = currentUser.getCtRecipes();
		//System.out.println(usersCocktails);
		return usersCocktails;
	}
}
