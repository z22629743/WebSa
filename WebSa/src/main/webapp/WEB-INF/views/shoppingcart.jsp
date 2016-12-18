<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    

    <title>產品管理</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" >    
        <h1>購物車</h1>
        <p class="lead">Viewing Pleasure</p>
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-12">
			<a class="btn btn-primary" href="checkout?id=${product.id}">結帳</a>
				<table class="table">
				  	<tr>
				  		<th>產品編號  </th><th>品名</th><th>規格</th><th>金額</th>
				  	</tr>
				  	<c:forEach items="${shoppingCart}" var="product">
					  	<tr>
					  		<td>${product.id}</td>
					  		<td>${product.name}</td>
					  		<td>${product.size}</td>
					  		<c:choose>
					  		<c:when test="${product.discount == 0}">
					  		<td>${product.price }</td>
					  		</c:when>
					  		<c:when test="${product.discount != 0}">
					  		<td>${product.discount }</td>
					  		</c:when>
					  		</c:choose>
					  		
					  	</tr>
				  	</c:forEach>
				</table>
			</div>
		</div>
	</div>
	

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>
</html>