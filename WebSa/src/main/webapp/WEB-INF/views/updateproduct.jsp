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
        <h1>產品管理系統</h1>
        <p class="lead">本系統為輔仁大學資訊管理學系之範例程式</p>
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="post" action="updateProduct" id="insertForm">
				<input type="hidden" name="id" value="${product.id}">
					<div class="form-group">
						供應商編號:<select class="form-control" name="supplierId" value="${product.supplierId }">
  						<option>1</option>
  						<option>2</option>
  						<option>3</option>
  						<option>4</option>
  						<option>5</option>
						</select>
					</div>
					<div class="form-group">
						<label>商品名稱:</label>
						<input type="text" name="name" value="${product.name }" required>
					</div>	
					<div class="form-group">
						<label>顏色:</label>
						<input type="text" name="color" value="${product.color }" required>
					</div>
					<div class="form-group">
						<label>規格:</label>
						<input type="text" name="size" value="${product.size }" required>
					</div>
					<div class="form-group">
						種類:<select class="form-control" name="category" value="${product.category }">
  						<option>men</option>
  						<option>women</option>
						</select>
					</div>
					<div class="form-group">
						<label>商品介紹:</label>
						<input type="text" name="desc" value="${product.desc }" required>
					</div>
					<div class="form-group">
						<label>金額:</label>
						<input type="text" name="price" value="${product.price }" required>
					</div>
					<div class="form-group">
						<label>特價金額:</label>
						<input type="text" name="discount" value="${product.discount }" required>
						<p class="help-block">若商品不特價,請輸入0</p>
					</div>
					<div class="form-group">
						<label>庫存量:</label>
						<input type="number" name="inventory" value="${product.inventory }" min="0" required>
						<p class="help-block">目前庫存數量</p>
					</div>
					<div class="form-group">
						<label>安全存量:</label>
						<input type="number" name="reorderPoint" value="${product.reorderPoint }" required>
						<p class="help-block">當目前庫存數量低於此數字就應該進貨</p>
					</div>
			  		<button type="submit" class="btn btn-default">修改完成</button>
				</form>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	</div><!-- /.container -->
	    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.validate.js" />"></script>
    <script src="<c:url value="/resources/js/additional-methods.js" />"></script>
    <script src="<c:url value="/resources/js/messages_zh_TW.js" />"></script>
	<script>
	$("#insertForm").validate();
	</script>
    
</body>
</html>