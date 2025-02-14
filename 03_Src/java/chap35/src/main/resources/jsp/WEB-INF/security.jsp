
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>security.jsp</title>
</head>
<body>
<h1>Spring Security Tag의 이해</h1>
<hr>
<!-- authorize 권한 여부에 따라 접근 가능 부여?? -->
<sec:authorize access="isAuthenticated()">
로그인해서 인증을 받은 사람이라면 이 글이 보인다. 
</sec:authorize>
<hr>
<sec:authorize access="hasRole('USER')">
지금 접속한 사람은 USER 권한이 있습니다.
</sec:authorize>
<hr>
<sec:authorize access="hasRole('MANAGER')">
지금 접속한 사람은 MANAGER 권한이 있습니다.
</sec:authorize>
<hr>
<sec:authorize access="hasRole('SQL')">
지금 인증된 사람은 SQL 입니다.
</sec:authorize>
<hr>
로그인 이름 : <sec:authentication property="name"/>
<hr>
권한 = <sec:authentication property="principal.authorities"/>

</body>
</html>