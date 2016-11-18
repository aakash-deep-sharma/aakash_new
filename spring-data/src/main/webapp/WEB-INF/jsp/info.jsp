<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="css/app.css" />" rel="stylesheet"
	type="text/css">
<title>Info</title>
</head>
<body class="security-app">
	<div class="details">

		<h2>Spring Security - JDBC Authentication</h2>
		
	</div>

	

	<div class="lc-block">
		<h1>
			Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
		</h1>
		<div class="alert-normal">
			Click <a href="<spring:url value='/list' />">here</a> to see students list.
		</div>
		<div class="alert-normal">
			<form action="/student">
				<label>Select State</label>
				<select name="state">
					<c:forEach var="state" items="${stateList}">
				  		<option value="${state}" >${state}</option>
				  	</c:forEach>
				</select>
				<input type="submit" value="GET STUDENT">
			</form>
		</div>
		
		<c:if test="${not empty stateStudentList}">
			<table>
				<tr>
					 <th>Name</th>
					 <th>Roll No.</th>
				</tr>
				<c:forEach items="${stateStudentList}" var="student">
					<tr>
					<td>${student.studentName}</td>
					<td>${student.rollNo}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<form action="/logout" method="post">
			<input type="submit" class="button red big" value="Sign Out" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>

</body>
</html>
