<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Coche-Control" content="no-store"> 
<title>form.jsp</title>
<style type="text/css"></style>
</head>
<body>

<hr>
<form action="form.jsp">
	<label for="name">name : </label>
	<input id="name" name="name" type="text" value="gimon"/><br>
	<label for="mobile" >mobile : </label>
	<input id="mobile" name="mobile" type="tel" value="010-1234-5678"/><br>
	<label for="age" >age : </label>
	<input id="age" name="age" type="number" min="1" max="100" value="10"/>
	<input type="reset" value="clear"/>
	<input type="submit" value="submit"/>
</form>
<hr>
<%
	String name = request.getParameter("name");
	String tel = request.getParameter("mobile");
	Integer age = null; 
	try{
		age = Integer.parseInt(request.getParameter("age"));
	} catch (NumberFormatException e){
		e.printStackTrace();
	}
%>
<hr>
<h3><span>name: </span><%=name%></h3>
<h3><span>mobile:</span><%=tel%></h3>
<h3><span>age :</span><%=age%></h3>

</body>
</html>