<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>table.jsp</title>
</head>
<body>
<h1>table 실습</h1>
<table id="table" border="2">
	<thead>
		<tr><th colspan="2">Position</th><th colspan="2">Color</th></tr>
		<tr><th>line</th><th>column</th><th>fg</th><th>bg</th><th>ch</th></tr>
	</thead>
	<tbody>
		<tr><td colspan="2" rowspan="2">10</td><td>red</td><td>Blue</td><td rowspan="3">A</td></tr>
		<tr>								   <td>red</td><td>Blue</td></tr>
		<tr><td>10</td><tb>30</td><td>red</td><td>Blue</td></tr>
	</tbody>
	<tfoot>
	</tfoot>
</table>
</body>
</html>