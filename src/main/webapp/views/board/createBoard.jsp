<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<script src="/resources/script/validation-create-board.js"></script>
<body>
	<form action="/createBoardAction" method="POST">
		<input type="text" name="title" id="title" placeholder="제목">
		<input type="text" name="contents" id="contents" placeholder="내용">
		<input type="submit" value="등록하기">
	</form>
</body>
<c:import url="footer"></c:import>
</html>