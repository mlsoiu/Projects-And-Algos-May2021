package com.michaelsoiu.soloproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelsoiu.soloproject.models.Picture;
import com.michaelsoiu.soloproject.models.User;
import com.michaelsoiu.soloproject.repositories.PictureRepository;

@Service
public class PictureService {
	@Autowired
	private PictureRepository pRepo;
	
	public void uploadPic(User owner, String url, String description) {
		Picture newPic = new Picture(owner, url, description);
		this.pRepo.save(newPic);
	}
}
