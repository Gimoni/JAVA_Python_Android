
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
<link rel="icon" href="/heart_like_love_icon.png"> 
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>

<title>delete.jsp</title>
</head>
<body>
<h1>Emp Delete 직원 삭제</h1>
<hr>
<a href="/">Home</a>
<hr>
<a href="/emp/list">/emp/list</a>
<hr>
<section class="container">
	<form action="/emp/delete" method="post">
		<div class="mb-3">
			<label class="form-lable mb-2" for="empno">empno<span>*</span></label>
			<input class="form-control"    id="empno" name="empno"  value="${emp.empno}" disabled = "disabled"/>
			<input class="form-control"    id="empno" name="empno"  value="${emp.empno}" type = "hidden"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="ename">ename<span>*</span></label>
			<input class="form-control"    id="ename"  name="ename"  value="${emp.ename }" disabled= "disabled"/>
			<input class="form-control"    id="ename"  name="ename"  value="${emp.ename }" type= "hidden"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="gender">gender<span></span></label>
			<input class="form-control"    id="gender"  name="gender"  placeholder="성별을 입력하세요" value="${emp.gender}" disabled= "disabled"/>
			<input class="form-control"    id="gender"  name="gender"  placeholder="성별을 입력하세요" value="${emp.gender}" type= "hidden"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="job">job<span></span></label>
			<input class="form-control"    id="job"  name="job"  placeholder="직무를 입력하세요" value="${emp.job }" disabled= "disabled"/>
			<input class="form-control"    id="job"  name="job"  placeholder="직무를 입력하세요" value="${emp.job }" type= "hidden"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="mgr">mgr<span></span></label>
			<input class="form-control"    id="mgr"  name="mgr"  placeholder="매니저를 입력하세요." value="${emp.mgr}" disabled= "disabled"/>
			<input class="form-control"    id="mgr"  name="mgr"  placeholder="매니저를 입력하세요." value="${emp.mgr}" type= "hidden"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="hiredate">hiredate<span></span></label>
			<input class="form-control"    id="hiredate"  name="hiredate"  placeholder="입사일을 입력하세요" value="${emp.hiredate }" disabled= "disabled"/>
			<input class="form-control"    id="hiredate"  name="hiredate"  placeholder="입사일을 입력하세요" value="${emp.hiredate }" type= "hidden"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="sal">sal<span></span></label>
			<input class="form-control"    id="sal"  name="sal"  placeholder="급여를 입력하세요" value="${emp.sal }" disabled= "disabled"/>
			<input class="form-control"    id="sal"  name="sal"  placeholder="급여를 입력하세요" value="${emp.sal }" type= "hidden"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="comm">comm<span></span></label>
			<input class="form-control"    id="comm"  name="comm"  placeholder="커미션을 입력하세요."  value=" ${emp.comm}" disabled= "disabled"/>
			<input class="form-control"    id="comm"  name="comm"  placeholder="커미션을 입력하세요."  value=" ${emp.comm}" type= "hidden"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="deptno">deptno<span></span></label>
			<input class="form-control"    id="deptno"  name="deptno"  placeholder="부서번호를 입력하세요." value="${emp.deptno}" disabled= "disabled"/>
			<input class="form-control"    id="deptno"  name="deptno"  placeholder="부서번호를 입력하세요." value="${emp.deptno}" type= "hidden"/>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>	
</section>
<hr>
<c:if test="${binding.hasErrors()}">
<h2>Error Massage</h2>
<hr>
<c:forEach var="g" items="${binding.globalErrors}">
	<div>${g.code} ${g.defaultMessage}</div>
</c:forEach>
<hr>
<c:forEach var="f" items="${binding.fieldErrors}">
	<div>${f.field} ${f.defaultMessage}</div>
</c:forEach>

</c:if>

</body>
</html>