<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="/favicon.png">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>

<title>create.jsp</title>
</head>
<body>
<h1>Dept Create 부서 추가</h1>
<hr>
<a href="/">Home</a>
<hr>
<a href="/dept/list">/dept/list</a>
<hr>
<section class="container">
	<form action="/dept/create" method="post">
		<div class="mb-3">
			<label class="form-lable mb-2" for="deptno">deptno<span>*</span></label>
			<input class="form-control"    id="deptno" name="deptno" placeholder="부서번호를 입력하세요." value="${dept.deptno}"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="dname">dname<span>*</span></label>
			<input class="form-control"    id="dname"  name="dname"  placeholder="부서이름를 입력하세요." value="${dept.dname }"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="loc">loc</label>
			<input class="form-control"    id="loc"	   name="loc"    placeholder="부서위치를 입력하세요." value="${dept.loc}"/>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>	
</section>
<hr>
${binding}
<c:if test="${binding.hasErrors()}">
	<h2>Error Massage</h2>
	<hr>
	<c:if test="${binding.hasGlobalErrors()}">
		<c:forEach var="g" items="${binding.globalErrors} ">
			<div>${g.code} ${g.defaultMessage}</div>
		</c:forEach>
	</c:if>
	<hr>
	<c:forEach var="f" items="${binding.fieldErrors} ">
		<div>${f.field}</div>
	</c:forEach>
	
</c:if>

</body>
</html>