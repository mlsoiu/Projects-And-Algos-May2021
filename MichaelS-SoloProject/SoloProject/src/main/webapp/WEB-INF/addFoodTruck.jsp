<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FoodieGram Add A Food Truck</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<nav>
			<h4><a href = "/foodTruck">Return to Food Trucks</a></h4>
		</nav>
		<h2>Add Your Favorite Food Truck</h2>
		<br>
		<form:form action = "/addFoodTruck" method = "POST" modelAttribute = "foodTruck">
			<div class = "form-group">
				<form:label path = "name">Name:</form:label>
				<form:errors path = "name"/>
				<form:input class = "text" path = "name"/>
			</div>
			<div class = "form-group">
				<form:label path = "address">Known Address:</form:label>
				<form:errors path = "address"/>
				<form:input class = "text" path = "address"/>
			</div>
			<div class = "form-group">
				<form:label path = "cuisine">Cuisine:</form:label>
				<form:errors path = "cuisine"/>
				<form:input class = "text" path = "cuisine"/>
			</div>
			<div class = "form-group">
				<form:label path = "rating">Rating(out of 5):</form:label>
				<form:errors path = "rating"/>
				<form:input class = "text" path = "rating"/>
			</div>
			<button class = "btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>