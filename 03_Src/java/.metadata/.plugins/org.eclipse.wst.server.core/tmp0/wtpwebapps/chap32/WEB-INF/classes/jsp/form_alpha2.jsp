<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-store">
<link rel="icon" href="favicon.png">
<script src="js/alpha.js"></script>
<style type="text/css">
input[type='range'] {
	display: block;
	width: 100%;
}

fieldset {
	border: 1px solid blue;
}
</style>
<title>alpha.jsp</title>
</head>
<body>
<h1>Form 실습@@@</h1>
<hr>
<form name="alpha" action="result_alpha2.jsp">
<fieldset name="count">
	<legend>Count</legend>
	<label for="linCount">Line</label>
	<input id="linCount" name="lineCount" type="number" min="10" max="100" step="10" value="10">
	<label for="columnCount">Column</label>
	<input id="columnCount" name="columnCount" type="number" min="10" max="100" step="10" value="10">
</fieldset>
<fieldset name="position">
	<legend>Position</legend>
	<input name="line"   type="range" min="1" max="20">
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
	<input name="fg2"type="color" value="#ff0000">
	<label>Background</label>
	<select name="bg">
		<option value="red">Red</option>
		<option value="green">Green</option>
		<option value="blue">Blue</option>
	</select>
	<input name="bg2"type="color" value="#0000ff">
</fieldset>
<fieldset>
	<legend>Sort</legend>
	<label for="sLine"  >Line</label>
	<input id="sLine"    name="sort" type="checkbox" value="line">
	<label for="sColumn">Column</label>
	<input id="sColumn"  name="sort" type="checkbox" value="column">
	<label for="sFg"    >Foreground</label>
	<input id="sFg"      name="sort" type="checkbox" value="fg">
	<label for="sBg"    >Background</label>
	<input id="sBg"      name="sort" type="checkbox" value="bg">
	<label for="sCh"    >Character</label>
	<input id="sCh"      name="sort" type="checkbox" value="ch">
</fieldset>
<fieldset name="character">
	<legend>Character</legend>
	<table border="1">
		<tbody>
			<tr><th>A</th><th>B</th><th>C</th><th>D</th><th>E</th><th>F</th><th>G</th><th>H</th><th>I</th><th>J</th></tr>
			<tr>
				<td><input name="ch" type="radio" value="A"></td>
				<td><input name="ch" type="radio" value="B"></td>
				<td><input name="ch" type="radio" value="C"></td>
				<td><input name="ch" type="radio" value="D"></td>
				<td><input name="ch" type="radio" value="E"></td>
				<td><input name="ch" type="radio" value="F"></td>
				<td><input name="ch" type="radio" value="G"></td>
				<td><input name="ch" type="radio" value="H"></td>
				<td><input name="ch" type="radio" value="I"></td>
				<td><input name="ch" type="radio" value="J"></td>
			</tr>
			<tr><th>K</th><th>L</th><th>M</th><th>N</th><th>O</th><th>P</th><th>Q</th><th>R</th><th>S</th><th>T</th></tr>
			<tr>
				<td><input name="ch" type="radio" value="K"></td>
				<td><input name="ch" type="radio" value="L"></td>
				<td><input name="ch" type="radio" value="M"></td>
				<td><input name="ch" type="radio" value="N"></td>
				<td><input name="ch" type="radio" value="O"></td>
				<td><input name="ch" type="radio" value="P"></td>
				<td><input name="ch" type="radio" value="Q"></td>
				<td><input name="ch" type="radio" value="R"></td>
				<td><input name="ch" type="radio" value="X"></td>
				<td><input name="ch" type="radio" value="T"></td>
			</tr>
			<tr><th>U</th><th>V</th><th>W</th><th>X</th><th>Y</th><th>Z</th><th colspan="4"></th></tr>
			<tr>
				<td><input name="ch" type="radio" value="U"></td>
				<td><input name="ch" type="radio" value="V"></td>
				<td><input name="ch" type="radio" value="W"></td>
				<td><input name="ch" type="radio" value="X"></td>
				<td><input name="ch" type="radio" value="Y"></td>
				<td><input name="ch" type="radio" value="Z"></td>
				<td colspan="4"></td>
			</tr>
		</tbody>
	</table>
</fieldset>

<fieldset name="날짜">
	<legend>날짜</legend>
	<input name="date" type="date" min="2010-01-01" max="2023-12-31">
	<input name="time" type="time">
</fieldset>

<fieldset name="글쓰기">
	<legend>글쓰기</legend>
	<lable>이메일</lable>
	<input name="email" type="email"><br>
	<lable>제 목</lable>
	<input name="subject" type="text" maxlength="10"><br>
	<lable>내용</lable><br>
	<textarea name="content" rows="10" cols="30"></textarea>
</fieldset>

<fieldset name="execution">
	<legend>Execution</legend>
	<input type="reset"  value="Reset">
	<input type="submit" value="Create">
</fieldset>
</form>

</body>
</html>