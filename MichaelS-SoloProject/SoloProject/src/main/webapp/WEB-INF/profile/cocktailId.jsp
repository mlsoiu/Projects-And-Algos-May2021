<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FoodieGram Cocktail Recipe Display Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<nav>
			<h4>
				<a href= "/profile">Profile</a> | <a href = "/browse">Browse Recipes</a>
			</h4>
		</nav>
		<h2>${ctRecipe.name}</h2>
		<h4>Cocktail submitted by ${ctRecipe.user.firstName} ${ctRecipe.user.lastName}</h4>
		<p>${ctRecipe.ingredient}</p>
		<p>${ctRecipe.direction}</p>
		<c:if test = "${user.id == ctRecipe.user.id}">
			<button class = "btn btn-danger"><a href= "/profile/ctRecipe/${ctRecipe.id}/delete">DELETE</a></button>
		</c:if>
		<br>
		<c:choose>
			<c:when test = "${ctRecipe.likers.contains(user)}">
				<a href = "/unlikeCocktail/${ctRecipe.id}">un-Like</a>
			</c:when>
			<c:otherwise>
				<a href = "/likeCocktail/${ctRecipe.id}">Like</a>
			</c:otherwise>
		</c:choose>
		<h5>Liked By</h5>
		<ul>
			<c:forEach items = "${ctRecipe.likers}" var = "user">
			<li>${user.firstName} ${user.lastName}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>