<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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

			  <h2>Add Deadline</h2>
			  <form:form method="POST" action="${contextPath}/deadline/addDeadline" modelAttribute="deadline">
				 <div class="form-group">
					 <form:label path="name">Deadline Name</form:label>
					 <form:input path="name"></form:input>
				 </div>
				  <div class="form-group">
					  <form:label path="startDate">Start Date (dd/MM/yyyy)</form:label>
					  <form:input path="startDate"></form:input>

				  </div>
				  <div class="form-group">
					  <form:label path="endDate">End Date (dd/MM/yyyy)</form:label>
					  <form:input path="endDate"></form:input>
				  </div>

					<input type="submit" value="Submit"/>
			  </form:form>
				<h2>All Deadlines</h2>
			  <form:form method="POST" action="${contextPath}/deadline/saveDeadlines" modelAttribute="deadlines">
				  <table width="100%">
					  <tr>
						  <th>Deadline Name</th>
						  <th>Start Date</th>
						  <th>End Date</th>
					  </tr>
					  <c:forEach items="${deadlines}" var="deadline">
						  <tr>
							  <td>${deadline.name}</td>
							  <td>${deadline.startDate}</td>
							  <td>${deadline.endDate}</td>

						  </tr>
						  <%--<tr>--%>
							  <%--<td><input path="deadlines[${tagStatus}].name" value="${deadline.name}" /></td>--%>
							  <%--<td><input path="deadlines[${tagStatus}].startDate" value="${deadline.startDate}" /></td>--%>
							  <%--<td><input path="deadlines[${tagStatus}].endDate" value="${deadline.endDate}" /></td>--%>

						  <%--</tr>--%>
					  </c:forEach>
				  </table>
				  <%--<input type="submit" value="Save" />--%>
			  </form:form>

		  </div>
		

	</body>
</html>