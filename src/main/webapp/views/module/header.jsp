<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="icon"
	href="https://cdn-icons-png.flaticon.com/128/5670/5670281.png">
<link rel="stylesheet" href="/resources/style/grid.css">
<title>KSW렌터카</title>
</head>
<body>
	<header>
		<img src="https://cdn-icons-png.flaticon.com/128/48/48688.png"
			id="logo" onclick="location.href='/'">
		<div id="navs">
			<nav id="reservation-check">예약확인</nav>
			<nav id="board">문의게시판</nav>
			<nav id="notice">공지사항</nav>
			<nav id="mypage" onclick="location.href='/mypage'">마이페이지</nav>
		</div>
		<div id="buttons">
			<c:choose>
			<c:when test="${not empty sessionScope.user}">
				<button onclick="location.href='/logoutAction'">로그아웃</button>
			</c:when>
			<c:otherwise>
				<button id="login" onclick="location.href='/login'">로그인페이지로 이동</button>
				<button id="join" onclick="location.href='/join'">회원가입</button>
			</c:otherwise>
		</c:choose>
		</div>
	</header>
</body>
</html>