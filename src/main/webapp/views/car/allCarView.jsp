<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<body>
	<section id="allCarView">
		<c:set var="sparkExist" value="${false}"></c:set>
		<c:set var="morningExist" value="${false}"></c:set>
		<c:set var="reiExist" value="${false}"></c:set>
		<c:set var="k3Exist" value="${false}"></c:set>
		<c:set var="casperExist" value="${false}"></c:set>
		<c:set var="avanteExist" value="${false}"></c:set>
		<c:set var="carnivalExist" value="${false}"></c:set>
		<c:set var="stariaExist" value="${false}"></c:set>
		<c:set var="k8Exist" value="${false}"></c:set>
		<c:forEach var="car" items="${carList}">
			<c:if test="${car.carName eq '쉐보레 스파크'}"><c:set var="sparkExist" value="${true}"></c:set></c:if>
			<c:if test="${car.carName eq '기아 모닝'}"><c:set var="morningExist" value="${true}"></c:set></c:if>
			<c:if test="${car.carName eq '기아 레이'}"><c:set var="reiExist" value="${true}"></c:set></c:if>
			<c:if test="${car.carName eq '기아 K3'}"><c:set var="k3Exist" value="${true}"></c:set></c:if>
			<c:if test="${car.carName eq '현대 캐스퍼'}"><c:set var="casperExist" value="${true}"></c:set></c:if>
			<c:if test="${car.carName eq '현대 아반떼'}"><c:set var="avanteExist" value="${true}"></c:set></c:if>
			<c:if test="${car.carName eq '기아 카니발'}"><c:set var="carnivalExist" value="${true}"></c:set></c:if>
			<c:if test="${car.carName eq '현대 스타리아'}"><c:set var="stariaExist" value="${true}"></c:set></c:if>
			<c:if test="${car.carName eq '기아 K8'}"><c:set var="k8Exist" value="${true}"></c:set></c:if>
		</c:forEach>
		<div id="cars-container">
			<c:if test="${sparkExist}">
				<div class="cars" id="spark">
					<h4>쉐보레</h4>
					<h3>스파크</h3>
					<img class="logo" src="/resources/image/logo/chevrolet.png" style="height=100px;width:100px;">
					<img class="car-image" src="/resources/image/car/spark.png" style="height=100px;width:100px;">
					<c:forEach var="car" items="${carList}">
						<c:if test="${car.carName eq '쉐보레 스파크'}">
							<div class="car" id="${car.carNumber}">
								<span class="car-age-passengers-number">${car.carAge}년식 ○ ${car.passengersNumber}인승</span>
								<c:set var="isExist" value="${false }"></c:set>
								<c:forEach var="reservation" items="${reservationList }">
									<c:if test="${car.carNumber eq reservation.carNumber }">
										<c:set var="isExist" value="${true }"></c:set>
									</c:if>
								</c:forEach>
								
								<c:if test="${not isExist}">
									<button class="reservate" onclick="location.href='/targetCarFindAction/targetCarNumber?targetCarNumber=${car.carNumber}'">예약하기</button>							
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>		
			</c:if>
			<c:if test="${morningExist}">
				<div class="cars" id="morning">
					<h4>기아</h4>
					<h3>모닝</h3>
					<img class="logo" src="/resources/image/logo/kia.png" style="height=100px;width:100px;"> 
					<img class="car-image" src="/resources/image/car/morning.png" style="height=100px;width:100px;">
					<c:forEach var="car" items="${carList}">
						<c:if test="${car.carName eq '기아 모닝'}">
							<div class="car" id="${car.carNumber}">
								<span class="car-age-passengers-number">${car.carAge}년식 ○ ${car.passengersNumber}인승</span>
								<c:set var="isExist" value="${false }"></c:set>
								<c:forEach var="reservation" items="${reservationList }">
									<c:if test="${car.carNumber eq reservation.carNumber }">
										<c:set var="isExist" value="${true }"></c:set>
									</c:if>
								</c:forEach>
								
								<c:if test="${not isExist}">
									<button class="reservate" onclick="location.href='/targetCarFindAction/targetCarNumber?targetCarNumber=${car.carNumber}'">예약하기</button>													
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${reiExist}">
				<div class="cars" id="rei">
					<h4>기아</h4>
					<h3>레이</h3>
					<img class="logo" src="/resources/image/logo/kia.png" style="height=100px;width:100px;"> 
					<img class="car-image" src="/resources/image/car/rei.png" style="height=100px;width:100px;">
					<c:forEach var="car" items="${carList}">
						<c:if test="${car.carName eq '기아 레이'}">
							<div class="car" id="${car.carNumber}">
								<span class="car-age-passengers-number">${car.carAge}년식 ○ ${car.passengersNumber}인승</span>
								<c:set var="isExist" value="${false }"></c:set>
								<c:forEach var="reservation" items="${reservationList }">
									<c:if test="${car.carNumber eq reservation.carNumber }">
										<c:set var="isExist" value="${true }"></c:set>
									</c:if>
								</c:forEach>
								
								<c:if test="${not isExist}">
									<button class="reservate" onclick="location.href='/targetCarFindAction/targetCarNumber?targetCarNumber=${car.carNumber}'">예약하기</button>							
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${k3Exist}">
				<div class="cars" id="k3">
					<h4>기아</h4>
					<h3>k3</h3>
					<img class="logo" src="/resources/image/logo/kia.png" style="height=100px;width:100px;"> 
					<img class="car-image" src="/resources/image/car/k3.png" style="height=100px;width:100px;">
					<c:forEach var="car" items="${carList}">
						<c:if test="${car.carName eq '기아 K3'}">
							<div class="car" id="${car.carNumber}">
								<span class="car-age-passengers-number">${car.carAge}년식 ○ ${car.passengersNumber}인승</span>
								<c:set var="isExist" value="${false }"></c:set>
								<c:forEach var="reservation" items="${reservationList }">
									<c:if test="${car.carNumber eq reservation.carNumber }">
										<c:set var="isExist" value="${true }"></c:set>
									</c:if>
								</c:forEach>
								
								<c:if test="${not isExist}">
									<button class="reservate" onclick="location.href='/targetCarFindAction/targetCarNumber?targetCarNumber=${car.carNumber}'">예약하기</button>							
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>		
			</c:if>
			<c:if test="${casperExist}">
				<div class="cars" id="casper">
					<h4>현대</h4>
					<h3>캐스퍼</h3>
					<img class="logo" src="/resources/image/logo/hyundai.png" style="height=100px;width:100px;"> 
					<img class="car-image" src="/resources/image/car/casper.png" style="height=100px;width:100px;">
					<c:forEach var="car" items="${carList}">
						<c:if test="${car.carName eq '현대 캐스퍼'}">
							<div class="car" id="${car.carNumber}">
								<span class="car-age-passengers-number">${car.carAge}년식 ○ ${car.passengersNumber}인승</span>
								<c:set var="isExist" value="${false }"></c:set>
								<c:forEach var="reservation" items="${reservationList }">
									<c:if test="${car.carNumber eq reservation.carNumber }">
										<c:set var="isExist" value="${true }"></c:set>
									</c:if>
								</c:forEach>
								
								<c:if test="${not isExist}">
									<button class="reservate" onclick="location.href='/targetCarFindAction/targetCarNumber?targetCarNumber=${car.carNumber}'">예약하기</button>							
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>		
			</c:if>
			<c:if test="${avanteExist}">
				<div class="cars" id="avante">
					<h4>현대</h4>
					<h3>아반떼</h3>
					<img class="logo" src="/resources/image/logo/hyundai.png" style="height=100px;width:100px;"> 
					<img class="car-image" src="/resources/image/car/avante.png" style="height=100px;width:100px;">
					<c:forEach var="car" items="${carList}">
						<c:if test="${car.carName eq '현대 아반떼'}">
							<div class="car" id="${car.carNumber}">
								<span class="car-age-passengers-number">${car.carAge}년식 ○ ${car.passengersNumber}인승</span>
								<c:set var="isExist" value="${false }"></c:set>
								<c:forEach var="reservation" items="${reservationList }">
									<c:if test="${car.carNumber eq reservation.carNumber }">
										<c:set var="isExist" value="${true }"></c:set>
									</c:if>
								</c:forEach>
								
								<c:if test="${not isExist}">
									<button class="reservate" onclick="location.href='/targetCarFindAction/targetCarNumber?targetCarNumber=${car.carNumber}'">예약하기</button>							
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>		
			</c:if>
			<c:if test="${carnivalExist}">
				<div class="cars" id="carnival">
					<h4>기아</h4>
					<h3>카니발</h3>
					<img class="logo" src="/resources/image/logo/kia.png" style="height=100px;width:100px;"> 
					<img class="car-image" src="/resources/image/car/carnival.png" style="height=100px;width:100px;">
					<c:forEach var="car" items="${carList}">
						<c:if test="${car.carName eq '기아 카니발'}">
							<div class="car" id="${car.carNumber}">
								<span class="car-age-passengers-number">${car.carAge}년식 ○ ${car.passengersNumber}인승</span>
								<c:set var="isExist" value="${false }"></c:set>
								<c:forEach var="reservation" items="${reservationList }">
									<c:if test="${car.carNumber eq reservation.carNumber }">
										<c:set var="isExist" value="${true }"></c:set>
									</c:if>
								</c:forEach>
								
								<c:if test="${not isExist}">
									<button class="reservate" onclick="location.href='/targetCarFindAction/targetCarNumber?targetCarNumber=${car.carNumber}'">예약하기</button>							
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>		
			</c:if>
			<c:if test="${stariaExist}">
				<div class="cars" id="staria">
					<h4>현대</h4>
					<h3>스타리아</h3>
					<img class="logo" src="/resources/image/logo/hyundai.png" style="height=100px;width:100px;"> 
					<img class="car-image" src="/resources/image/car/staria.png" style="height=100px;width:100px;">
					<c:forEach var="car" items="${carList}">
						<c:if test="${car.carName eq '현대 스타리아'}">
							<div class="car" id="${car.carNumber}">
								<span class="car-age-passengers-number">${car.carAge}년식 ○ ${car.passengersNumber}인승</span>
								<c:set var="isExist" value="${false }"></c:set>
								<c:forEach var="reservation" items="${reservationList }">
									<c:if test="${car.carNumber eq reservation.carNumber }">
										<c:set var="isExist" value="${true }"></c:set>
									</c:if>
								</c:forEach>
								
								<c:if test="${not isExist}">
									<button class="reservate" onclick="location.href='/targetCarFindAction/targetCarNumber?targetCarNumber=${car.carNumber}'">예약하기</button>							
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>		
			</c:if>
			<c:if test="${k8Exist}">
				<div class="cars" id="k8">
					<h4>기아</h4>
					<h3>k8</h3>
					<img class="logo" src="/resources/image/logo/kia.png" style="height=100px;width:100px;"> 
					<img class="car-image" src="/resources/image/car/k8.png" style="height=100px;width:100px;">
					<c:forEach var="car" items="${carList}">
						<c:if test="${car.carName eq '기아 K8'}">
							<div class="car" id="${car.carNumber}">
								<span class="car-age-passengers-number">${car.carAge}년식 ○ ${car.passengersNumber}인승</span>
								<c:set var="isExist" value="${false }"></c:set>
								<c:forEach var="reservation" items="${reservationList }">
									<c:if test="${car.carNumber eq reservation.carNumber }">
										<c:set var="isExist" value="${true }"></c:set>
									</c:if>
								</c:forEach>
								
								<c:if test="${not isExist}">
									<button class="reservate" onclick="location.href='/targetCarFindAction/targetCarNumber?targetCarNumber=${car.carNumber}'">예약하기</button>							
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>		
			</c:if>
		</div>
		<form action="/findCarByResevTimeAction" id="find-car-by-time">
			<span>대여일</span><input type="date" name="resev-date" id="resev-date" value="${resevDate}"> 
			<span>반납일</span><input type="date" name="return-date" id="return-date" value="${returnDate}"> 
			<span>대여시작시간</span><select name="resev-time" id="resev-time">
				<option disabled>대여시간 선택</option>
				<option value="07:00:00" ${resevTime eq '07:00:00' ? 'selected':''}>07:00</option>
				<option value="08:00:00" ${resevTime eq '08:00:00' ? 'selected':''}>08:00</option>
				<option value="09:00:00" ${resevTime eq '09:00:00' ? 'selected':''}>09:00</option>
				<option value="10:00:00" ${resevTime eq '10:00:00' ? 'selected':''}>10:00</option>
				<option value="11:00:00" ${resevTime eq '11:00:00' ? 'selected':''}>11:00</option>
				<option value="12:00:00" ${resevTime eq '12:00:00' ? 'selected':''}>12:00</option>
				<option value="13:00:00" ${resevTime eq '13:00:00' ? 'selected':''}>13:00</option>
				<option value="14:00:00" ${resevTime eq '14:00:00' ? 'selected':''}>14:00</option>
				<option value="15:00:00" ${resevTime eq '15:00:00' ? 'selected':''}>15:00</option>
				<option value="16:00:00" ${resevTime eq '16:00:00' ? 'selected':''}>16:00</option>
				<option value="17:00:00" ${resevTime eq '17:00:00' ? 'selected':''}>17:00</option>
				<option value="18:00:00" ${resevTime eq '18:00:00' ? 'selected':''}>18:00</option>
				<option value="19:00:00" ${resevTime eq '19:00:00' ? 'selected':''}>19:00</option>
				<option value="20:00:00" ${resevTime eq '20:00:00' ? 'selected':''}>20:00</option>
				<option value="21:00:00" ${resevTime eq '21:00:00' ? 'selected':''}>21:00</option>
				<option value="22:00:00" ${resevTime eq '22:00:00' ? 'selected':''}>22:00</option>
			</select> 
			<span>반납시간</span><select name="return-time" id="return-time">
				<option disabled >반납시간 선택</option>
				<option value="06:00:00" ${returnTime eq '06:00:00' ? 'selected':''}>06:00</option>
				<option value="07:00:00" ${returnTime eq '07:00:00' ? 'selected':''}>07:00</option>
				<option value="08:00:00" ${returnTime eq '08:00:00' ? 'selected':''}>08:00</option>
				<option value="09:00:00" ${returnTime eq '09:00:00' ? 'selected':''}>09:00</option>
				<option value="10:00:00" ${returnTime eq '10:00:00' ? 'selected':''}>10:00</option>
				<option value="11:00:00" ${returnTime eq '11:00:00' ? 'selected':''}>11:00</option>
				<option value="12:00:00" ${returnTime eq '12:00:00' ? 'selected':''}>12:00</option>
				<option value="13:00:00" ${returnTime eq '13:00:00' ? 'selected':''}>13:00</option>
				<option value="14:00:00" ${returnTime eq '14:00:00' ? 'selected':''}>14:00</option>
				<option value="15:00:00" ${returnTime eq '15:00:00' ? 'selected':''}>15:00</option>
				<option value="16:00:00" ${returnTime eq '16:00:00' ? 'selected':''}>16:00</option>
				<option value="17:00:00" ${returnTime eq '17:00:00' ? 'selected':''}>17:00</option>
				<option value="18:00:00" ${returnTime eq '18:00:00' ? 'selected':''}>18:00</option>
				<option value="19:00:00" ${returnTime eq '19:00:00' ? 'selected':''}>19:00</option>
				<option value="20:00:00" ${returnTime eq '20:00:00' ? 'selected':''}>20:00</option>
				<option value="21:00:00" ${returnTime eq '21:00:00' ? 'selected':''}>21:00</option>
			</select> 
			<input type="submit" value="예약정보" id="resev-time-button">
		</form>
		
		<form action="/searchCarAction" id="search-car-option-value">
			<select name="search-option" id="search-option">
				<option value="category" selected>차량크기</option>
				<option value="car-name">브랜드 및 차량명</option>
				<option value="passengers-number">최소승차인원</option>				
			</select>
			<div id="search-value-container">
				<select name="search-value" id="search-value">
				<option selected disabled>차량크기</option>
				<option value="1001">경형/소형</option>
				<option value="1000">중형</option>
				<option value="1002">대형</option>				
			</select>
			</div>
			<input type="submit" value="검색하기">
		</form>
	</section>
	<script src="/resources/script/validation-search-car.js"></script>
</body>
<c:import url="/footer"></c:import>
</html>