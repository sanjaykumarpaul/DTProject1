<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Sports</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
  <h2>SUPPLIERS:-</h2>
           <br>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>SUPPLIER-ID</th>
        <th>SUPPLIER NAME</th>
        
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${suplist}" var="supplier">     
   <tr>
        <td>${supplier.supplierId }</td>
        <td>${supplier.supplierName }</td>
        
      </tr>
</c:forEach>
      
     
       
       
     
      
    </tbody>
  </table>
</div>


</body>
</html>
