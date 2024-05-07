<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header"></c:import>
<body>
	<section id="root">
		<h2>로그인</h2>
		<form method="POST" action="/loginAction">
			<input type="text" name="id" id="id" placeholder="ID">
			<input type="text" name="password" id="password" placeholder="PASSWORD">
			<input type="submit" value="로그인">
		</form>
	</section>
</body>
<c:import url="/footer"></c:import>
</html>