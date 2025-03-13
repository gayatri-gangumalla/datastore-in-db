<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>


<body style="background-image:url(./image.jpeg); background-position:center ;">
<div>
    <h1 align="center">Student Registration form</h1>
    <form action="reg" method="post"  id="Form" align="center">
        first Name: <input type="text" name="fname" id="name" required><br><br>
        <p id="f2"> </p>
        last Name: <input type="text" name="lname" id="lname" required> <br> <br>
        <p id="f2"> </p>
        student id:<input type="number" name="no" id="id1" required>  <br> <br>
        <p id="id"></p>
        Password: <input type="password" name="password" id="pass" required><br><br>
        <p id="pass"></p>
        <button type="submit" value="Register">Register</button>
         <p> you already have an account</p>
         <a href="login.jsp">login here</a>
    </form>
</div>

   
   
   
   
   
 
   
</body>
</html>