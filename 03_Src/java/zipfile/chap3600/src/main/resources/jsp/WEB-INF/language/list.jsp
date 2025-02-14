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

<title>list.jsp</title>
</head>
<body>
<h1>Language list</h1>
<hr>
<button type="button" class="btn btn-warning">
<a href="/">Home</a>
</button>
<hr>
<section >
	<table >
		<thead >
			<tr>
				<th>countryCode</th>
				<th>language</th>
				<th>is_official</th>
				<th>percentage</th>	
			</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${list}">
			<tr>
				<td>${e.countryCode}</td>
				<td>${e.language}</td>
				<td>${e.isOfficial}</td>
				<td>${e.percentage}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</section>

</body>
</html>