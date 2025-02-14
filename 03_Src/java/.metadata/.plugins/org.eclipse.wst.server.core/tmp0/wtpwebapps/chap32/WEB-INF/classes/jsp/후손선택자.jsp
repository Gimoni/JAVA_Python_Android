<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>후손선택자.jsp</title>
<style type="text/css">
header, section {
	border : 10px solid black;
}
header h2 {/* 부모가 header이고 후손 중 h2인 태그 */
	color : red;
}
header > h2 { /* 부모가 header이고 자식 중 h2인 태그 */
	color : blue;
}
header div h2, section h2  {
	background : yellow;
}

header > h1, section > h1 {
	background : pink;
}

</style>
</head>
<body>
<header>
	<h1>Header1</h1>
	<h2>Header2 자식</h2>
	<div>
		<h2>Header2 후손</h2>
		<h2>Header2 후손</h2>
	</div>
</header>


<section>
<div>
	<h1>Header1</h1>
	<div>
		<h2>Header2</h2>
		<h2>Header2</h2>
	</div>
</div>

</section>

</body>
</html>