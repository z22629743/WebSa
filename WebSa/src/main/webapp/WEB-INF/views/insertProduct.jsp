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
				<form method="post" action="insertProduct" id="insertForm">
					<div class="form-group">
						供應商編號:<select class="form-control" name="supplierId">
  						<option>1</option>
  						<option>2</option>
  						<option>3</option>
  						<option>4</option>
  						<option>5</option>
						</select>
					</div>
					<div class="form-group">
						<label>商品名稱:</label>
						<input type="text" name="name" placeholder="輸入商品名稱" required>
					
					</div>	
					<div class="form-group">
						<label>顏色:</label>
						<input type="text" name="color" placeholder="輸入顏色" required>
						
					</div>
					<div class="form-group">
						<label>規格:</label>
						<input type="text" name="size" placeholder="輸入規格" required>
						
					</div>
					<div class="form-group">
						<label>種類:</label>
						<select class="form-control" name="category" required>
  						<option>men</option>
  						<option>women</option>
						</select>
					
					</div>
					<div class="form-group">
						<label>商品介紹:</label>
						<input type="text" name="desc" placeholder="輸入商品介紹" required>
					
					</div>
					<div class="form-group">
						<label>金額:</label>
						<input type="text" name="price" placeholder="輸入產品金額" required>
					
					</div>
					<div class="form-group">
						<label>特價金額:</label>
						<input type="text" name="discount" value="0" required>
						<p class="help-block">若商品不特價,請勿更動此欄位</p>
					</div>
					<div class="form-group">
						<label>庫存量:</label>
						<input type="number" name="inventory" value="0" min="0" required>
						<p class="help-block">目前庫存數量</p>
					</div>
					<div class="form-group">
						<label>安全存量:</label>
						<input type="number" name="reorderPoint" placeholder="0" required>
						<p class="help-block">當目前庫存數量低於此數字就應該進貨</p>
					</div>
			  		<button type="submit" class="btn btn-default">新增</button>
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
