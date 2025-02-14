
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<title>for.jsp</title>
</head>
<body>
<h1>forEach의 이해</h1>
<hr>
<c:forEach var="i" begin="10" end="20">
	<h6>i = ${i}</h6>
</c:forEach>
<hr>
<c:forEach var="d" items="${list}"> 
	<h6>${d}</h6>
</c:forEach>
<hr>
<c:forEach var="d" items="${list}" varStatus="status">
	<h6>${satuts.index} ${status.count} ${d}</h6>
</c:forEach>
<hr>
<c:forEach var="d" items="${map}">
	<h6>key=${d.key} value=${d.value} dept=${d}</h6>
</c:forEach>
<hr>

<c:if test="${empty map}">  <!-- map을 empty로 변경. -->
<c:forEach var="d" items="${map}" varStatus="status">
	<h6>#${status.index} #key=${d.key} #value=${d.value} #dept=${d}</h6>
</c:forEach>
</c:if>

<hr>

<c:if test="${!empty map}">
<c:forEach var="d" items="${map}" varStatus="status">
	<h6>#${status.index} #key=${d.key} #value=${d.value} #dept=${d}</h6>
</c:forEach>
존재합니다.
</c:if>
<hr>

<c:set var="html" value="<button>btn</button>" scope="request"/>
${html} <br>
<c:out value="${html}"/><br> 
<!-- c:out 태그가 이스케이프됨 (문자열로 출력)  -->
<c:out value="${html}" escapeXml="false"/><br> 
<!-- c:out  escapeXml="false" 태그 이스케이프를 동작시키지 않음 > escapeXml  -->
<hr>




</body>
</html>