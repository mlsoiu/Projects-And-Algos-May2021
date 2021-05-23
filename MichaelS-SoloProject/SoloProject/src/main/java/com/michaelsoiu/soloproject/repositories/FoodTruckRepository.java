package com.michaelsoiu.soloproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.michaelsoiu.soloproject.models.FoodTruck;

public interface FoodTruckRepository extends CrudRepository<FoodTruck, Long>{
	List<FoodTruck> findAll();
}
