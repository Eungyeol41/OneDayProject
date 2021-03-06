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
	<h1>다 이 어 트 하 자</h1>
	<table>
		<tr>
			<th><form action="inform/selectName"><button>식품명으로 조회하기</button></form></th>
			<th><form action="inform/insert"><button>섭취정보 등록</button></form></th>
		</tr>
	</table>
	
	<h2>섭취 LIST</h2>
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
		<c:if test="${ empty FOODLIST }">결과가 없음!!</c:if>
		<c:forEach items="${FOODLIST}" var="MF">
			<tr>
				<th>${MF.mf_date}</th>
				<th>${MF.mf_name}</th>
				<th>${MF.mf_intake}</th>
				<th>${MF.mf_total}</th>
				<th>${MF.mf_energy}</th>
				<th>${MF.mf_protein}</th>
				<th>${MF.mf_fat}</th>
				<th>${MF.mf_car}</th>
				<th>${MF.mf_sugar}</th>
			</tr>
		</c:forEach>
	</table>
	<p>======================================================================</p>
	<h2>날짜를 입력하세요</h2>
	<form action="inform/date">
		날짜 
		<input type="date" name="date">
		<button>조회</button>
	</form>
	
	
</body>
</html>