<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<body>
	<section id="mypage-container">
		<c:choose>
			<c:when test="${not empty sessionScope.user}">
				<aside id="mypage-menu">
					<h2>마이 페이지</h2>
					<p class="mypage-menu-p" id="reservation-check-p">예약확인</p>
					<p class="mypage-menu-p" id="modify-user-data-p">회원정보수정</p>
					<p class="mypage-menu-p" id="leave-user-p">회원탈퇴</p>
				</aside>
				<section class="show-in-mypage" id="reservation-check-container">
					<c:import url="/findReservationByUserId"></c:import>
					<c:import url="/reservationCheck"></c:import>
				</section>
				<section class="show-in-mypage" id="modify-user-data-container">
					<c:import url="/updateUser"></c:import>
				</section>
				<section class="show-in-mypage" id="leave-user-container">
					<c:import url="/leave"></c:import>
				</section>			
			</c:when>
			<c:otherwise>
				<c:redirect url="/"></c:redirect>
			</c:otherwise>
		</c:choose>	
	</section>
	<script src="/resources/script/validation-mypage.js"></script>
</body>
<c:import url="footer"></c:import>
</html>