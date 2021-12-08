<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!doctype html>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<h1>Hello JSP</h1>


	<form action="registration" method="post">
		<label for="bookName">Book Name: </label> <input
			name="bookName"> <label for="price">Price: </label> <input
			name="price"> <label for="link">Link: </label> <input
			name=""link"">  <input type="submit" value="submit">
			<%			request.getRequestDispatcher("jdbc2").forward(request, response);
 %>
	</form>

</table>
</body>
</html>
