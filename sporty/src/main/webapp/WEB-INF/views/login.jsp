<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>LOGIN</title>

<script>
function validateForm()
{
	
var username=document.formLogin.username.value;
var passwrd=document.formLogin.password.value;
if(username==null ||username=="")
	{
	alert("Name cant be left blank");
	return false;
	}
else if(passwrd.length<6)
	{
	alert("Password must be atleast 6 character long");
	return false;
	}
}
</script>

</head>

<body style="background-color:yellow ">
<jsp:include page="header.jsp" />
<b><h2 align="center" style="color:red">LOGIN FORM</h2></b> 

<div class="container" style="padding:50px 0">
	
	<div class="l" style="background-color:blue ">
	
		<form id="login-form" name="formLogin" action='<c:url value="/login"/>'  method="post" class="text-left">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="username" class="sr-only" style="color:red">USERNAME</label>
						<input type="text" class="form-control" id="username" name="username" placeholder="ENTER USERNAME" >
					</div>
					<div class="form-group">
						<label for="password" class="sr-only" style="color:red">PASSWORD</label>
						<input type="password" class="form-control" id="password" name="password" placeholder="ENTER PASSWORD">
					</div>

				</div>
				<!-- <button type="submit" class="login-button">Login</button> -->
				<div align="center">
				<input type="submit" name="submit" value="LOGIN" />
				</div>
			</div>
			 <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			
		</form>
		</div>
		</div>
<jsp:include page="footer.jsp" />

</body>
</html>


 --%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="login.css">

	
</head>
<body 	background="http://orig11.deviantart.net/20eb/f/2015/030/6/f/_minflat__dark_material_design_wallpaper__4k__by_dakoder-d8fjqzu.jpg">
<jsp:include page="header.jsp"></jsp:include>
<div class="login-page">
  <div class="form">
    <form class="login-form">
      <input type="text" placeholder="username"/>
      <input type="password" placeholder="password"/>
      <button><span>login</span></button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
  </div>
</div>
</body>
</html>
<style>
@import url('https://fonts.googleapis.com/css?family=Open+Sans');

.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #3d3d3d;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: 'Open Sans', sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: 'Open Sans', sans-serif;
  font-size: 18px;
  text-transform: uppercase;
  outline: 0;
  background: #e84c3d;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

button span {
  font-family: 'Open Sans', sans-serif;
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

button:hover span {
  padding-right: 25px;
}

button:hover span:after {
  opacity: 1;
  right: 0;
}

.form .message {
  font-family: 'Open Sans', sans-serif;
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  font-family: 'Open Sans', sans-serif;
  color: #e84c3d;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
body {
  background-size: 100%
}
</style> 