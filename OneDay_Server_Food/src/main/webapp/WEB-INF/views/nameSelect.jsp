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
	<h4>식품명으로 검색한 결과</h4>
	<table>
		<tr>
			<th>식품코드</th>
			<th>식품명</th>
			<th>출시연도</th>
			<th>제조사코드</th>
			<th>제조사명</th>
			<th>분류코드</th>
			<th>분류명</th>
			<th>일회제공량</th>
			<th>총내용량</th>
			<th>칼로리</th>
			<th>단백질</th>
			<th>지방</th>
			<th>탄수화물</th>
			<th>총당류</th>
		</tr>
		<c:if test="${empty TLIST}">결과가 없음!!</c:if>
		<c:forEach items="${TLIST}" var="TOTAL">
			<tr>
				<th><a href="inser?code=${TOTAL.code}">${TOTAL.code}
				${FL.name}</a></th>
				<th>${FL.year}</th>
				<th>${FL.ccode}</th>
				<th>${FL.cname}</th>
				<th>${FL.icode}</th>
				<th>${FL.iname}</th>
				<th>${FL.offer}</th>
				<th>${FL.total}</th>
				<th>${FL.kcal}</th>
				<th>${FL.protein}</th>
				<th>${FL.fat}</th>
				<th>${FL.car}</th>
				<th>${FL.sugar}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>