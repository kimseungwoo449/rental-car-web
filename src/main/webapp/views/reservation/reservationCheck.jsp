<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<body>
	<c:choose>
		<c:when test="${empty myReservationList}">
			<c:redirect url="/findReservationByUserId"></c:redirect>
		</c:when>
		<c:otherwise>
			<c:forEach var="reservation" items="${myReservationList }">
				<div class="myReservation" id="resevNumber${reservation.resevNumber}">
					<p>${reservation.carName }</p>
					<c:choose>
						<c:when test="${fn:contains(reservation.carName,'기아')}">
							<img class="logo" src="/resources/image/logo/kia.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'현대')}">
							<img class="logo" src="/resources/image/logo/hyundai.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'쉐보레')}">
							<img class="logo" src="/resources/image/logo/chevrolet.png" style="width: 100px;">
						</c:when>
					</c:choose>

					<c:choose>
						<c:when test="${fn:contains(reservation.carName,'스파크')}">
							<img class="car-image" src="/resources/image/car/spark.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'모닝')}">
							<img class="car-image" src="/resources/image/car/morning.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'레이')}">
							<img class="car-image" src="/resources/image/car/rei.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'K3')}">
							<img class="car-image" src="/resources/image/car/k3.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'캐스퍼')}">
							<img class="car-image" src="/resources/image/car/casper.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'아반떼')}">
							<img class="car-image" src="/resources/image/car/avante.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'카니발')}">
							<img class="car-image" src="/resources/image/car/carnival.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'스타리아')}">
							<img class="car-image" src="/resources/image/car/staria.png" style="width: 100px;">
						</c:when>
						<c:when test="${fn:contains(reservation.carName,'K8')}">
							<img class="car-image" src="/resources/image/car/k8.png" style="width: 100px;">
						</c:when>
					</c:choose>
					
					<p class="resev-date">${reservation.resevDate} ~ ${reservation.returnDate} 까지</p>
					
					<button>수정</button>
					<button>삭제</button>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>

</body>
</html>