package com.michaelsoiu.soloproject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.michaelsoiu.soloproject.models.CtRecipe;
import com.michaelsoiu.soloproject.models.FdRecipe;
import com.michaelsoiu.soloproject.models.FoodTruck;
import com.michaelsoiu.soloproject.models.User;
import com.michaelsoiu.soloproject.services.CtRecipeService;
import com.michaelsoiu.soloproject.services.FdRecipeService;
import com.michaelsoiu.soloproject.services.FoodTruckService;
import com.michaelsoiu.soloproject.services.UserService;
import com.michaelsoiu.soloproject.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired
	private FdRecipeService frService;
	@Autowired
	private CtRecipeService cService;
	@Autowired
	private FoodTruckService tService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String index() {
		return "home.jsp";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/profile";
	}
	
	@GetMapping("/register")
	public String registration(@ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "home.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/profile";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/profile/addFdRecipe")
	public String createFRecipe(@ModelAttribute("fdRecipe") FdRecipe fdRecipe) {
		return "/profile/addFRecipe.jsp";
	}
	
	@PostMapping("/profile/addFdRecipe") 
	public String addFdRecipe(@Valid @ModelAttribute("fdRecipe") FdRecipe fdRecipe, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		User user = this.uService.find(userId);
		if(result.hasErrors()) {
			return "/profile/addFRecipe.jsp";
		}
		fdRecipe.setUser(user);
		this.frService.create(fdRecipe);
		return "redirect:/profile";
	}
	
	@GetMapping("/profile/fdRecipe/{id}")
	public String displayFdRecipe(HttpSession session, @PathVariable("id") Long id, Model model) {
		Long userId = (Long)session.getAttribute("user__id");
		User user = this.uService.find(userId);
		model.addAttribute("user", user);
		model.addAttribute("fdRecipe", this.frService.getOneRecipe(id));
		return "/profile/foodId.jsp";
	}
	
	@GetMapping("/profile/fdRecipe/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		this.frService.delete(id);
		return "redirect:/profile";
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long fdRecipeId = id;
		User liker = this.uService.find(userId);
		FdRecipe likedRecipe = this.frService.getOneRecipe(fdRecipeId);
		this.frService.likeFdRecipe(liker, likedRecipe);
		return "redirect:/profile/fdRecipe/{id}";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long fdRecipeId = id;
		User liker = this.uService.find(userId);
		FdRecipe likedRecipe = this.frService.getOneRecipe(fdRecipeId);
		this.frService.unlikeFdRecipe(liker, likedRecipe);
		return "redirect:/profile/fdRecipe/{id}";
	}
	
	@GetMapping("/profile/addCtRecipe")
	public String createCocktail(@ModelAttribute("ctRecipe") CtRecipe ctRecipe) {
		return "/profile/addCocktail.jsp";
	}
	
	@PostMapping("/profile/addCtRecipe") 
	public String addCocktail(@Valid @ModelAttribute("ctRecipe") CtRecipe ctRecipe, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		User user = this.uService.find(userId);
		if(result.hasErrors()) {
			return "/profile/addCocktail.jsp";
		}
		ctRecipe.setUser(user);
		this.cService.create(ctRecipe);
		return "redirect:/profile";
	}
	
	@GetMapping("/profile/ctRecipe/{id}")
	public String displayCtRecipe(HttpSession session, @PathVariable("id") Long id, Model model) {
		Long userId = (Long)session.getAttribute("user__id");
		User user = this.uService.find(userId);
		model.addAttribute("user", user);
		model.addAttribute("ctRecipe", this.cService.getOneCocktail(id));
		return "/profile/cocktailId.jsp";
	}
	
	@GetMapping("/profile/ctRecipe/{id}/delete")
	public String deleteCocktail(@PathVariable("id") Long id) {
		this.frService.delete(id);
		return "redirect:/profile";
	}
	
	@GetMapping("/likeCocktail/{id}")
	public String likeCocktail(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long ctRecipeId = id;
		User liker = this.uService.find(userId);
		CtRecipe likedCocktail = this.cService.getOneCocktail(ctRecipeId);
		this.cService.likeCocktail(liker, likedCocktail);
		return "redirect:/profile/fdRecipe/{id}";
	}
	
	@GetMapping("/unlikeCocktail/{id}")
	public String unlikeCocktail(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long ctRecipeId = id;
		User liker = this.uService.find(userId);
		CtRecipe likedCocktail = this.cService.getOneCocktail(ctRecipeId);
		this.cService.unlikeCocktail(liker, likedCocktail);
		return "redirect:/profile/ctRecipe/{id}";
	}
	
	@GetMapping("/browse")
	public String browse(HttpSession session, @ModelAttribute("fdRecipe") FdRecipe fdRecipe, @ModelAttribute("ctRecipe") CtRecipe ctRecipe, Model model) {
		Long userId = (Long)session.getAttribute("user__id");
		User user = this.uService.find(userId);
		List<FdRecipe> fdRecipes = this.frService.getAllFdRecipes();
		List<CtRecipe> ctRecipes = this.cService.getAllCocktails();
		model.addAttribute("user", user);
		model.addAttribute("allUsers", this.uService.allUsers());
		model.addAttribute("fdRecipe", fdRecipes);
		model.addAttribute("ctRecipe", ctRecipes);
		return "browse.jsp";
	}
	
	@GetMapping("/foodTruck")
	public String trucks(HttpSession session, @ModelAttribute("foodTruck") FoodTruck foodTruck, Model model) {
		Long userId = (Long)session.getAttribute("user__id");
		User user = this.uService.find(userId);
		List<FoodTruck> foodTrucks = this.tService.getAllTrucks();
		model.addAttribute("user", user);
		model.addAttribute("allUsers", this.uService.allUsers());
		model.addAttribute("foodTruck", foodTrucks);
		return "foodTruck.jsp";
	}
	
	@GetMapping("/addFoodTruck")
	public String createTruck(@ModelAttribute("foodTruck") FoodTruck foodTruck) {
		return "/addFoodTruck.jsp";
	}
	
	@PostMapping("/addFoodTruck")
	public String addTruck(@Valid @ModelAttribute("foodTruck") FoodTruck foodTruck, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		User user = this.uService.find(userId);
		if(result.hasErrors()) {
			return "/addfoodTruck.jsp";
		}
		foodTruck.setUser(user);
		this.tService.create(foodTruck);
		return "redirect:/foodTruck";
	}
}
