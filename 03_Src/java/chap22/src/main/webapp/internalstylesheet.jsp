<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store"> 
<title>internalstylesheet.jsp</title>
<style type="text/css">
/* Internal Style Sheet */
	/* 	태그선택자 */
	body {
		font-family: monospace;
		font-size: 30px;
	}
	header {
		color: red;
		background-color: blue;
	}
	
	article {
		background-color: green;
		height: 400px;
	}
	
	footer {
		color: yellow;
		background-color: purple;
	}
	
	#hey {
		color: green;
		background-color: yellow;
	}

</style>
</head>
<body>
<!-- Inline style sheet -->
<header style= "font-size:50pt">Header</header>
<article>
<marquee width="50%" height="50px" font-size="90%">HELLO WORLD</marquee><br>
<marquee width="50%" height="50px" font-size="90%">HELLO WORLD</marquee><br>
<marquee width="50%" height="50px" font-size="90%">HELLO WORLD</marquee><br>
<marquee width="50%" height="50px" font-size="90%">HELLO WORLD</marquee><br>

</article>
<footer>Footer1</footer>
<footer style= "background-color: white; color: pink; font-style: italic;">Footer2</footer>
<footer style= "background-color: pink; color: white; font-weight: bold;">Footer3</footer>
<footer id="hey">Footer4</footer>

</body>
</html>