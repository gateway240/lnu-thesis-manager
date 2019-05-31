<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>  
<html>  
 <head>  
 <title>Image File Upload</title>  
 </head>  
 <body>  
<h1>File Upload Example</h1>  
  
<h3 style="color:red">${filesuccess}</h3>
<p>${errorMessage}<p>  
<form:form method="post" action="uploadFile" enctype="multipart/form-data">
<p><label for="image">Choose File:</label></p>  
<p><input name="file" id="file" type="file" /></p>
<p><label for="input">Title:</label></p> 
<p><input name="title" id="title" type="text" /></p> 
<p><input type="submit" value="Upload"></p>  
</form:form>  
</body>  
</html>  