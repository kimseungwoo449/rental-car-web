<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<body>
	<section id="board-list">
		<h1>공지사항</h1>
		<p id="index">
			<span>제목</span>
		</p>
		<c:forEach var="board" items="${boardlist}">
			<p class="contents">
				<a href="http://localhost:8080/viewTargetBoard/post?post_no=${board.postNumber}">${board.title}</a>
			</p>
		</c:forEach>
		
		<div id="buttons">
		<c:forEach var="i" begin="1" end="${pages}">
			<button onclick="location.href='/allNoticeAction/pageCount?pageCount=${i}'">${i}</button>
		</c:forEach>
		<c:if test="${user.id eq 'admin'}">
			<button onClick="location.href='/createBoard'">글쓰기</button>
		</c:if>
		</div>

		<form method="POST" action="/searchBoardAction" id="search-board">
			<input type="text" name="search-value" id="search-value" placeholder="공지사항 제목검색"> <input type="submit" value="검색하기">
		</form>

	</section>
</body>
<c:import url="/footer"></c:import>
</html>