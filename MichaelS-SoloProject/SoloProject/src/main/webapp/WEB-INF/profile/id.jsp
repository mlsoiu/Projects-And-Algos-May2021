<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FoodieGram Profile page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<nav>
			<h4>
				<a href = "/profile/addFdRecipe">Add Food Recipe</a> | <a href = "/profile/addCtRecipe">Add Cocktail Recipe</a> | <a href = "/foodTruck">Find a Food Truck</a> | <a href = "/browse">Browse Recipes</a> | <a href = "/logout">Logout</a>
			</h4>
		</nav>
		<br>
		<h2><c:out value = "${currentUser.firstName}"/> <c:out value = "${currentUser.lastName}"/></h2>
		<br>
		<div>
			<h3>Your Food Recipes</h3>
			<ul>
				<c:if test = "${empty currentUser.fdRecipes}">
					You haven't added any recipes yet!
				</c:if>
				<c:forEach items = "${fdRecipes}" var = "fdRecipe">
				<li><a href = "/profile/fdRecipe/${fdRecipe.id}">${fdRecipe.name}</a></li>
				</c:forEach>
			</ul>
		</div>
		<hr>
		<div>
			<h3>Your Cocktail Recipes</h3>
			<ul>
				<c:if test = "${empty currentUser.ctRecipes}">
					You haven't added any cocktails yet!
				</c:if>
				<c:forEach items = "${ctRecipes}" var = "ctRecipe">
				<li><a href = "/profile/ctRecipe/${ctRecipe.id}">${ctRecipe.name}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>