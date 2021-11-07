<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

.button:link, .button:visited {
	background-color: white;
	color: black;
	border: 2px solid #16a085;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

.button:hover, .button:active {
	background-color: #16a085;
	color: white;
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
		<h1>STUDENT COURSE LIST</h1>
		<h3 style="color: green">${message}</h3>
		<form action="searchStudentCourseById" style="margin-bottom: 10px; text-align: center">
		<input type="number" name="id" placeholder="Enter student ID">
		<input type="text" name="cId" placeholder="Enter course ID">
		<input type="submit" value="Search Mark">
	</form>
	<form action="studentsInACourse" style="margin-bottom: 10px; text-align: center">
		<input type="text" name="name" placeholder="Enter course ID">
		<input type="submit" value="Search">
	</form>
		<table>
			<tr>
				<th>Id</th>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Course Id</th>
				<th>Mid-Term Mark</th>
				<th>Final Mark</th>
				<th>Attendance Mark</th>
			</tr>

			<c:forEach items="${list}" var="sc">
				<tr>
					<td>${sc.scId}</td>
					<td>${sc.stuId.stuId}</td>
					<td>${sc.stuId.fullName}</td>
					<td>${sc.cId.cId}</td>
					<td>${sc.midTermMark}</td>
					<td>${sc.finalMark}</td>
					<td>${sc.attendanceMark}</td>
					<td><a href="detailStudentCourse?scId=${sc.scId}">detail</a></td>
					<td><a href="deleteStudentCourse?scId=${sc.scId}"
						onclick="return confirm('Are you sure?')">delete</a></td>
				</tr>
			</c:forEach>
		</table>

		<a class="button" href="initInsertSC" style="margin: 15px">Add New
			Student into a Course</a>
	</div>
</body>
</html>