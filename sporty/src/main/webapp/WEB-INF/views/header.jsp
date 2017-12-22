<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<%@ page isELIgnored="false" %>
<!-- <spring:url var="images" value="/resources/images" /> -->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
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

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Online Sports</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="">SHOP BY CATEGORY <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach  items="${catlist}" var="cat">
							<li><a
								href="<c:url value="/productlist?cid=${cat.categoryId}"/>">${cat.categoryName}</a></li>
						</c:forEach>
					</ul></li>


				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">List <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="categorylist"><span
								class="glyphicon glyphicon-log-in"></span> Category</a></li>
						<li><a href="supplierlist"><span
								class="glyphicon glyphicon-log-in"></span> Supplier</a></li>
						<li><a href="productview"><span
								class="glyphicon glyphicon-log-in"></span> Product</a></li>
					</ul></li>
<%-- <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
<li><a href="<c:url value="/admin" />">ADMIN</a></li>
</c:if>
<ul class="nav navbar-nav navbar-right">




<c:if test="${pageContext.request.userPrincipal.name  == 'admin@gmail.com'}">
<li><a id="ad" style="color: white;"
href="<c:url value="/admin/add"/>" role="button" aria-haspopup="true"
aria-expanded="false">ADD</a></li>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name  == null}">
<li><a style="color: white;"
href="<c:url value="/login"/>" role="button"
aria-haspopup="true" aria-expanded="false">LOGIN</a></li>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name == null }">

<li><a href="register">SIGN UP<span
class="glyphicon glyphicon-log-in"></span></a></li>
<li><a href="categories"><span
class="glyphicon glyphicon-log-in"></span> ADD</a></li>

</c:if>
</ul>
<c:if test="${pageContext.request.userPrincipal.name  != null}">
<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
<li><a href='<c:url value="/logout" />'>SIGN OUT</a></li>
</c:if>
 --%>

				< <ul class="nav navbar-nav navbar-right">
					<li><a href="login"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<li><a href="register"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<li><a href="categories"><span
							class="glyphicon glyphicon-log-in"></span> ADD</a></li>
 -->
				</ul>
			</ul>
		</div>
	</nav>
</body>
</html>
