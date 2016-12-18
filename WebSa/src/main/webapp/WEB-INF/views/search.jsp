<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*"%> 
<!DOCTYPE html>
<html lang="en">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    

    <title>中文書販賣中心</title>
</head>


<body>
	<%@include file="navbar.jspf" %>
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" >    
        <h1>歡迎光臨</h1>
        <p class="lead">有問題請諮詢:0909089137</p>
      </div>
	<div class="container">
	<form method="get" action="search" >
	<input type="text" name="search" placeholder="Search..">
	<button type="submit" class="glyphicon glyphicon-search"></button>
	</form>
	<c:forEach items="${productList}" var="product">
		<div class="row">
			<br>
			<div class="col-md-8">
                <img src="resources\fileUpload\<c:out value="${product.id}"/>.jpg" width="30%">
            </div>
            <div class="col-md-4">
                <h3>${product.desc }</h3>
                <h3>商品資訊</h3>
                <ul>
                    <li>ISBN:${product.ISBN }</li>
                    <li>作者:${product.author }</li>
                    <c:if test="${product.trans != null}">
                    <li>譯者:${product.trans }</li>
                    </c:if>
                    <li>出版商${product.publisher }</li>
                    <li>出版日期${product.publishdate }</li>
                    <li>價格${product.price }</li>
                    <c:if test="${product.discount != 0}">
                    <li>特價${product.discount }</li>
                    </c:if>
                </ul>
                <a class="btn btn-default" href="add?id=${product.id}">加入</a>
            </div>
            </div>
            
            
            
            
        </c:forEach>    
			</div>
		</div>



</body>
</html>
