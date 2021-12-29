<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>	
</head>


<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header navbar-brand">Spring MVC</div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">All participants</a></li>
                <li><a href="new">New Participant</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <c:choose>
            <c:when test="${mode == 'VIEW'}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>E-mail</th>
                            <th>Level</th>
                            <th>Primary skill</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="participant" items="${participants}">
                            <tr>
                                <td>${participant.id}</td>
                                <td>${participant.name}</td>
                                <td>${participant.email}</td>
                                <td>${participant.level}</td>
                                <td>${participant.primarySkill}</td>
                                <td><a href="update?id=${participant.id}">edit</a></td>
                                <td><a href="delete?id=${participant.id}">delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>

            <c:when test="${mode == 'EDIT' || mode == 'CREATE'}">
                <form action="save" method="POST">

                    <input type="hidden" value="${participant.id}" class="form-control" id="id" name="id">

                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" value="${participant.name}">
                    </div>
                    <div class="form-group">
                        <label for="email">E-mail:</label>
                        <input type="text" class="form-control" id="email" name="email" value="${participant.email}">
                    </div>
                    <div class="form-group">
                        <label for="level">Level:</label>
                        <input type="text" class="form-control" id="level" name="level" value="${participant.level}">
                    </div>
                    <div class="form-group">
                        <label for="primarySkill">Primary skill:</label>
                        <input type="text" class="form-control" id="primarySkill" name="primarySkill" value="${participant.primarySkill}">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </c:when>
        </c:choose>
    </div>
</body>
</html>