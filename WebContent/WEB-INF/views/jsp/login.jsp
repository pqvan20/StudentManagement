<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: #34495e;
}

.box {
	padding: 40px;
	position: absolute;
	top: 40%;
	left: 50%;
	transform: translate(-50%, -50%);
	background: #191919;
	text-align: center;
	width: 300px;
	border-radius: 24px;
}

.box h1 {
	color: white;
	text-transform: uppercase;
	font-weight: 500;
}

.box input[type="text"], .box input[type="password"] {
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	outline: none;
}

.box input[type="text"]:focus, .box input[type="password"]:focus {
	width: 280px;
	border-color: #2ecc71;
}

.box input[type="submit"] {
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #2ecc71;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;
}

.box input[type="submit"]:hover {
	background: #2ecc71;
}

.search {
	margin-top: 420px;
}

.search input[type="submit"] {
	border: 0;
	background: none;
	display: block;
	margin: 10px auto;
	text-align: center;
	border: 2px solid #2ecc71;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;
}

.number {
	border: 0;
	background: none;
	display: block;
	margin: 10px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	outline: none;
}
</style>
</head>
<body>
	<h3 style="color: lightblue; text-align: center;">${fail}</h3>
	<form action="login" class="box" method="post">
		<input type="text" name="username" placeholder="Username"> <input
			type="password" name="pass" placeholder="Password"> <input
			type="submit" value="Login">
	</form>

	<form class="search" action="searchStudentCourse_Student">
		<input class="number" type="number" name="id"
			placeholder="Enter student ID"> <input class="number"
			type="text" name="cId" placeholder="Enter course ID"> <input
			type="submit" value="Search Mark">
	</form>

</body>
</html>