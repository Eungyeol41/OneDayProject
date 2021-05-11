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
	<h2>식품명으로 검색한 결과</h2>
	<table>
		<tr>
			<th> 식품코드 </th>
			<th>식품명 </th>
			<th>출시연도 </th>
			<th>제조사명 </th>
			<th>분류명 </th>
			<th>1회제공량 </th>
			<th>총내용량 </th>
			<th>칼로리 </th>
			<th>단백질 </th>
			<th>지방 </th>
			<th>탄수화물 </th>
			<th>총당류 </th>
		</tr>
		<c:if test="${empty TLIST}">결과가 없음!!</c:if>
		<c:forEach items="${TLIST}" var="TOTAL">
			<tr>
				<th>${TOTAL.fd_fcode}</th>
				<th><a href="?fd_fname=${TOTAL.fd_fname}">${TOTAL.fd_fname}</a></th>
				<th>${TOTAL.fd_year}</th>
				<th>${TOTAL.cp_com}</th>
				<th>${TOTAL.it_name}</th>
				<th>${TOTAL.fd_one}</th>
				<th>${TOTAL.fd_total}</th>
				<th>${TOTAL.fd_energy}</th>
				<th>${TOTAL.fd_protein}</th>
				<th>${TOTAL.fd_fat}</th>
				<th>${TOTAL.fd_car}</th>
				<th>${TOTAL.fd_sugar}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>