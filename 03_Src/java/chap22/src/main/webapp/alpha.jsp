<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store"> 
<title>alpha.jsp</title>
</head>
<body>
<%
// 스크립트릿(Scriptlet)
	Random r = new Random();
	for(int i=0; i<40; i++) {
		char ch = (char)r.nextInt('A','Z'+1);
		out.println(String.format("<span>%c</span>\n", ch));
	}
		

%>

</body>
</html>