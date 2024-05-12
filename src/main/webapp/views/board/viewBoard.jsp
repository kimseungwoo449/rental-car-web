<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<body>
	<section id="root">
		<h1>문의사항</h1>
		<p id="index">
			<span>작성자명</span><span>제목</span>
		</p>
		<c:forEach var="board" items="${boardlist}">
			<h4>${board.userId}
				<a href="http://localhost:8080/viewTargetBoard/post?post_no=${board.postNumber}">${board.title}</a>
			</h4>
		</c:forEach>
		<c:forEach var="i" begin="1" end="${pages}">
			<button onclick="location.href='/allBoardAction/pageCount?pageCount=${i}'">${i}</button>
		</c:forEach>

		<form method="POST" action="/searchBoardAction" id="search-board">
			<select name="search-option" id="search-Option">
				<option selected value="title">통합검색</option>
				<option value="title">제목</option>
				<option value="userId">작성자</option>
				<option value="isCommented">운영자 답변여부</option>
			</select> <input type="text" name="search-value" id="search-value" placeholder="검색할 내용"> <input type="submit" value="검색하기">
		</form>

		<c:if test="${not empty user}">
			<button onClick="location.href='/createBoard'">글쓰기</button>
		</c:if>
	</section>
</body>
<c:import url="/footer"></c:import>
</html>