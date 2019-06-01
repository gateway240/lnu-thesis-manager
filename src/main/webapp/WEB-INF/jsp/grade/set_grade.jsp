<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Set Grade</title>
		<link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sticky-footer-navbar/">
		<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>
	
	<body class="d-flex flex-column h-100">
		<jsp:include page="../nav.jsp"></jsp:include>
	
		<div class="container text-center">
			<h1>Grades</h1>
			<form:form method="POST" action="${contextPath}/grade/setGrade" modelAttribute="grade">
				 <div class="form-group text-left">
					 <form:label path="user.username">Username</form:label>
					 <form:input class="form-control" path="user.username"></form:input>
				 </div>
				  <div class="form-group text-left">
					  <form:label path="documentType">Document Type</form:label>
					  <form:select class="form-group browser-default custom-select custom-select-lg mb-3" path="documentType">
						  <form:option value="Project Description" selected="selected" path="documentType">Project Description</form:option>
						  <form:option value="Project Plan" path="documentType">Project Plan</form:option>
						  <form:option value="Final Report" path="documentType">Final Report</form:option>
					  </form:select>
				  </div>
				  <div class="form-group text-left">
					  <form:label path="grade">Grade</form:label>
					  <form:input class="form-control" path="grade"></form:input>
				  </div>
					<input type="submit" class="btn btn-dark" value="Submit"/>
			</form:form>
			
			<h1>All Grades</h1>
		
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Firstname</th>
			      <th scope="col">Lastname</th>
	<!-- 		      <th scope="col">Email</th> -->
	<!-- 		      <th scope="col">Coordinator</th> -->
	<!-- 		      <th scope="col">Supervisor</th> -->
				  <th scope="col">Document Type</th>
				  <th scope="col">Grade</th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach items="${grades}" var="grade">
					  <tr>
						  <td>${grade.user.firstName}</td>
						  <td>${grade.user.lastName}</td>
						  <td>${grade.documentType}</td>
						  <td>${grade.grade}</td>
					  </tr>
				  </c:forEach>
			  </tbody>
			</table>
		</div>
		
		<footer class="footer mt-auto py-3">
		  <div class="container text-center">
		    <span >&copy; 2019 | Team B | <a href="https://lnu.se/">LNU</a></span>
		  </div>
		</footer>
	</body>
</html>