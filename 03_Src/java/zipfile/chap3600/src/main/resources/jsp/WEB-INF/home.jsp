<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="/faviconAlpha.png"> 
<link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.css">
<script src="/webjars/bootstrap/5.2.3/js/bootstrap.js"></script>
<script src="/webjars/jquery/jqurey.min.js"></script>

<title>home.jsp</title>
</head>
<body>
<h1>Home page</h1>
<hr>
로그인 이름 : <sec:authentication property="name"/>
<hr>
<ul>
	<li><a href="/dept/list"    >/dept/list</a></li>
	<li><a href="/emp/list"     >/emp/list</a></li>
	<li><a href="/salgrade/list">/salgrade/list</a></li>
</ul>
<hr>
<ul>
	<li><a href="/dept/create"    >/dept/create</a></li>
	<li><a href="/emp/create"     >/emp/create</a></li>
	<li><a href="/salgrade/create">/salgrade/create</a></li>
</ul>
<hr>
<ul>
	<li><a href="/city/list"         >/city/list</a></li>
	<li><a href="/city/page/1/10"    >/city/page</a></li>
	<li><a href="/country/list"      >/country/list</a></li>
	<li><a href="/country/page/1/10" >/country/page</a></li>
	<li><a href="/language/list"     >/language/list</a></li>
	<li><a href="/language/page/1/10">/language/page</a></li>
</ul>

</body>
</html>