package com.michaelsoiu.soloproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelsoiu.soloproject.models.FoodTruck;
import com.michaelsoiu.soloproject.models.User;
import com.michaelsoiu.soloproject.repositories.FoodTruckRepository;
import com.michaelsoiu.soloproject.repositories.UserRepository;

@Service
public class FoodTruckService {
	@Autowired
	private FoodTruckRepository truckRepo;
	@Autowired
	private UserRepository uRepo;
	
	public FoodTruck getOneTruck(Long id) {
		return this.truckRepo.findById(id).orElse(null);
	}
	
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public List<FoodTruck> getAllTrucks() {
		return this.truckRepo.findAll();
	}
	
	public List<User> getAllUsers() {
		return this.uRepo.findAll();
	}
	
	public FoodTruck create(FoodTruck foodTruck) {
		return this.truckRepo.save(foodTruck);
	}
	
	public void delete(Long id) {
		this.truckRepo.deleteById(id);
	}
}
