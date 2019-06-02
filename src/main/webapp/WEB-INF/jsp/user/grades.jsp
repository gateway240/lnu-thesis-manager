<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Submissions</title>
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

            <table class="table">
                <thead class="thread-dark">
                    <tr>
                        <th scope="col">Type</th>
                        <th scope="col">Grade</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${grades}" var="grade">
                        <tr>
                            <td>${grade.documentType}</td>
                            <td>${grade.grade}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
