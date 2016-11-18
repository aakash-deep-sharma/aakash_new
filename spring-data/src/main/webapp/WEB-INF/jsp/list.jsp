<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="css/app.css" />" rel="stylesheet"
	type="text/css">
<title>list</title>
</head>
<body class="security-app">
	<div class="details">

		<h2>Students List</h2>
		
	</div>

	<div class="lc-block">
		<h1>
			Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
		</h1>
		
		<table>
		<tr>
			 <th>Name</th>
			 <th>Roll No.</th>
		</tr>
		<c:forEach items="${studentList}" var="student">
		<tr>
		<td>${student.studentName}</td>
		<td>${student.rollNo}</td>
		</tr>
		</c:forEach>
		</table>
		
		<form action="/logout" method="post">
			<input type="submit" class="button red big" value="Sign Out" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>

</body>
</html>