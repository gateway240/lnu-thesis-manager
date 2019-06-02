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
        <jsp:include page="nav.jsp"></jsp:include>

		<div class="container">
			<h1>Submit Document</h1>

			<p style="color:green">${filesuccess}</p>
			<p style="color:red">${errorMessage}</p>

			<form:form method="post" action="${contextPath}/submission/uploadFile" enctype="multipart/form-data">
<!-- 				<select class="form-group browser-default custom-select custom-select-lg mb-3"> -->
<!-- 				  <option selected>Choose degree</option> -->
<!-- 				  <option value="bachelor">Bachelor</option> -->
<!-- 				  <option value="master">Master</option> -->
<!-- 				</select> -->

		<!--    <select class="form-group browser-default custom-select custom-select-lg mb-3">
				  <option selected>Choose document category</option>
				  <option value="description">Project Description</option>
				  <option value="plan">Project Plan</option>
				  <option value="report">Final Report</option>
				</select> -->

				<div class="form-group custom-file">
				  <input type="file" class="custom-file-input" id="file" name="file" onchange="$(this).next().after().text($(this).val().split('\\').slice(-1)[0])">
				  <label class="custom-file-label" for="file">Choose file (PDF only)</label>
				</div>

				<div class="form-group">
				    <label for="title">Title</label>
				    <input name="title" id="title" type="text" class="form-control" placeholder="Enter Title">
			    </div>

                <div class="form-group">
                    <select name="category" class="browser-default custom-select custom-select-lg mb-3">
                        <option value="" selected>Category</option>
                        <option value="Project Description">Project Description</option>
                        <option value="Project Plan">Project Plan</option>
                        <option value="Final Report">Final Report</option>
                    </select>
                </div>

<!-- 			<div class="form-group">
				    <label for="abstract">Abstract</label>
				    <textarea class="form-control" id="abstract" rows="10"></textarea>
				</div> -->

				<input type="submit" class="btn btn-dark" value="Upload"/>

			</form:form>
		</div>
	</body>
</html>
