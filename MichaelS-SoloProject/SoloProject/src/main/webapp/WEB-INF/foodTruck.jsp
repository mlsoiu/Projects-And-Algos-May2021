<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FoodieGram Food Trucks</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<nav>
			<h4>
				<a href = "/profile/addFdRecipe">Add Food Recipe</a> | <a href = "/profile/addCtRecipe">Add Cocktail Recipe</a> | <a href = "/browse">Browse Recipes</a> | <a href = "/logout">Logout</a>
			</h4>
		</nav>
		<br>
		<h1>FOOD TRUCKS!</h1>
		<br>
		<h3>Find a Food Truck Nearby</h3>
		<br>
		<table class = "table">
			<thead class = "table-dark">
				<tr>
					<td>Name</td>
					<td>Known Address</td>
					<td>Cuisine</td>
					<td>Rating</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items = "${foodTruck}" var = "foodTruck">
				<tr>
					<td>${foodTruck.name}</td>
					<td>${foodTruck.address}</td>
					<td>${foodTruck.cuisine}</td>
					<td>${foodTruck.rating}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<h3>Know a good Food Truck?</h3>
		<p><a href = "/addFoodTruck">Add it to the list</a>
	</div>
</body>
</html>