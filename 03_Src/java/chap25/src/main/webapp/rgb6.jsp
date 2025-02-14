<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>rgb6.jsp</title>
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

#box:focus {
	border: 10px dashed yellow; 
}

input {
	display: block;
	width : 100%;
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
		this.update();
	}
	updateGreen(value) {
		this.g += value;
		this.update();
	}
	updateBlue(value) {
		this.b += value;
		this.update();
	}
	update() {
		red.textContent = this.r;
		green.textContent = this.g;
		blue.textContent = this.b;
		box.style.backgroundColor = `rgb(\${this.r}, \${this.g}, \${this.b})`;
	}
	handleEvent(e) {
		this[e.type](e);
		console.log("on" + e.type.charAt(0).toUpperCase() + e.type.slice(1));
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
	change(e) {
		switch (e.target.name) {
		case 'red':
			this.r = parseInt(e.target.value);
			break;
		case 'green':
			this.g = parseInt(e.target.value);
			break;
		case 'blue':
			this.b = parseInt(e.target.value);
			break;

		default:
			break;
		}
		this.update();
	}
	 
}

window.onload = function(e) {
	
	let rgb = new RGB();
	
	box.addEventListener('contextmenu', rgb);
	box.addEventListener('mousedown', rgb);
	box.addEventListener('keydown', rgb);
	slider.addEventListener('change', rgb);

}
</script>
</head>
<body>
<h1>RGB 실험</h1>
<fieldset id="slider" data-role="xxx">
	<legend>RGB</legend>
	<input id="ranR" name="red" type="range" min="0" max="255" value="0">
	<input id="ranG" name="green" type="range" min="0" max="255" value="0">
	<input id="ranB" name="blue" type="range" min="0" max="255" value="0">
</fieldset>
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