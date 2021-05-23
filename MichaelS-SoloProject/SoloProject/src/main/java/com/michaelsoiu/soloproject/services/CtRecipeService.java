package com.michaelsoiu.soloproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelsoiu.soloproject.models.CtRecipe;
import com.michaelsoiu.soloproject.models.User;
import com.michaelsoiu.soloproject.repositories.CtRecipeRepository;
import com.michaelsoiu.soloproject.repositories.UserRepository;

@Service
public class CtRecipeService {
	@Autowired
	private CtRecipeRepository cRepo;
	@Autowired
	private UserRepository uRepo;
	
	public CtRecipe getOneCocktail(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public List<CtRecipe> getAllCocktails() {
		return this.cRepo.findAll();
	}
	
	public List<User> getAllUsers() {
		return this.uRepo.findAll();
	}
	
	public CtRecipe create(CtRecipe cRecipe) {
		return this.cRepo.save(cRecipe);
	}
	
	public CtRecipe updateCocktail(Long id, CtRecipe updatedCocktail) {
		return this.cRepo.save(updatedCocktail);
	}
	
	public void delete(Long id) {
		this.cRepo.deleteById(id);
	}
	
	public void likeCocktail(User user, CtRecipe ctRecipe) {
		List<User> likers = ctRecipe.getLikers();
		likers.add(user);
		this.cRepo.save(ctRecipe);
	}
	
	public void unlikeCocktail(User user, CtRecipe ctRecipe) {
		List<User> likers = ctRecipe.getLikers();
		likers.remove(user);
		this.cRepo.save(ctRecipe);
	}

}
