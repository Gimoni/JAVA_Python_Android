<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="faviconAlpha.png">
<meta http-equiv="Coche-Control" content="no-store"> 
<title>dom.jsp</title>
<script type="text/javascript">
	// 이벤트 설정. window = javascript의 전역객체 
	window.onload = funcion() {	// DOM 구성이 완성이 된 상태에서 이벤트가 발생되는 함수 설정. 
		document.getElementById("xxx").style.color = "red";
		
	}
</script>
</head>
<body>
<header id="xxx">Header</header>
<article>
	<section>1</section>
	<section>2</section>
</article>
<footer>Footer</footer>
</body>
</html> 