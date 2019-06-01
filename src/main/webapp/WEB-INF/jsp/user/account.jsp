<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<spring:url value="/user/saveAccount" var="saveAccountURL" />
	<spring:url value="/user/deleteAccount" var="deleteAccountURL" />
		<jsp:include page="../nav.jsp"></jsp:include>	
	
		<div class="container text-center">
			<form:form method="post" modelAttribute="user" action="${saveAccountURL}">
  			<form:hidden path="username"/>
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Firstname</th>
			      <th scope="col">Lastname</th>
			      <th scope="col">Username</th>
			      <th scope="col">Email</th>
	<!-- 		      <th scope="col">Coordinator</th> -->
	<!-- 		      <th scope="col">Supervisor</th> -->
				  <th scope="col">Password</th>
			    </tr>
			  </thead>
			  <tbody>
			    
			    <tr>
			      <td><form:input class="form-control" path="firstName"></form:input></td>
			      <td><form:input class="form-control" path="lastName"></form:input></td>
			      <td>${user.username}</td>
			      <td><form:input class="form-control" path="email"></form:input></td>
			      <td><form:input class="form-control" path="password"></form:input></td> 
			      <td scope="col"></td>
			    </tr>
			
			  </tbody>
			</table>
			<td><button type="submit" class="btn btn-dark">Submit changes</button></td>
			
			<p>${msg}</p>
			
			</form:form>
			
			<form:form method="post" modelAttribute="user" action="${deleteAccountURL}">
  			<form:hidden path="username"/>
  				<button type="submit" class="btn btn-dark">Delete account</button>
  			</form:form>
		</div>
		
		<footer class="footer mt-auto py-3">
		  <div class="container text-center">
		    <span >&copy; 2019 | Team B | <a href="https://lnu.se/">LNU</a></span>
		  </div>
		</footer>
	</body>
</html>