<%@page import="com.example.mapper.EmpMapper"%>
<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-store">
<link rel="icon" href="favicon.png">
<title>구조선택자3.jsp</title>
<style type="text/css">
body >*:first-child {	/* 전체의 제일 첫번째 자식 */
	background: red;
}

body >*:first-of-type {	/* 전체의 각 타입들 중 첫번째 자식 */
	background: blue;
}

body >*:last-of-type { /* 전체의 각 타입들 중 마지막 자식 */
	background: yellow;
}

</style>
</head>
<body>
<h1>Hello1</h1>
<h1>Hello1</h1>
<h2>Hello2</h2>
<h1>Hello1</h1>
<h2>Hello2</h2>
<h2>Hello2</h2>
<h3>Hello3</h3>
<h3>Hello3</h3>
<h3>Hello3</h3>
</body>
</html>