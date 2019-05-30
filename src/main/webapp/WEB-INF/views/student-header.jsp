<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<!-- 	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    	<span class="navbar-toggler-icon"></span>
	  </button> -->
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="navbar-brand" href="/thesis/student">Home</a>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="#">My Coordinator <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="#">Supervisors</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link " href="#">Deadlines</a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Submit Documents
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="<spring:url value="#"/>">Project Description</a>
          <a class="dropdown-item" href="<spring:url value="#"/>">Project Plan</a>
          <a class="dropdown-item" href="<spring:url value="#"/>">Final Report</a>
        </div>
      </li>
      
      <li class="nav-item">
        <a class="nav-link " href="#">Reader</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link " href="#">Opponent</a>
      </li>
      
      <sec:authorize access="authenticated" var="authenticated" />
		<c:choose>
			<c:when test="${authenticated}">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/logout"/>">Logout</a>
				</li>
			</c:when>
		</c:choose>
    </ul>
  	</div>	
</nav>