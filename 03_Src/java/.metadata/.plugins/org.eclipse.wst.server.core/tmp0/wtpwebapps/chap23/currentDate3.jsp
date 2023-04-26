<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store"> 
<title>currentDate3.jsp</title>
<script type="text/javascript" src="js/sprintf.js"></script>
<style type="text/css">
	#clock {
		position : relative;
		border-width: 5px;
		border-style: solid;
		border-color: red;
	}

</style>
</head>
<body>
<p id="clock">
<span id="date"></span>
<span id="time"></span>
<p>
<script type="text/javascript">
	function printDate() {
		let c = new Date();
		let year = c.getFullYear();
		let month = c.getMonth()+1;
		let day = c.getDate();
		let hour = c.getHours();
		let minute = c.getMinutes();
		let second = c.getSeconds();
	
		
		date.innerHTML = sprintf("%04d/%02d/%02d", year, month, day);
		time.innerHTML = sprintf("%02d:%02d:%02d", hour, minute, second);
		
		//setTimeout(printDate, 1000);
	}
	
	setInterval(printDate, 1000);
	console.log("timer start....")
</script>
</body>
</html>