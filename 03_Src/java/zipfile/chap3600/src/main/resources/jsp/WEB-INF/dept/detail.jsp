<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<title>detail.jsp</title>
</head>
<body>
<h1>Dept detail 부서 정보</h1>
<hr>
<a href="/">Home</a>
<hr>
<a href="/dept/list">dept/list</a>
<hr>
<section class="container">
	<table class="table">
		<tbody>
			<tr>
				<tr><th>deptno</th>	<td>${dept.deptno}</td></tr>
				<tr><th>dname</th>	<td>${dept.dname}</td></tr>
				<tr><th>loc</th>	<td>${dept.loc}</td></tr>
			</tr>
		</tbody>
	</table>
	<hr>
	<menu class="btn-group">
		<a href="/dept/create" class="btn btn-primary">추가</a>
		<a href="/dept/update" class="btn btn-secondary">수정</a>
		<a href="/dept/delete" class="btn btn-danger">삭제</a>
	</menu>
	<hr>
		<li><a href="/dept/create">/dept/create</a></li>
		<li><a href="/dept/update">/dept/update</a></li>
		<li><a href="/dept/delete">/dept/delete</a></li>
	<ul>
	
	</ul>
</section>

</body>
</html>