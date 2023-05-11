<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>박스모델.jsp</title>
<style type="text/css">
	div {
		box-sizing: border-box;
	}
	.border-10 {
		border: 10px solid red;
	}
	.border-1 {
		border: 1px solid red;
	}
	.rectangle {
		width: 100px;
		height: 100px;
	}
	.p-10 {
	 	padding: 10px;
	}
</style>

</head>
<body>
<div class="rectangle border-10 p-10">box1</div>
<div class="rectangle border-10">box2</div>
<div class="rectangle border-1">box3</div>

</body>
</html>