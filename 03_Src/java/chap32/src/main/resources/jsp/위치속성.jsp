<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>위치속성.jsp</title>
<style type="text/css">
/*  	.box {
		top: 0px;
		left: 0px;
	}  */
	
	.box {
		position : fixed;
		width: 100px;
		height: 100px;
		background: red;
		transition: all 1s; 
/* 		transition-property: top, left;
		transition_duration: 1s; */
	}
	
	body {
		border: 10px solid blue;
		height: 5000px;
	}
</style>
</head>
<body>
<div id="box1" class="box">box1</div>
<hr>
<div id="box2" class="box">box2</div>
<hr>
<div id="box3" class="box">box3</div>

</body>
</html>