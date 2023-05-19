<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>result_checkbox.jsp</title>
</head>
<body>
<h1>결과값 처리</h1>
<hr>
<% 
 	String [] color = request.getParameterValues("color");
	
	int r=0;
	int g=0;
	int b=0;
	if (color != null) {
		for (var c : color) {
			out.println(String.format("<h3>%s</h3>", c));
			switch(c) {
			case "red":
				r = 255;
				break;
			case "green":
				g = 255;
				break;
			case "blue":
				b = 255;
				break;
			}
		}
	} else {
		out.println("<h3> 아무것도 선택하지 않았습니다. </h3>");
	}
	
%>
<div style="width:100px; height:100px; background: rgb(<%=r%>, <%=g%>, <%=b%>)"></div>
<hr>

<a href="form_checkbox.jsp">뒤로</a>
</body>
</html>