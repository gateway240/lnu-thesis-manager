<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    $(document).ready(function () {
        var url = window.location;
        $('ul.nav a[href="'+ url +'"]').parent().addClass('active');
        $('ul.nav a').filter(function() {
             return this.href == url;
        }).parent().addClass('active');
    });
</script> 

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="nav navbar-nav">
	    
	      <li class="nav-item">
	        <a class="nav-link" href='<c:url value="/home" />'>Home</a>
	      </li>
	    
	      <li class="nav-item">
	        <a class="nav-link" href='<c:url value="/logout" />'>Logout</a>
	      </li>
	      
	      <li class="nav-item">
	        <a class="nav-link" href='<c:url value="/user/setAccount/${pageContext.request.userPrincipal.name}"/>'>My Account</a>
	      </li>
	      
 	  	  <li class="nav-item">
			<a class="nav-link" href='<c:url value="/user/users" />'>Users</a>
		  </li> 
	      
	      <li class="nav-item">
	        <a class="nav-link " href='<c:url value="/user/submissions" />'>Submissions</a>
	      </li>
	      		      
	      <li class="nav-item">
	        <a class="nav-link" href='<c:url value="/deadline" />'>Set Deadline</a>
	      </li>
	      
	      <li class="nav-item">
	        <a class="nav-link" href='<c:url value="/grade" />'>Set Grade</a>
	      </li>
	      
	      <li class="nav-item">
	        <a class="nav-link" href='<c:url value="/submission/uploadForm" />'>Upload Document</a>
	      </li>

			<li class="nav-item">
				<a class="nav-link" href='<c:url value="/submission/submitDocument" />'>Submit Document</a>
			</li>
	     
	    </ul>
  	</div>	
</nav>