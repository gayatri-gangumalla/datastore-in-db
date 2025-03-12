<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:pink;">
<h1 align="center">welcome to student id:<label><%= request.getAttribute("stdid") %></label></h1>

<a href="NewFile.jsp">logout</a>
</body>
</html>