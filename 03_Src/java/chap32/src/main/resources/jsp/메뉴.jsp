<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>메뉴.jsp</title>
<style type="text/css">
ol {
	list-style: none;
	display: flex;
}
li {
	width: 200px;
	text_align: center;
	padding: 5px;
	text-decoration: overline;
}
li:nth-child(odd) {
	background:rgba(255,0,0,0.5);
}
li:nth-child(even) {
	background: #FF0000AF;
}

li:first-child {
	border-radius: 10px 0 0 10px;
}
li:last-child {
	border-radius: 0 10px 10px 0;
}

body {
	background-image: url("img/dev_rabbit1.jpg");
	background-repeat: no-repeat;
	background-size: 100%;
	
}

</style>
</head>
<body>

<ol>
	<li>첫 번째</li>
	<li>두 번째</li>
	<li>세 번째</li>
	<li>네 번째</li>
	<li>다섯 번째</li>
	<li>여섯 번째</li>
	<li>일곱 번째</li>
</ol>

</body>
</html>