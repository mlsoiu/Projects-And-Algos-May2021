package com.michaelsoiu.soloproject.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.michaelsoiu.soloproject.models.CtRecipe;
import com.michaelsoiu.soloproject.models.FdRecipe;
import com.michaelsoiu.soloproject.models.User;
import com.michaelsoiu.soloproject.services.PictureService;
import com.michaelsoiu.soloproject.services.UserService;

@Controller
@RequestMapping("/profile")
public class PictureController {
	@Autowired
	private UserService uService;
	@Autowired
	private PictureService pService;
	
	private static String UPLOADED_FOLDER = "src/main/resources/static/images/";
	
	@GetMapping("")
	public String profile(HttpSession session, Model model) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user__id");
		User user = this.uService.find(userId);
		List<FdRecipe> recipes =  this.uService.allUsersRecipes(user);
		//System.out.println(recipes);
		List<CtRecipe> ctRecipes = this.uService.allUsersCocktails(user);
		//System.out.println(ctRecipes);
		model.addAttribute("currentUser", user);
		model.addAttribute("fdRecipes", recipes);
		model.addAttribute("ctRecipes", ctRecipes);
		return "/profile/id.jsp";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("image") MultipartFile file, @RequestParam("description") String description, HttpSession session, RedirectAttributes redirectAttrs) {
		if(file.isEmpty()) {
			redirectAttrs.addFlashAttribute("message", "Upload field cannot be empty");
			return "redirect/profile";
		}
		try {
			Long userId = (Long)session.getAttribute("user__id");
			User user = this.uService.find(userId);
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			String url = "/images/" + file.getOriginalFilename();
			this.pService.uploadPic(user, url, description);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/profile";
	}
}
