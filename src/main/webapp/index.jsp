<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<body>
	
	<section id="root">	
		<form action="/searchFirstCarAction" id="search-car">
			<span>대여일</span><input type="date" name="resev-date" id="resev-date"> 
			<span>반납일</span><input type="date" name="return-date" id="return-date"> 
			<select name="resev-time" id="resev-time">
				<option disabled>대여시간 선택</option>
				<option value="07:00:00">07:00</option>
				<option value="08:00:00" selected>08:00</option>
				<option value="09:00:00">09:00</option>
				<option value="10:00:00">10:00</option>
				<option value="11:00:00">11:00</option>
				<option value="12:00:00">12:00</option>
				<option value="13:00:00">13:00</option>
				<option value="14:00:00">14:00</option>
				<option value="15:00:00">15:00</option>
				<option value="16:00:00">16:00</option>
				<option value="17:00:00">17:00</option>
				<option value="18:00:00">18:00</option>
				<option value="19:00:00">19:00</option>
				<option value="20:00:00">20:00</option>
				<option value="21:00:00">21:00</option>
				<option value="22:00:00">22:00</option>
			</select> 
			<select name="return-time" id="return-time">
				<option disabled selected>반납시간 선택</option>
				<option value="06:00:00">06:00</option>
				<option value="07:00:00">07:00</option>
				<option value="08:00:00">08:00</option>
				<option value="09:00:00">09:00</option>
				<option value="10:00:00">10:00</option>
				<option value="11:00:00">11:00</option>
				<option value="12:00:00">12:00</option>
				<option value="13:00:00">13:00</option>
				<option value="14:00:00">14:00</option>
				<option value="15:00:00">15:00</option>
				<option value="16:00:00">16:00</option>
				<option value="17:00:00">17:00</option>
				<option value="18:00:00" selected>18:00</option>
				<option value="19:00:00">19:00</option>
				<option value="20:00:00">20:00</option>
				<option value="21:00:00">21:00</option>
			</select> 
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
	<script src="/resources/script/validation-set-date.js"></script>
	<script src="/resources/script/validation-search-car.js"></script>
</body>
<c:import url="/footer"></c:import>
</html>