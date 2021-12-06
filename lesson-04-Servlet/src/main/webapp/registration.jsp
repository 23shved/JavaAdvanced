<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style><%@include file="/WEB-INF/style.css"%></style>

<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<body>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Library_building_clipart.svg/1200px-Library_building_clipart.svg.png" height="250px" width="250px"> 

	<form action="registration" method="post">
		<label for="firstName">Your First Name: </label> <input
			name="firstName"> <label for="lastName">Last Name: </label> <input
			name="lastName"> <label for="email">Email: </label> <input
			name="email"> <label for="password">Password: </label> 
			<input name="password"> <input type="submit" value="submit">
	</form>
		
	<a href="index.jsp" >Return to main page	</a>
		
</body>
</html>