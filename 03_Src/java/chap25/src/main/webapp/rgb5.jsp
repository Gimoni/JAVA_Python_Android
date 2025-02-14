<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>rgb5.jsp</title>
<style type= "text/css">
html {
	border : 10px solid red;
}
body {
	border : 10px solid green;
}
div {
	border : 10px solid blue;
	width : 200px;
	height : 200px;
}

:focus {
	border: 10px dashed yellow; 
}

</style>
<script type="text/javascript">
class RGB  {
	constructor() {
		this.r = 0;
		this.g = 0;
		this.b = 0;
	}
	updateRed(value) {
		this.r += value;
		red.textContent = this.r;
		this.update();
	}
	updateGreen(value) {
		this.g += value;
		green.textContent = this.g;
		this.update();
	}
	updateBlue(value) {
		this.b += value;
		blue.textContent = this.b;
		this.update();
	}
	update() {
		box.style.backgroundColor = `rgb(\${this.r}, \${this.g}, \${this.b})`;
	}
	handleEvent(e) {
		this[e.type](e);
	}
	contextmenu(e) {
		console.log("contextmenu..");
		e.preventDefault();
	}
	mousedown(e) {
		console.log("mousedown..");
	}
	keydown(e) {
		console.log("keydown..");
	}
	 
}

window.onload = function(e) {
	
	let rgb = new RGB();
	
	box.addEventListener('contextmenu', rgb);
	box.addEventListener('mousedown', rgb);
	box.addEventListener('keydown', rgb);
	
	

}
</script>
</head>
<body>
<h1>RGB 실험</h1>
<table>
<tbody>
<tr><td>R</td><td id="red">0</td></tr>
<tr><td>G</td><td id="green">0</td></tr>
<tr><td>B</td><td id="blue">0</td></tr>
</tbody>
</table>
<hr>
<div id="box" tabindex="1"></div>

</body>
</html>