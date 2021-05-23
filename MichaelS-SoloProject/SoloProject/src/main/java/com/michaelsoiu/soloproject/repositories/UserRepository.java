package com.michaelsoiu.soloproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.michaelsoiu.soloproject.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	boolean existsByEmail(String email);
	User findByEmail(String email);
}
