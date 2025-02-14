<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>innerHTML2.jsp</title>
<style type="text/css">
ol {
	border: 10px solid red;
}

div {
	border: 10px solid blue;
	padding: 10px;
	background-color: green;
	width: 300px;
	height: 300px;
}
</style>
<script type="text/javascript">

function addItem(str, e) {
	let li = `
		<li>[\${str}] 
			button=\${e.button} 
		   altKey=\${e.altKey}
		   ctrlKey=\${e.ctrlKey}
		   shiftKey=\${e.shiftKey}
		   metaKey=\${e.metaKey}
		   [\${e.clientX}, \${e.clientY}]		// 화면상 좌표
		   [\${e.offsetX}, \${e.offsetY}]		
		<\li>
	`
	ol.innerHTML = li + ol.innerHTML;
}

window.onload = function(e) {
	console.log(e);
	
	div.onmousedown = function (e) {
		console.log(e);
		
		addItem("DOWN", e)
		
	}	
	
	div.onmouseup = function (e) {
		console.log(e);
		
		addItem("UP", e)
	}	
	div.onmousemove = function (e) {
		console.log(e);
		
		addItem("MOVE", e)
	}
	div.onclick = function(e) {
		addItem("CLICK", e);
	}
	div.onmouseover = function (e) {
		this.style.borderColor= 'red';	
	}
	div.onmouseout = function (e) {
		this.style.borderColor= 'blue';	
	}
	
		ol.onclick = function(e) {
			this.innerText ="";
		}
}

</script>
</head>

<body>
<h1>MouseEvent testing1</h1>
<div id="div">

</div>
<ol id="ol" reversed="reversed">
</ol>
</body>
</html>
