<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1,shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student Management</title>
</head>
<body>
	<div class="container">
		<h3>Student Fest</h3>
		<hr>
		<form action="/StudentManagement/student">
			<a href="/StudentManagement/student/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add Record</a>
			
		</form>
		<table class="table table-border table-striped">
			<thead class="thead-dark">
				<tr>
				<th>Name</th>
				<th>Department</th>
				<th>Country</th>
				<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${student}" var="student">
			<tr>
				<td><c:out value="${student.name}"></c:out></td>
				<td><c:out value="${student.department}"></c:out></td>
				<td><c:out value="${student.country}"></c:out></td>
				<td>
					<a href="/StudentManagement/student/showFormForUpdate?studentId=${student.id}" class="btn btn-info btn-sm">Update</a>
                    <a href="/StudentManagement/student/delete?studentId=${student.id}" class="btn btn-danger btn-sm"
                                    onClick="if(!(confirm('Are you sure you want to delete'))) return false">Delete</a>
               	</td>
			</tr>
			</c:forEach>
			
			</tbody>
			
		</table>
	</div>
</body>
</html>