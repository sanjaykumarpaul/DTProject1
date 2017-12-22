<%-- <spring:url var="images" value="/resources/images" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 --%>
<!DOCTYPE html>

<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>



 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="https://static1.squarespace.com/static/54ab01a7e4b032a504c55360/t/56ca546ae707eb01debd128f/1502795131626/Hayden+Peek+-+Adidas+-+Boss+Everyone+-+Thumb_1.jpg?format=1500w"style="width:100%;">
</div>
      <div class="item">
          <img src="https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAAvEAAAAJDU5Y2FkYTQ2LWVhNjEtNGE3NS1iMTI0LTdjOGMzMjAzMGM5NQ.jpg"style="width:100%;">
      </div>
      
    
      <div class="item">
        <img src="https://sg.everydayonsales.com/wp-content/uploads/2015/01/Best-Denki-HSBC-Cash-Back-Promotion-Home-Appliances-Bank-Singapore-2015-EverydayOnSales-Great-Mega-Factory-Wholesales-Kilang-Lobang.jpg"style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

<jsp:include page="footer.jsp" />
</body>
</html>

  


