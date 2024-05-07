<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h2>회원탈퇴</h2>
	<form method="POST" action="/deleteUserAction">
		<input type="password" name="password" id="password-delete" placeholder="비밀번호 재확인"> 
		<input type="submit" value="회원탈퇴">
	</form>
</body>
</html>