<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<body>
	<form action="/updateBoardAction" method="POST">
		<input type="text" name="title" id="title" value="${targetBoard.title}">
		<input type="text" name="contents" id="contents" value="${targetBoard.contents}">
		<input type="submit" value="등록하기">
	</form>
</body>
<c:import url="/footer"></c:import>
</html>