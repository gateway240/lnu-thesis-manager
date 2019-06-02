<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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

<body class="d-flex flex-column h-100">

<jsp:include page="../nav.jsp"></jsp:include>
<div class="container text-center">
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
            <td><a href="${contextPath}/download/pdf/${file_name}">Download</a></td>
            <td>${document.author.username}</td>
            <td>${document.title}</td>
            <td>${document.category}</td>
        </tr>
        </tbody>
    </table>
    <h2>Document Feedback</h2>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Reviewer</th>
            <th scope="col">Feedback</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${document.feedbackList}" var="feedback">
            <tr>
                <td>${feedback.reviewer.username}</td>
                <td>${feedback.feedback}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h2>Provide Feedback</h2>
    <form:form method="POST" action="${contextPath}/document/addFeedback" modelAttribute="feedback">
        <div class="form-group text-left">
            <form:label path="document">Select Document</form:label>
            <form:select class="form-group browser-default custom-select custom-select-lg mb-3" path="document.id" multiple="multiple" >
                <form:option value="${document.id}" label="title" ></form:option>
            </form:select>
        </div>
        <div class="form-group text-left">
            <form:label path="feedback">Feedback</form:label>
            <form:textarea rows="10" cols="100" path="feedback"></form:textarea>
        </div>
        <input type="submit" class="btn btn-dark" value="Submit"/>
    </form:form>

</div>
</body>
</html>
