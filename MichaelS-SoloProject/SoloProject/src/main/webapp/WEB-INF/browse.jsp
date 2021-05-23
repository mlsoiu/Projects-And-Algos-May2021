<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Browse All Recipes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<nav>
			<h4><a href = "/profile">Profile</a> | <a href = "/profile/addFdRecipe">Add Food Recipe</a> | <a href = "/profile/addCtRecipe">Add Cocktail Recipe</a> | <a href = "/foodTruck">Find a Food Truck</a></h4>
		</nav>
		<br>
		<h1>All Food Recipes</h1>
		<br>
		<ul>
			<c:forEach items  = "${fdRecipe}" var = "fdRecipe">
			<li><a href = "/profile/fdRecipe/${fdRecipe.id}">${fdRecipe.name}</a></li>
			</c:forEach>
		</ul>
		<hr>
		<br>
		<h1>All Cocktail Recipes</h1>
		<br>
		<ul>
			<c:forEach items = "${ctRecipe}" var = "ctRecipe">
			<li><a href = "/profile/ctRecipe/${ctRecipe.id}">${ctRecipe.name}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>