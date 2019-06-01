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
	<spring:url value="/user/save" var="saveURL" />
		<jsp:include page="../nav.jsp"></jsp:include>
	
		<div class="container text-center">
			<h1>Find Submissions</h1>
			<form>
				<select class="form-group browser-default custom-select custom-select-lg mb-3">
				  <option selected>Choose degree</option>
				  <option value="bachelor">Bachelor</option>
				  <option value="master">Master</option>
				</select>
				
				<select class="form-group browser-default custom-select custom-select-lg mb-3">
				  <option selected>Choose document category</option>
				  <option value="description">Project Description</option>
				  <option value="plan">Project Plan</option>
				  <option value="report">Final Report</option>
				</select>
				
				<!-- Search form -->
				
				<div class="form-group text-left">
				    <label for="search-title"></label>
				    <input class="form-control form-control-lg" name="search-title" type="text" placeholder="Search by title keyword" aria-label="Search">
			  	</div>
			  	
			  	<div class="form-group text-center">
				    <button type="submit" class="btn btn-dark">Find</button>
			  	</div>
		  	</form>
		  
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Action</th>
			      <th scope="col">Author</th>
			      <th scope="col">Submission title</th>
			      <th scope="col">Degree</th>
			      <th scope="col">Category</th>
			      <th scope="col">Supervisor</th>
			      <th scope="col">Coordinator</th>
			      <th scope="col">Submission Date</th>
			      <th scope="col">Deadline</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${submissions}" var="submission">
			    <tr>
			      <td><spring:url value="/user/viewDocument" var="viewDocumentURL"/><a href="${viewDocumentURL}/${submission.document.title}">View</a></td>
			      <td>${submission.user.username}</td>
			      <td>${submission.title}</td>
			      <td>${submission.degree}</td>
			      <td>${submission.document.category}</td>
			      <td>${submission.user.username}</td>
			      <td>${submission.user.username}</td>
			      <td>${submission.date}</td>
			      <td>${submission.deadline.name}</td>
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