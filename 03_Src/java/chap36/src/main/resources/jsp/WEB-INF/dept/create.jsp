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

<title>create.jsp</title>
</head>
<body>
<h1>Dept create 부서 추가</h1>
<hr>
<a href="/">Home</a>
<hr>
<a href="/dept/list">dept/list</a>
<hr>
<section class="container">
	<form action="/dept/create" method="post">
		<div class="mb-3">
			<label class="form-lable mb-2" for="deptno">deptno <span>*</span> </label>
			<input class="form-control"     id="deptno" name="deptno" placeholder="부서번호를 입력하세요"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="dname">dname <span>*</span> </label>
			<input class="form-control" 	id="dname" name="dname" placeholder="부서이름을 입력하세요"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="loc">loc</label>
			<input class="form-control" 	id="loc" name="loc" placeholder="부서위치를 입력하세요"/>
		</div>
		<button type="submit" class="btn btn-warning">Submit</button>
	</form>
</section>

</body>
</html>