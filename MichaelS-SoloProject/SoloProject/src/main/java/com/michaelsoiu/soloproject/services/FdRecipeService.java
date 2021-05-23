package com.michaelsoiu.soloproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelsoiu.soloproject.models.FdRecipe;
import com.michaelsoiu.soloproject.models.User;
import com.michaelsoiu.soloproject.repositories.FdRecipeRepository;
import com.michaelsoiu.soloproject.repositories.UserRepository;

@Service
public class FdRecipeService {
	@Autowired
	private FdRecipeRepository frRepo;
	@Autowired
	private UserRepository uRepo;
	
	public FdRecipe getOneRecipe(Long id) {
		return this.frRepo.findById(id).orElse(null);
	}
	
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public List<FdRecipe> getAllFdRecipes() {
		return this.frRepo.findAll();
	}
	
	public List<User> getAllUsers() {
		return this.uRepo.findAll();
	}
	
	public FdRecipe create(FdRecipe fRecipe) {
		return this.frRepo.save(fRecipe);
	}
	
	public FdRecipe updateFdRecipe(Long id, FdRecipe updatedFRecipe) {
		return this.frRepo.save(updatedFRecipe);
	}
	
	public void delete(Long id) {
		this.frRepo.deleteById(id);
	}
	
	public void likeFdRecipe(User user, FdRecipe fdRecipe) {
		List<User> likers = fdRecipe.getLikers();
		likers.add(user);
		this.frRepo.save(fdRecipe);
	}
	
	public void unlikeFdRecipe(User user, FdRecipe fdRecipe) {
		List<User> likers = fdRecipe.getLikers();
		likers.remove(user);
		this.frRepo.save(fdRecipe);
	}
}
