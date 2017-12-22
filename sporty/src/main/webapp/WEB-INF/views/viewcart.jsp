<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ONLINE SPORTS
<!-- <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<script src="./resources/js/jquery.min.js"></script>
<script src="./resources/js/bootstrap.min.js"></script> -->
<link rel="stylesheet" href="./resources/css/jquery.dataTables.min.css">
<link href="./resources/css/font-awesome.min.css" rel='stylesheet'
	type='text/css'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body style="background-color: Aquamarine">
	<jsp:include page="header.jsp" />
	<br>
	<div class="col-md-10 col-md-offset-1">

		<div class="panel panel-default panel-table">
			<div class="panel-heading">
				<div class="row">
					<div class="col col-xs-6">
						<h3 class="panel-title">Your Cart</h3>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-list">
					<thead>
						<tr>

							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Image</th>
							<th>Total</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>

						<c:set var="tot" value="0"></c:set>
						<c:forEach items="${cartlist}" var="product">

							<c:set var="t" value="${product.prices*product.quantity}"></c:set>
							<c:set var="tot" value="${tot+t }" />
							<tr>

								<td>${product.id.pname}</td>
								<td><i class="fa fa-inr" aria-hidden="true"></i>
									${product.prices}</td>
								<td>${product.quantity}</td>
								<td><img src="${pageContext.request.contextPath}/resources/${product.id.pImage}.jpg"height="200px" width="200px">
									class="img-rounded" alt="${product.id.pname }" width="75px"
									height="50px" /></td>
								<td><i class="fa fa-inr" aria-hidden="true"></i>
									${product.prices*product.quantity}</td>
								<td><a class="btn btn-danger"
									href="./cart_delete?id=${product.cartid}"><em class="fa fa-trash"></em></a>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>
			
			<div class="panel-footer">
				<div class="row">
					<h1 style="color: red;">
						Grand Total = <i class="fa fa-inr" aria-hidden="true"></i>
		<c:out value="${tot}" />
					</h1>
					<a href="./"><button class="btn btn-success">Continue
							Shopping</button></a>
				</div>
				System.out.println("Cart Details...........");
				<div class="btn-group cart">
					<form action="customerDetails" method="post">

						<input type="text" name="tot" value="${tot}" /> <input
							type="submit" value="checkout" />


					</form>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp" />
</body>
</html> 
