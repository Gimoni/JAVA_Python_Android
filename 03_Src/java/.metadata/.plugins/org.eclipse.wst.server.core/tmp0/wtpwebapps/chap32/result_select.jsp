<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>result_select.jsp</title>
</head>
<body>
<h1>결과 값</h1>
<hr>
<% 
	String content = request.getParameter("content");
%>
<pre><%=content%></pre>
<hr>
<a href="from_select">뒤로</a>

</body>
</html>