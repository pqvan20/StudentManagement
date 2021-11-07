<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>
<style>
body {
	margin: 0;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 25%;
	background-color: #f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

li a {
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}

li a.active {
	background-color: #16a085;
	color: white;
}

li a:hover:not(.active) {
	background-color: #555;
	color: white;
}

body {
	padding: 0px;
	margin: 0;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
}

table {
	margin: auto;
	border-collapse: collapse;
	border: 1px solid #bdc3c7;
	box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2), -1px -1px 8px
		rgba(0, 0, 0, 0.2);
}

tr {
	transition: all .2s ease-in;
	cursor: pointer;
}

th, td {
	padding: 12px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

#header {
	background-color: #16a085;
	color: #fff;
}

h1 {
	font-weight: 600;
	text-align: center;
	background-color: #16a085;
	color: #fff;
	padding: 10px 0px;
}

tr:hover {
	background-color: #f5f5f5;
	transform: scale(1.02);
	box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2), -1px -1px 8px
		rgba(0, 0, 0, 0.2);
}

@media only screen and (max-width: 768px) {
	table {
		width: 90%;
	}
}
</style>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
	<ul>
		<li><a class="active" href="listNotification"><i
				class="fas fa-home"></i> Home page</a></li>
		<li><a href="listStudent"><i class="fas fa-user-graduate"></i>
				Student</a></li>
		<li><a href="listCourse"><i class="fas fa-chalkboard"></i>
				Course</a></li>
		<li><a href="listStudentCourse"><i class="fas fa-school"></i>
				Student-Course</a></li>
		<li><a href="listTeacher"><i
				class="fas fa-chalkboard-teacher"></i> Teacher</a></li>
		<li><a href="listAccount"><i class="fas fa-user-circle"></i>
				Account</a></li>
		<li><a href="logout"><i class="fas fa-sign-out-alt"></i>Log-out</a></li>
	</ul>

	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
		<h1>ACCOUNT DETAIL</h1>
		<table>
			<tr>
				<td>Account Id:</td>
				<td>${a.id}</td>
			</tr>
			<tr>
				<td>User name:</td>
				<td>${a.user_name}</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>${a.pass}</td>
			</tr>
			<tr>
				<td>Status:</td>
				<td>${a.status?"Admin":"Teacher"}</td>
			</tr>
			<tr>
				<td><a href="initUpdateA?id=${a.id}">update</a></td>
				<td><a href="listAccount">back</a></td>
			</tr>
		</table>
	</div>


</body>
</html>