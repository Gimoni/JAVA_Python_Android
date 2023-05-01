<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script src = "js/sprintf.js"></script>
<style type="text/css">
	html {
		padding: 20px;
		border: 10px solid red
	}
	
	body {
		margin: 0px;
		border: 10px solid blue;
	}
</style>
<script type="text/javascript">
	document.documentElement.oncontextmenu = function (e) {
		e.preventDefault();
	}
	document.documentElement.onmousedown = function (e) {
		let value = getComputedStyle(this).borderWidth;
		value = parseFloat(value);
		
		switch (e.button) {
		case 0: 	// left
			this.style.borderWidth = value + 1 + 'px';
			break;
		case 1:		// center
			this.style.borderWidth = '';
			break;
		case 2:		// right
			this.style.borderWidth = value - 1 + 'px';
			break;
		default :
			break;
		}
		console.log(sprintf("(%d,%3d,%3d)", e.button, e.clientX, e.clientY));
	
		
	}

</script>
</head>
<body>
<header id="header">
<h1>Hello</h1>
여기는 헤더 태그 입니다.
</header>

</body>


</html>