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
<title>page.jsp</title>
<style type="text/css">
.page-item :hover {
	color: white;
}
.page-item :active {
	background-color: pink;
}
</style>
</head>
<body>
<h1>City Page &nbsp;<span class="badge bg-dark">${paging.pageNum}</span></h1>
<button type="button" class="btn btn-warning">
<a href="/">Home</a>
</button>
<hr>
<section class="container table-responsive" style="border: 10px dashed gray">
	<table class="table table-striped table-dark table-bordered table-hover">
		<thead class="table-warning">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>countryCode</th>
				<th>district</th>
				<th>population</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${list}">
			<tr>
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td>${e.countryCode}</td>
				<td>${e.district}</td>
				<td align="right">
					<fmt:formatNumber pattern="###,###,###,###" value="${e.population}"/>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<hr>
	<section class="container">
	<ul class="pagination justify-content-center"  style="margin:20px 5">
		<li class="page-item" style="margin:20px 5"><a href="/city/page/${paging.navigateFirstPage-1}/${paging.pageSize}" class="page-link">Previous</a></li>
	<c:forEach var="n" items="${paging.navigatepageNums}">
		<c:choose>
			<c:when test="${n eq paging.pageNum}">
				<li class="page-item active" style="margin:20px 5"><a href="/city/page/${n}/${paging.pageSize}" class="page-link">${n}</a></li>
			</c:when>
			<c:when test="${n ne paging.pageNum}">
				<li class="page-item " style="margin:20px 5"    ><a href="/city/page/${n}/${paging.pageSize}"  class="page-link">${n}</a></li>
			</c:when>
		</c:choose>
	</c:forEach>
		<li class="page-item" style="margin:20px 5"><a href="/city/page/${paging.navigateLastPage+1}/${paging.pageSize}" class="page-link">Next</a></li>
	</ul>
	
	<hr>
	
	
	<div>
	<pre>
<%-- 	${json} --%>
	</pre>
	</div>
</section>

</body>
</html>