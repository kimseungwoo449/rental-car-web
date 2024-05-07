<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<head>
<script src="/resources/script/validation-join.js"></script>
</head>
<body>
	<section id="root">
		<h2>회원가입</h2>
		<form method="POST" action="/joinAction">
			<input type="text" name="id" id="id" placeholder="ID"> 
			<input type="password" name="password" id="password" placeholder="PASSWORD">
			<input type="text" name="email" id="email" placeholder="E-MAIL [선택]">
			<input type="text" name="resident-number" id="resident-number" placeholder="주민등록번호(- 포함 14자리)"> 
			<input type="text" name="phone" id="phone" placeholder="핸드폰번호 (-포함 13자리)">

			<div id="gender-check">
				<input type="radio" name="gender" id="male" value="M" checked>
				<input type="radio" name="gender" id="female" value="F"> <label
					for="male" id="label-male">남자</label> <label for="female"
					id="label-female">여자</label>
			</div>
			<input type="text" name="name" id="name" placeholder="이름">
			<div id="error-container">
				<p class="error-msg" id="error-msg-id">* 아이디: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-password">* 비밀번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-email-pattern">* 이메일의 형식을 다시
					확인해 주세요.</p>
				<p class="error-msg" id="error-msg-resident-number">* 주민등록번호: 필수
					정보입니다.</p>
				<p class="error-msg" id="error-msg-resident-number-pattern">*
					주민등록번호는 - 포함 14자리입니다.</p>
				<p class="error-msg" id="error-msg-phone">* 휴대전화번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-phone-pattern">* 휴대전화번호:
					휴대전화번호가 정확한지 확인해 주세요.</p>
				<p class="error-msg" id="error-msg-name">* 이름: 필수 정보입니다.</p>
			</div>
			<input type="submit" value="회원가입">
		</form>
	</section>
</body>
<c:import url="/footer"></c:import>
</html>