<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> 
<title>박스모델4.jsp</title>
<style type="text/css">
	.box {
		width:100px;
		height: 100px;
		border: 1px solid red;
	}

	.box1 {
		margin-top: 10px;
		margin-right: 20px;
		margin-bottom: 30px;
		margin-left: 40px;
	}
	/* 시계방향으로 4방향을 표기를 한다. */
	.box2 {
		margin: 10px 20px 30px 40px;
	}
	/* 위, 아래 || 우측, 좌측 표기 */
	.box3 {
		margin: 10px 20px;
	}
	/* 4방향의 모두 같은 값으로.  */
	.box4 {
		margin: 10px;
	}
	
</style>

</head>
<body>
<div class="box box1">box1</div>
<div class="box box2">box2</div>
<div class="box box3">box3</div>
<div class="box box4">box4</div>


</body>
</html>