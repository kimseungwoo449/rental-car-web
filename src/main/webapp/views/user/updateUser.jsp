<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<h2>회원정보변경</h2>
	<form method="POST" action="/updateUserAction">
		<input type="text" name="id" id="id" value="${user.id}" disabled> 
			<input type="password" name="password" id="password-update" placeholder="현재 비밀번호">
			<input type="password" name="new-password" id="new-password" placeholder="변경할 비밀번호">
			<input type="text" name="email" id="email" placeholder="E-MAIL [선택]">
			<input type="hidden" name="resident-number" id="resident-number" value="${user.residentNumber}"> 
			<input type="text" name="phone" id="phone" placeholder="변경할 핸드폰번호 (-포함 13자리)">

			<input type="text" name="name" id="name" value="${user.name}" disabled>
			<div id="error-container">
				<p class="error-msg" id="error-msg-email-pattern">* 이메일의 형식을 다시
					확인해 주세요.</p>
				<p class="error-msg" id="error-msg-phone-pattern">* 휴대전화번호:
					휴대전화번호가 정확한지 확인해 주세요.</p>
			</div>
			<input type="submit" value="회원정보수정">
	</form>
	<script src="/resources/script/validation-update.js"></script>
</body>
</html>