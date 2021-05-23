package com.michaelsoiu.soloproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(max = 20)
	private String firstName;
	@NotEmpty
	@Size(max = 20)
	private String lastName;
	@Email
	@NotEmpty
	private String email;
	@Size(min = 8)
	private String password;
	@Transient
	private String confirmPassword;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM--DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM--DD HH:mm:ss")
	private Date updatedAt;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<FdRecipe> fdRecipes;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<CtRecipe> ctRecipes;
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Picture> pics;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch  = FetchType.LAZY)
	private List<FoodTruck> foodTrucks;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "likes",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "fdRecipe_id")
			)
	private List<FdRecipe> recipesLiked;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "cocktailLikes",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "ctRecipe_id")
			)
	private List<CtRecipe> cocktailsLiked;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "follows",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "following_id")
			)
	private List<User> myFollowers;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "follows",
			joinColumns = @JoinColumn(name = "following_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> userFollows;
	
	public User() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public List<FdRecipe> getFdRecipes() {
		return fdRecipes;
	}

	public void setFdRecipes(List<FdRecipe> fdRecipes) {
		this.fdRecipes = fdRecipes;
	}

	public List<FdRecipe> getRecipesLiked() {
		return recipesLiked;
	}

	public void setRecipesLiked(List<FdRecipe> recipesLiked) {
		this.recipesLiked = recipesLiked;
	}
	
	/*public List<CtRecipe> getCocktails() {
		return ctRecipes;
	}

	public void setCocktails(List<CtRecipe> ctRecipes) {
		this.ctRecipes = ctRecipes;
	}
*/
	public List<CtRecipe> getCocktailsLiked() {
		return cocktailsLiked;
	}

	public void setCocktailsLiked(List<CtRecipe> cocktailsLiked) {
		this.cocktailsLiked = cocktailsLiked;
	}

	public List<Picture> getPics() {
		return pics;
	}

	public void setPics(List<Picture> pics) {
		this.pics = pics;
	}

	public List<User> getMyFollowers() {
		return myFollowers;
	}

	public void setMyFollowers(List<User> myFollowers) {
		this.myFollowers = myFollowers;
	}

	public List<User> getUserFollows() {
		return userFollows;
	}

	public void setUserFollows(List<User> userFollows) {
		this.userFollows = userFollows;
	}
	
	public List<CtRecipe> getCtRecipes() {
		return ctRecipes;
	}

	public void setCtRecipes(List<CtRecipe> ctRecipes) {
		this.ctRecipes = ctRecipes;
	}

	public List<FoodTruck> getFoodTrucks() {
		return foodTrucks;
	}

	public void setFoodTrucks(List<FoodTruck> foodTrucks) {
		this.foodTrucks = foodTrucks;
	}
}
