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

			<h1>Your Documents</h1>
			<form:form method="POST" action="${contextPath}/deadline/saveDeadlines" modelAttribute="documents">
				<table class="table">
					<thead class="thead-dark">
					<tr>
						<th scope="col">Title</th>
						<th scope="col">Author</th>
					<!-- <th scope="col">Path</th> -->	
						<th scope="col">Category</th>
						<%--<th scope="col">Action</th>--%>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${documents}" var="document">
						<tr>
							<td><a href="${document.downloadURL}">${document.title}</a></td>
							<td>${document.author.username}</td>
							<!--<td><a href="${document.downloadURL}">${document.fileName}</a></td>  -->
							<td>${document.category}</td>
							<%--<td><spring:url value="/submission/addSubmission" var="addSubmissionURL"/><a href="${addSubmissionURL}?document=${document.id}">Submit Document</a></td>--%>

						</tr>
						<%--<tr>--%>
						<%--<td><input path="deadlines[${tagStatus}].name" value="${deadline.name}" /></td>--%>
						<%--<td><input path="deadlines[${tagStatus}].startDate" value="${deadline.startDate}" /></td>--%>
						<%--<td><input path="deadlines[${tagStatus}].endDate" value="${deadline.endDate}" /></td>--%>

						<%--</tr>--%>
					</c:forEach>
					</tbody>
				</table>
				<%--<input type="submit" value="Save" />--%>
			</form:form>
			<h1>Add Submission</h1>
			<form:form method="POST" action="${contextPath}/submission/addSubmission/submit" modelAttribute="submission">
				<div class="form-group text-left">
					<div class="form-group text-left">
						<form:label path="title">Title</form:label>
						<form:input class="form-control" path="title"></form:input>

					</div>
					<div class="form-group text-left">
						<form:label path="degree">Degree</form:label>
						<form:input class="form-control" path="degree"></form:input>
					</div>
					<div class="form-group text-left">
						<form:label path="document">Document</form:label>
						<form:select class="form-group browser-default custom-select custom-select-lg mb-3" path="document.id" multiple="multiple" >
							<form:options items="${documents}" itemValue="id" itemLabel="title" />
						</form:select>
					</div>
					<div class="form-group text-left">
						<form:label path="deadline">Deadline</form:label>
						<form:select class="form-group browser-default custom-select custom-select-lg mb-3" path="deadline.id" multiple="multiple" >
							<form:options items="${deadlines}" itemValue="id" itemLabel="name" />
						</form:select>
					</div>

				</div>

				<input type="submit" class="btn btn-dark" value="Submit"/>
			</form:form>


		</div>
	</body>
</html>
