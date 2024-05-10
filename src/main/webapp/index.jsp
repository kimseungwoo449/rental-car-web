<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:import url="/header"></c:import>
<body>
	<c:choose>
		<c:when test="${not empty carList }">
			<c:import url="/allCarView"></c:import>		
		</c:when>
		<c:otherwise>
			<c:redirect url="/viewCarAction"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
<c:import url="/footer"></c:import>
</html>