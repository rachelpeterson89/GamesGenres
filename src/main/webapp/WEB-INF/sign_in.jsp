<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<div class="container">
	<div class="row">
		<form:form class="col-sm-8" action="/register" method="post" modelAttribute="registerUser">
			<h2>Register</h2>
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>First Name:</label>
					<form:input path="firstName" class="form-control" />
					<form:errors path="firstName" class="text-danger" />
				</div>
				
				<div class="col-sm-6 form-group">
					<label>Last Name:</label>
					<form:input path="lastName" class="form-control" />
					<form:errors path="lastName" class="text-danger" />
				</div>
			</div>
			
			<div class="form-group">
				<label>Email:</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			
			<div class="row">
				<div class="col-sm-6 form-group">
					<label>Password:</label>
					<form:input type="password" path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				
				<div class="col-sm-6 form-group">
					<label>Confirm Password:</label>
					<form:input type="password" path="confirmPassword" class="form-control" />
					<form:errors path="confirmPassword" class="text-danger" />
				</div>
			</div>
			
			<input type="submit" value="Register" class="btn btn-primary" />
		</form:form>
		

		<form:form class="col-sm-4" action="/login" method="post" modelAttribute="loginUser">			
			<h2>Login</h2>
			<div class="form-group">
				<label>Email:</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			
			<div class="form-group">
				<label>Password:</label>
				<form:input type="password" path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
			
			<input type="submit" value="Login" class="btn btn-primary" />
		</form:form>

	</div>
	</div>
</body>
</html>