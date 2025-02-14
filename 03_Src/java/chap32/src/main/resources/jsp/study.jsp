<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>study.jsp</title>
<style type="text/css">
* { /* 전체 선택자 */
	font-family: monospace;
}

/* 태그 선택자 */
h1 {
	font-style: italic;
}

p {
	color: blue;
}

#header #wrap {
	width: 800px;
	margin : 0 auto;
}
#header {
	background: red;
}

#wrap {
	background: blue;
	overflow: hidden;
}

#aside {
	width : 200px;
	float : left;
	background: blue;
	border : solid;
}

#content {
	width:200px;
	float: right;
	background: green;
}

.select {
	color: red;
}

input[type="text"] {
	background: blue;
	color : white;
}

input[type="password"] {
	background: red;
}

input:hover {
	width: 200px;
	height: 40px;
	border: 10px solid red;
}

</style>
</head>
<body>
<h1>제목 글자 태그</h1>
<p>안녕하세요 지금은 전체선택자와 태그 선택자를 공부하고 있습니다.</p>

<div>+++++++++++++++++++++++++++++++++</div>

<div id="header">
	<h1>#header 태그</h1>
</div>
<div id="wrap">
	<div id="aside">
		<h1>#aside 태그</h1>
	</div>
	<div id="content">
		<h1>#content 태그</h1>
	</div>
</div>
<div id="wrap">
	<div>
		<h1 id="aside">#aside 태그</h1>
		<h1 id="content">#content 태그</h1>
	</div>
</div>
<div></div>
<hr>


<ul>
	<li class="select">사과</li>
	<li>바나나</li>
	<li class="select">오렌지</li>
	<li>감</li>
</ul>

<div></div>
<hr>

<form>
	<input type="text" placeholder="email">
	<input type="password">
</form>

</body>
</html>