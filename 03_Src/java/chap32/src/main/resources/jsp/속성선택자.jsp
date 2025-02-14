<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store">
<link rel="icon" href="faviconAlpha.png"> 
<title>속성선택자.jsp</title>
<style type="text/css">
	div {
		width: 100px;
		height: 100px;
	}
	div[class="red"] {
		border: 10px dashed yellow;
	}
	div[class^="btn"] {	/* class 속성의 값 첫 시작이 btn이면 선택 적용됨 */
		border: 5px solid black;
	}
	div[class$="green"] { /*class 속성의 값 끝이 green으로 선택되면 적용 // 나온 순서대로 적용되는 캐스케이팅. */
		border: 10px dotted green;
	}
	div[class$="red"] {
		border: 10px dotted red;
	}
	div[class~="box"] { /*class 속성의 문자열 중 단어로 일치하는 클래스가 있으면 적용 */
		text-align : center;
		line-height: 100px;
	}
	div[class*="x g"] { /*class 속성의 문자열 중 x g 로 일치하는 클래스가 있으면 적용 */
		background: yellow;
	}
	div[class*="tn re"] { /*class 속성의 문자열 중 tn r 로 일치하는 클래스가 있으면 적용 */
		background: red;
	}
	div[class|=""] { /* ??? */
		background: pink;
	}

</style>
</head>
<body>
<div class="red">box1</div>
<div class="btn box green">box2</div>
<div class="btn red">box3</div>
<div class="btn box green">box4</div>
<div class="btn red">box5</div>
<div class="btn pink-red">box5</div>

</body>
</html>