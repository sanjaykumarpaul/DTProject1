<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Sports</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h2>PRODUCT:-</h2>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>PRODUCT-ID</th>
					<th>PRODUCT NAME</th>
					<th>PRODUCT DESCRIPTION</th>
					<th>PRODUCT PRICE</th>
					<th>PRODUCT QUANTITY</th>
					<th>PRODUCT IMAGE</th>
					<th>PRODUCT CATEGORY</th>
					<th>PRODUCT SUPPLIER</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${prolist}" var="product">
					<tr>
						<td>${product.id }</td>
						<td>${product.name }</td>
						<td>${product.description }</td>
						<td>${product.price }</td>
						<td>${product.quantity}</td>
					<td><a href="${pageContext.request.contextPath}/userproductlist/${product.id}">
						<img src="${pageContext.request.contextPath}/resources/<c:out value='${product.pImage}'></c:out>"height="35px" width="35px" /></a> </td>
						<td>${product.prodCategory.categoryName }</td>
						<td>${product.prodSupplier.supplierName }</td>


					</tr>
				</c:forEach>






			</tbody>
		</table>
	</div>

</body>
</html>
