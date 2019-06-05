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
		<spring:url value="/user/register" var="registerURL" />
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
			    <ul class="navbar-nav">
			    
			      <li class="nav-item">
			        <a class="nav-link active" href="#">Registration</a>
			      </li>
			    
			      <li class="nav-item">
			        <a class="nav-link" href='<c:url value="/login" />'>Login</a>
			      </li>
			    </ul>
		  	</div>	
		</nav>
		<div class="container">
		<h1>Registration</h1>
		<c:if test="${not empty error}"><div class="error">${error}</div></c:if>
		<c:if test="${not empty msg}"><div class="msg">${msg}</div></c:if>

		<form:form action="${registerURL}" modelAttribute="userForm" method="post">
		  <div class="form-group">
		    <label for="firstname">First Name</label>
		    <form:input path="firstname" type="text" class="form-control" name="firstname" />
		    <form:errors path="firstname" cssClass="error" element="div" />
		  </div>
		  
		  <div class="form-group">
		    <label for="lastname">Last Name</label>
		    <form:input path="lastname" type="text" class="form-control" name="lastname" />
		    <form:errors path="lastname" cssClass="error" element="div" />
		  </div>
		  
		  <div class="form-group">
		    <label for="username">Username (on Slack)</label>
		    <form:input path="username" type="text" class="form-control" name="username" />
		    <form:errors path="username" cssClass="error" element="div" />
		  </div>
		  
		  <div class="form-group">
		      <label for="role">Role</label>
		      <form:select name="role" class="form-control" path="role">
		        <form:option value="ROLE_USER">Student</form:option>
		        <form:option value="ROLE_SUPERVISOR">Supervisor</form:option>
		        <form:option value="ROLE_ADMIN" selected="selected">Coordinator</form:option>
		      </form:select>
		  </div>
		  
		  <div class="form-group">
		    <label for=email>Email</label>
		    <form:input path="email" type="text" class="form-control" name="email" />
		    <form:errors path="email" cssClass="error" element="div" />
		  </div>
		  
		  <div class="form-group">
		    <label for="password">Password</label>
		    <form:password path="password" class="form-control" />
  			<form:errors path="password" cssClass="error" element="div" />
		  </div>
		  
		  <div class="form-group">
		    <label for="password">Confirm Password</label>
		    <form:password path="confirmPassword" class="form-control" />
  			<form:errors path="confirmPassword" cssClass="error" element="div" />
		  </div>

		  <input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
		</div>
	</body>
</html>