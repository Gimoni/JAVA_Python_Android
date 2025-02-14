<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" class="border border-5 border-primary">
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="/faviconAlpha.png"> 
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.css">
<script src="/webjars/bootstrap/5.2.3/js/bootstrap.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<title>반응형 연습하기.jsp</title>

<style type="text/css">
 	div {
	    text-align: center;
		justify-content: center;
 		line-height: 100px; 
	}
	#d {
		line-height: 400px;
	} 
</style>
</head>
<body>


<div class="container">
<h1>반응형 연습하기</h1>
	<div class="row border bg-info">
		<div style="height: 100px;">Top</div>
	</div>
	<div class="row" style="height: 400px;">
		<div id="d" class="col-2 border-end border-start bg-warning">Left</div>
		<div id="d" class="col-6 border-end bg-success">Center</div>
		<div id="d" class="col-4 border-end bg-primary">Right</div>
	</div>
	<div class="row border bg-teritary">
		<div style="height: 100px">Bottom</div>
	</div>

</div>



</body>
</html>