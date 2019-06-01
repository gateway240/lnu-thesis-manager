<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View document</title>
		<link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sticky-footer-navbar/">
		<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>

    <body>
        <h1>View document</h1>
		<table class="table">
			<thead class="thead-dark">
			    <tr>
			        <th scope="col">Download</th>
			        <th scope="col">Author</th>
			        <th scope="col">Title</th>
			        <th scope="col">Category</th>
			    </tr>
			</thead>
			<tbody>
			    <tr>
                    <td><a href="/download/pdf/${file_name}">Download</a></td>
			        <td>${document.author.username}</td>
			        <td>${document.title}</td>
			        <td>${document.category}</td>
			    </tr>
            </tbody>
        </table>
    </body>
</html>
