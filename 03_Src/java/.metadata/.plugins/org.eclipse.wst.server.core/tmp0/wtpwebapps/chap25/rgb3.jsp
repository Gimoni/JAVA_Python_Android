<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>rgb3.jsp</title>
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
}

window.onload = function(e) {
	
	let rgb = new RGB();
	
/* 	box.oncontextmenu = function(e) {
		e.preventDefault();
	} */
	
	box.oncontextmenu = ()=> false;
	
	box.onmousedown= function(e) {
		switch (e.button) {
		case 0:
			e.shiftKey ? rgb.updateRed(-10) : rgb.updateRed(10);
			break;
		case 1:
			e.shiftKey ? rgb.updateGreen(-10) : rgb.updateGreen(10);
			break;
		case 2: 
			e.shiftKey ? rgb.updateBlue(-10) : rgb.updateBlue(10);
			break;
		default:
			break;
		}
	}  
	
	box.onkeydown = function(e) {
		switch (e.code) {
		case "KeyR":
			e.key=='r' ? rgb.updateRed(-10) : rgb.updateRed(10);
			break;
		case "KeyG":
			e.key=='g' ? rgb.updateGreen(-10) : rgb.updateGreen(10);
			break;
		case "KeyB":
			e.key=='b' ? rgb.updateBlue(-10) : rgb.updateBlue(10);
			break;

		default:
			break;
		}
		
	}

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