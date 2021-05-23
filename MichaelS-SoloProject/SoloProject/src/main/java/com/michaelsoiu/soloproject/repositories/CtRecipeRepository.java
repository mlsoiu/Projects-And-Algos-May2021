package com.michaelsoiu.soloproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.michaelsoiu.soloproject.models.CtRecipe;

public interface CtRecipeRepository extends CrudRepository<CtRecipe, Long>{
	List<CtRecipe> findAll();
}
