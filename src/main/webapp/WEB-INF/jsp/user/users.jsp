<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
<jsp:include page="../nav.jsp"></jsp:include>

<div class="container text-center">
    <h1>Users</h1>
    <select name="rolePicker" onchange="location = this.value;"
            class="form-group browser-default custom-select custom-select-lg mb-3">
        <option value="${contextPath}/user/users" selected>Filter by role</option>
        <option value="${contextPath}/user/users?role=ROLE_USER">Student</option>
        <option value="${contextPath}/user/users?role=ROLE_SUPERVISOR">Supervisor</option>
        <option value="${contextPath}/user/users?role=ROLE_ADMIN">Coordinator</option>
    </select>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Firstname</th>
            <th scope="col">Lastname</th>
            <th scope="col">Username</th>
            <th scope="col">Email</th>
            <th scope="col">Role</th>
            <!-- 				  <th scope="col">Action</th> -->
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.roles.get(0).role}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<footer class="footer mt-auto py-3">
    <div class="container text-center">
        <span>&copy; 2019 | Team B | <a href="https://lnu.se/">LNU</a></span>
    </div>
</footer>
</body>
</html>