<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	console.log("### 1 START");
	try {
	console.log(head.textContent) 		// error 
	} catch (e) {
		//console.dir(e);
		console.log("@@@@" + e.message);
	}
	console.log("### 1 END");
	alert("1");
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store"> 
<title>runflow.jsp</title>
<script type="text/javascript">
	console.log("### 2 START")
	console.log(head.textContent)	// error 
	console.log("### 2 END");
	alert("2");
</script>
</head>
<body>
<h1 id="head">자바스크립트 실행순서 실험</h1>
<script type="text/javascript">
	console.log("### 3 START")
	console.log(head.textContent)
	console.log("### 3 END")
	head.style.backgroundColor = "blue";
	head.style.color = "red";
	head.innerText = "Hello";
	alert("3");
</script>

</body>
</html>
<script type="text/javascript">
	console.log("### 4 START")
	console.log(head.textContent)
	console.log("### 4 END")
	head.style.width = "100px"
	head.style.height = "100px"
	alert("4");
</script>
