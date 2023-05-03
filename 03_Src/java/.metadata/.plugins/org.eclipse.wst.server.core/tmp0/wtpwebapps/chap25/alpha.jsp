<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<script src="js/alpha.js"></script>
<style type="text/css">
input[type='range'] {
	display: block;
	width: 100%;
}
</style>
<title>alpha.jsp</title>
</head>
<body>
<h1>Form 실습</h1>
<hr>
<form name="alpha" onsubmit="console.log('submit...'); return false;">
<fieldset name="position">
	<legend>Position</legend>
	<input name="line" type="range" min="1" max="20">
	<input name="column" type="range" min="1" max="40">
</fieldset>
<fieldset name="color">
	<legend>Color</legend>
	<label>Foreground</label>
	<select name="fg">
		<option value="red">Red</option>
		<option value="green">Green</option>
		<option value="blue">Blue</option>
	</select>
	<label>Background</label>
	<select name="bg">
		<option value="red">Red</option>
		<option value="green">Green</option>
		<option value="blue">Blue</option>
	</select>
</fieldset>
<fieldset name="char">
	<legend>Character</legend>
</fieldset>
<fieldset name="exe">
	<legend>Execution</legend>
	<input type="reset"  value="Reset">
	<input type="submit" value="Create">
</fieldset>
</form>


</body>
</html>