<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Login Here </title>

<style>
 
body {
	align-items:center;
	background-color:#AEFD6C;	
	font-family: 'Arial';
	justify-content: center;
	height: 100vh;
	margin: 0;
	background-color: #AEFD6C;
	background-size: cover;
	flex-direction: column;
	display: flex;
	color: #333;	
}
 .container {
 	width: 600px;
 	padding: 20px;
 	border-radius: 10px;
 	box-shadow: 10px;
 	background-color: white;
 	text-align: center; 
 	height: 200px;
 }
 
 a {
 	margin: 0 10px;
 	text-decoration: none;
 	color:blue;
 	font-weight: bold; 
 }
 
</style>

</head>

<body>

<div  class="container">
<center>

<form action="LogServlet" method="post">

<label for="username"> UserName: </label>
<input type="text" name="username" id="username" required><br>

<label for="password"> Password: </label>
<input type="text" name="password" id="password" required> <br>
<button type="submit"> Login </button>

</form>

<p> <a href="Index.html"> Back to Home </a></p>
 </center>
 </div>
</body>
</html>