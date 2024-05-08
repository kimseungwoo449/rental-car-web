<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<body>
	<section id="root">
			<h1>문의사항</h1><br>		
			<p id="index"><span>작성자명</span><span>제목</span></p>
			<c:forEach var="board" items="${boardlist}">
				<c:if test="${board.isNotice ne true}">
					<h4>${board.userId}  <a href="http://localhost:8080/viewTargetBoard/post?post_no=${board.postNumber}">${board.title}</a></h4>
				</c:if>
			</c:forEach>
			
			<form action="">
				<select name="" id="selectOption">
		            <option disabled selected value="none">통합검색</option>
		            <option value="title">제목</option>
		            <option value="publisher">출판사</option>
		            <option value="person">인명</option>
		            <option value="isbn">ISBN</option>
       			</select>
			</form>
			
			<c:if test="${not empty user}">
				<button onClick="location.href='/createBoard'">글쓰기</button>
			</c:if>
	</section>
</body>
<c:import url="/footer"></c:import>
</html>