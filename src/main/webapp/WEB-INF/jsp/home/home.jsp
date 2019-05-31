<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LNU Thesis Management System</title>
		<link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sticky-footer-navbar/">
		<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>
	
	<body class="d-flex flex-column h-100">
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
			    <ul class="navbar-nav">
			    
			      <li class="nav-item">
			        <a class="nav-link" href='<c:url value="/logout" />'>Logout</a>
			      </li>
			      
			      <li class="nav-item">
			        <a class="nav-link" href='<c:url value="/user/list" />'>Users</a>
			      </li>
			    </ul>
		  	</div>	
		</nav>
	
		  <div class="container text-center">
		  <h1>Welcome to LNU Thesis Management System,
		    <span id="user">
			  <c:if test="${pageContext.request.userPrincipal.name != null }">
			 	${pageContext.request.userPrincipal.name }
			  </c:if>
			</span>!
		  </h1>
		    <p class="lead"></p>
		  </div>
		
		<img src="https://cdn.pixabay.com/photo/2016/03/31/15/31/academia-1293362_960_720.png" class="img-fluid mx-auto d-block" alt="Responsive image">
		
		<footer class="footer mt-auto py-3">
		  <div class="container text-center">
		    <span >&copy; 2019 | Team B | <a href="https://lnu.se/">LNU</a></span>
		  </div>
		</footer>
	</body>
</html>