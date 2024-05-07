<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header"></c:import>
<body>
	<c:choose>
		<c:when test="${not empty sessionScope.user}">
			<aside>
				<p>예약확인</p>
				<p>회원정보수정</p>
				<p>회원탈퇴</p>
			</aside>
			<section id="root">
				<c:import url="/updateUser"></c:import>
			</section>		
		</c:when>
		<c:otherwise>
			<c:redirect url="/"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
<c:import url="footer"></c:import>
</html>