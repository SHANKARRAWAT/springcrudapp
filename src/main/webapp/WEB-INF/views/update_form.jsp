<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./base.jsp" %>
</head>
<body>
   
   
   <div class="container mt-3">
     <div class="row"> 
       <div class="col-md-6 offset-md-3">
       <h1 class="text-center mb-3"> Update your product</h1>
    <input type="text" value="${product.id}" name="id">
   <form action="${pageContext.request.contextPath}/handleupdateproject"  method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Product Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name" value="${product.name}">
    
  </div>
  
    <div class="mb-3 ">
    <label for="desc " class="form-label">Product description</label>
     <textarea class="form-control" id="desc" rows="3" name="description" >${product.description}</textarea>
    </div>  
  
  
    <div class="mb-3 ">
    <label for="price " class="form-label">Product price</label>
    <input type="text" class="form-control " id="price" aria-describedby="emailHelp" name="price" value="${product.price}">  
  </div>  
  
  <div class="text-center">
   <!-- project path == contextpath +>(springcrudapp) -->
  <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">back</a>
  <button type="submit" class="btn btn-primary">update</button>
  </div>
</form>
     </div>
</div>
   </div>
   
</body>
</html>