<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./base.jsp" %>
</head>
<body>
   <div class="container mt-3">
     <div class="col-md-12">
      
       <h1 class="text-center"> welcome to product app</h1>
        
        <table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   
    <c:forEach items="${products}"  var="p">
      <tr>
       <th scope="row">Technology${p.id}</th>
      <td>${p.name}</td>
      <td>${p.description}</td>
      <td>&#x20B9;${p.price}</td>
       <td> 
           <a href="delete/${p.id}"> <i class="fas fa-trash text-danger"></i></a>
            <a href="update/${p.id}"> <i class="fas fa-pen-nib text-primary"></i></a>
        </td>
      </tr>
    </c:forEach>
    
  </tbody>
</table>

<div class="container text-center">
   <a href="addproduct" class="btn btn-outline-success">Add Product</a>
</div>  
   
  </div>
  </div>
   </body>
</html>