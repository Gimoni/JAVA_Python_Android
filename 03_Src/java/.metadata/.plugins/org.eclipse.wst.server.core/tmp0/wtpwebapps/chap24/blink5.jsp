<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>blink4.jsp</title>
<style type="text/css">
	html {
		border : 10px solid gray;
	}
	
	body {
		border : 10px solid blue;
	}
	table#table {
		border-collapse: collapse;
		border : 10px solid green;
	}
	td#td{ 
		font-family :monospace;
		background : yellow;
	}
	td {
		font-family :monospace;
	}
	
</style>
<script type="text/javascript">
class Color {
	static Black = "blcak";
    static Red	= "red";
    static Green = "green";
    static Yellow = "yellow";
    static Blue = "blue";
    static Magenta = "magenta";
    static Cyan = "cyan";
    static White = "white";
    
    static values() {
    	return [Color.Black, Color.Red, Color.Green, 
    			Color.Yellow, Color.Blue, Color.Magenta,
    			Color.cyan, Color.white];
    };
}

class Alpha {
	constructor() {
		this.line = parseInt(1, 20);
		this.column = parseInt(1, 40);
		do {
			this.fg = Color.values()[parseInt(Math.random()*8)];
			this.bg = Color.values()[parseInt(Math.random()*8)];
		} while (this.fg===this.bg);
		this.ch = String.fromCharCode([parseInt(Math.random()*26+ 'A'.charCodeAt(0))] );
	}
	
	show() {
		let cell = table.rows[this.line-1].cells[this.column-1];
		cell.style.color = this.fg;
		cell.style.background = this.bg;
		cell.textContent = this.ch;
		cell.style.opacity = 1;
	}
	
	hide() {
		let cell = table.rows[this.line-1].cells[this.column-1];
		cell.style.opacity = 0;
	}
	move() {
		this.hide();
		
		if(this.line===1 && this.column < 40) {
			this.column++;
		} else if  (this.column === 40 && this.line < 20) {
            this.line++;
        } else if (this.line === 20 && this.column > 1) {
            this.column--;
        } else if (this.column === 1 && this.line > 1) {
            this.line--;
        }
	}
	
	isShow = true;
	blink() {
		if (this.isShow)
			this.show();
		else 
			this.hide();
		
		this.isShow = !this.isShow;
	}
}

class run() {
	hide();
	
	if (this.line==1 &&)
}
</script>
<script type="text/javascript">
window.onload = function() {
	for (let i=0; i<50; i++) {
		let a = new Alpha();
		setInterval(() => {
			a.blink();
		}, Math.random()*200+10);
	}
}
</script>
</head>
<body>
<h1>Header</h1>
<table>
	<tbody>
		<tr><td>만든이</td><td>뽀로로</td></tr>
		<tr><td>작성일</td><td>2023/05/02</td></tr>
		<tr><td>과 목</td><td>HTML/CSS/JAVASCRIPT</td></tr>
	</tbody>	
</table>
<table id="table">
	<tbody>
<!-- 	<tr><td>1</td><td>2</td></tr> -->
	<%
		for (int i=0; i<20; i++) {
			out.print("<tr>");
			for (int j=0; j<40; j++) {
				out.print("<td id='td'; style='opacity: 0;'>");
				out.print((char)(Math.random()*26+ 'A'));
				out.print("</td>");
			}
			out.print("</tr>");
		}
	
	%>
	</tbody>
</table>
</body>
</html>