<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all the documents</title>
</head>
<body>
	<table width="100%">
	  <tr>
		  <th>Document Title</th>
		  <th>Download</th>
	  </tr>
	  <c:forEach var="doc" items="${docs}">
		  <tr>
			  <td>${doc.title}</td>
			  <td><a href="${doc.downloadURL}">Download</a></td>
							 
		  </tr>
						 
	  </c:forEach>
	 </table>

</body>
</html>