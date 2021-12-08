<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 
<html>
<style><%@include file="/WEB-INF/style.css"%></style>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login and Registration form example</title>
 
<link rel="stylesheet" type="text/css" href="login.css">
 
</head>
 
<body>
 
<div id="container">
<form action="login" method="post" id="flogin">
 
<div class="border-box">
<h2>Login Form</h2>
<label for="uname" id="un">Username:</label>
<input type="text" name="user" placeholder="Enter Username" id="uname"><br/>
 
<label for="upass" id="ps">Password:</label>
<input type="password" name="pass" placeholder="Enter Password" id="upass"><br/>
 
<button type="submit" value="Login"  id="submit" onClick="alert('Login Successfully')">Login</button>
 
<a href="registration.jsp">New Member</a>
</div>
 
</form>
</div>
 
</body>
</html>


  