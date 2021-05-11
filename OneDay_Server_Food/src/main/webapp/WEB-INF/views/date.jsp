<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>섭취 리스트</h3>
	<table>
		<tr>
			<th>날짜</th>
			<th>식품명</th>
			<th>섭취량</th>
			<th>총내용량</th>
			<th>에너지</th>
			<th>단백질</th>
			<th>지방</th>
			<th>탄수화물</th>
			<th>총당류</th>
		</tr>
		<c:if test="${ empty FOODDTO }">결과가 없음!!</c:if>
		<c:forEach items="${FOODDTO}" var="FD">
			<tr>
				<th>${FD.mf_date}</th>
				<th>${FD.mf_name}</th>
				<th>${FD.mf_intake}</th>
				<th>${FD.mf_total}</th>
				<th>${FD.mf_energy}</th>
				<th>${FD.mf_protein}</th>
				<th>${FD.mf_fat}</th>
				<th>${FD.mf_car}</th>
				<th>${FD.mf_sugar}</th>
			</tr>
		</c:forEach>
	</table>
	<h4><a href="/OneDay_Server_Food">Main으로 돌아가기</a></h4>
</body>
</html>