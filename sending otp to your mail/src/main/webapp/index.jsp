<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image:url(./image4.jpg); background-position:center ;background-size:1500px;" >

        <style>
        * {
            margin:200;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            padding: 10px 20px;
        }
        .navbar .logo {
            color: white;
            font-size: 24px;
            font-weight: bold;
             padding: 15px 20px;
        }
        .navbar ul {
            list-style: none;
            display: flex;
        }
        .navbar ul li {
            margin: 0 15px;
        }
        .navbar ul li a {
            color: white;
            text-decoration: none;
            font-size: 18px;
        }
        .navbar ul li a:hover {
            color: #f4a261;
        }
    </style>

    <nav class="navbar">
        <div class="logo">furniter world</div>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="index.jsp">Contact</a></li>
        </ul>
    </nav>


        
   
    <div class="form-container" >

<form action="Userverify" method="post">

            <div align="center"> <h1>Enter the Credentials: </h1>
           
            
           
             
            <label for="sMail"> Email :</label> <br>
            <input id="sMail" type="email" name="useremail"> <br>
            
           
            
            <label for="rMail">user name :</label> <br>
            <input id="rMail" type="text" name="username"> <br>
            <br>
           <input type="submit" name="reg">
             
            </div>
        </form>
        </div>
</body>
</html>