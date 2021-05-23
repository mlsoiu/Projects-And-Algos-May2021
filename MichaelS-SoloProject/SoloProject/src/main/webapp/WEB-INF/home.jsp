<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page for Solo Project</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<h1>FoodieGram</h1>
		<h4>Login</h4>
		${loginError}
		<form method = "POST" action = "/login">
			<div class = "form-group">
				<label>Email:</label>
				<input class = "form-control" type = "email" name = "loginEmail">
			</div>
			<div class = "form-group">
				<label>Password:</label>
				<input class = "form-control" type = "password" name = "loginPassword">
			</div>
			<button class = "btn btn-primary">Login</button>
		</form>
		<p>Want in on all the goodness? Register <a href = "/register">here</a>.</p>
	</div>
</body>
</html>