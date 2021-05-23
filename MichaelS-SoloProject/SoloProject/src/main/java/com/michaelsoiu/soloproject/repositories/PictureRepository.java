package com.michaelsoiu.soloproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaelsoiu.soloproject.models.Picture;
import com.michaelsoiu.soloproject.models.User;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long>{
	List<Picture> findAllByOwner(User owner);
}
