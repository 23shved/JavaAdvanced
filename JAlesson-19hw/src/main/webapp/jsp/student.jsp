<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>

    <div class="container">
        <div class="container">
            <div class="row">
                <div class="column" style="width: 33.3%">
                    <div class="card" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); margin-bottom: 16px; padding: 8px 8px;">
                        <c:if test="${student.fileType=='image/jpeg'}">
							<img width="100%" src="data:image/jpeg;base64,${photo}" alt="${student.firstName} ${student.lastName}">
						</c:if>
                        <div class="container">
                            <h2>${student.firstName} ${student.lastName}</h2>
                            <p class="title"><strong>Age:</strong> ${student.age} y.o.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>