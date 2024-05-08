<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<body>
	<c:if test="${empty sessionScope.targetBoard} ">
		<c:redirect url="/board"></c:redirect>
	</c:if>
	<section id="root">
		<h1>문의사항</h1>
		<div id="text-header">
			<h4>작성일 : ${targetBoard.postDate}		수정일 : ${targetBoard.modDate}</h4>
			<h2>제목 : ${targetBoard.title} 작성자 : ${targetBoard.userId}</h2>
			<h3>내용 : ${targetBoard.contents}</h3>
			
			<c:if test="${targetBoard.userId eq user.id || user.id eq 'admin'}">
				<button onClick="location.href='/deleteBoardAction'">삭제</button>
				<button onClick="location.href='/updateBoard'">수정</button>
			</c:if>	
			
			<c:if test="${targetBoard.adminComment ne null}">
				<h5>운영자 코멘트 : ${targetBoard.adminComment}</h5>			
			</c:if>	
			<c:if test="${user.id eq 'admin'}">
				<form action="/adminCommentAction" method="POST">
					<input type="text" name="admin-comment" id="admin-comment" placeholder="답변내용">
					<input type="submit" value="답변하기">
				</form>
			</c:if>
		</div>
	</section>
</body>
<c:import url="footer"></c:import>
</html>