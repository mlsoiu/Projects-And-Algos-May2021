<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FoodieGram Add Cocktail Recipe</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
	<nav>
	<h4>
		<a href = "/profile">Profile</a> | <a href = "/profile/addFdRecipe">Add Food Recipe</a> | <a href = "/foodTruck">Find a Food Truck</a> | <a href = "/browse">Browse Recipes</a>
	</h4>
	</nav>
		<h3>Add a Cocktail Recipe</h3>
		<form:form action = "/profile/addCtRecipe" method = "POST" modelAttribute = "ctRecipe">
			<div class = "form-group">
				<form:label path = "name">Name:</form:label>
				<form:errors path = "name"/>
				<form:input class = "textarea" path = "name"/>
			</div>
			<div class = "form-group">
				<form:label path = "ingredient">Ingredients:</form:label>
				<form:errors path = "ingredient"/>
				<form:input class = "textarea" path = "ingredient" placeholder = "Ex. 1 measure Vodka, 1/2 measure Vermouth"/>
			</div>
			<div class = "form-group">
				<form:label path = "direction">Directions:</form:label>
				<form:errors path = "direction"/>
				<form:input class = "textarea" path = "direction"/>
			</div>
			<button class ="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>