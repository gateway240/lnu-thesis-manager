<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<style>
			.error {
				padding: 15px;
				margin-bottom: 20px;
				border: 1px solid transparent;
				border-radius: 4px;
				color: #a94442;
				background-color: #f2dede;
				border-color: #ebccd1;
			}
			
			.msg {
				padding: 15px;
				margin-bottom: 20px;
				border: 1px solid transparent;
				border-radius: 4px;
				color: #31708f;
				background-color: #d9edf7;
				border-color: #bce8f1;
			}
		</style>
		<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>
	
	<body>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
			    <ul class="navbar-nav">
			    
			      <li class="nav-item">
			        <a class="nav-link" href='<c:url value="/user/signup" />'>Registration</a>
			      </li>
			    
			      <li class="nav-item">
			        <a class="nav-link active" href="#">Login</a>
			      </li>
			    </ul>
		  	</div>	
		</nav>
		<div class="container">
		<h1>Login</h1>
		<c:if test="${not empty error}"><div class="error">${error}</div></c:if>
		<c:if test="${not empty msg}"><div class="msg">${msg}</div></c:if>
		<form name="loginForm" action='<c:url value="j_spring_security_check" />' method="post">
	<!-- 	  <div class="form-group">
		    <label for=email>Email</label>
		    <input type="text" class="form-control" id="email" name='email' placeholder="Enter Email">
		  </div> -->
		  
		  <div class="form-group">
		    <label for="username">Username</label>
		    <input type='text' class="form-control" name='username' placeholder="Enter username">
		  </div>
		  
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="text" class="form-control" id="password" name='password' placeholder="Enter Password">
		    
		  </div>
		  
	  	  <div class="checkbox">
		  		<label><input type="checkbox" name="remember-me"> Remember me</label>
		  </div>

		  <button name="submit" value="submit" type="submit" class="btn btn-primary">Submit</button>
<%-- 		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
		</form>
	</div>
</body>
</html>