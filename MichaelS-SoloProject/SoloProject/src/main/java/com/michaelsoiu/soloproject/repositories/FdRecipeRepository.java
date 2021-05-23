package com.michaelsoiu.soloproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.michaelsoiu.soloproject.models.FdRecipe;

public interface FdRecipeRepository extends CrudRepository<FdRecipe, Long>{
	List<FdRecipe> findAll();
	
}
