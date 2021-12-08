<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style><%@include file="/WEB-INF/style.css"%></style>

<head>
<meta charset="ISO-8859-1">
<title>Hello</title>

</head>
<body style="background-color: lightgrey;">
	<jsp:include page="header.jsp"></jsp:include>

<div id="container">
 <img src="https://softechwebsolutions.com/images/new/Library/library.png" height="150px" width="150px"> 


 
 <form action="login" method="post" id="flogin">
 <div class="border-box">
 
<label for="email" id="un">Your Email:</label>
<input type="text" name="email" placeholder="Enter your email" id="uname"><br/>
  
<label for="password" id="ps">Password:</label>
<input type="password" name="password" placeholder="Enter Password" id="upass"><br/>
<button type="submit" value="submit"  id="submit">Login</button>
<a href="registration.jsp" >I'm new one, create account	</a>

</div>

 </form>
 </div>
 
 
 
</body>
</html>