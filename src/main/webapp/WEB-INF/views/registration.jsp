<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration</title>
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
			        <a class="nav-link" href="/thesis">Home</a>
			      </li>
			    
			      <li class="nav-item">
			        <a class="nav-link active" href="/thesis/registration">Registration</a>
			      </li>
			    
			      <li class="nav-item">
			        <a class="nav-link" href="/thesis/login">Login</a>
			      </li>
			    </ul>
		  	</div>	
		</nav>
		<div class="container">
		<h1>Registration</h1>
		<c:if test="${not empty error}"><div class="error">${error}</div></c:if>
		<c:if test="${not empty msg}"><div class="msg">${msg}</div></c:if>
<%-- 		<c:url value='/registration' var="loginVar" />
		<form name='registration' id='registration' action="${loginVar}" method='POST'> --%>
		<form name='registrationForm' id='registrationForm' action="/thesis/registration" method='POST'>
		  <div class="form-group">
		    <label for="firstname">First Name</label>
		    <input type="text" class="form-control" name="firstname" placeholder="Enter First Name" />
		  </div>
		  
		  <div class="form-group">
		    <label for="lastname">Last Name</label>
		    <input type="text" class="form-control" name="lastname" placeholder="Enter Last Name" />
		  </div>
		  
		  <div class="form-group">
		    <label for="username">Username</label>
		    <input type="text" class="form-control" name="username" placeholder="Enter username" />
		  </div>
		  
		  <div class="form-group">
		      <label for="role">Role</label>
		      <select name="role" class="form-control">
		        <option selected>Choose your role</option>
		        <option value="student">Student</option>
		        <option value="supervisor">Supervisor</option>
		        <option value="coordinator">Coordinator</option>
		      </select>
		  </div>
		  <div class="form-group">
		    <label for=email>Email</label>
		    <input type="text" class="form-control" name="email" name='email' placeholder="Enter Email" />
		  </div>
		  
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="text" class="form-control" name="password" name='password' placeholder="Enter Password" />
		  </div>

		  <button type="submit" class="btn btn-primary">Submit</button>
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		</div>
	</body>
</html>