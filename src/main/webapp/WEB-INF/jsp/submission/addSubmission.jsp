<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>  
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Submit Document</title>
		<link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sticky-footer-navbar/">
		<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>
    <body>  
        <jsp:include page="../nav.jsp"></jsp:include>

		<div class="container text-center">

			<h1>Upload Document</h1>
			<form:form method="POST" action="${contextPath}/submission/addSubmission/submit" modelAttribute="submission">
				<div class="form-group text-left">
					<form:select path="deadline" multiple="multiple" >
						<option value="0">--Select--</option>
						<form:options items="${deadlines}" itemLabel="name"></form:options>
					</form:select>
				</div>
				<%--<div class="form-group text-left">--%>
					<%--<form:label path="startDate">Start Date (dd/MM/yyyy)</form:label>--%>
					<%--<form:input class="form-control" path="startDate"></form:input>--%>

				<%--</div>--%>
				<%--<div class="form-group text-left">--%>
					<%--<form:label path="endDate">End Date (dd/MM/yyyy)</form:label>--%>
					<%--<form:input class="form-control" path="endDate"></form:input>--%>
				<%--</div>--%>

				<input type="submit" class="btn btn-dark" value="Submit"/>
			</form:form>


		</div>
	</body>  
</html>  