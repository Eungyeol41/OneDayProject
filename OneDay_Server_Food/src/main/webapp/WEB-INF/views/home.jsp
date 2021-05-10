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
	
	<h3>섭취 목록</h3>
	<c:if test="${empty TOTALLIST}">결과가 없음!!</c:if>
	<table>
		<tr>
			<th><th><th><th>날짜</th>
			<th><th><th><th>식품명</th>
			<th><th><th><th>섭취량</th>
			<th><th><th><th>총내용량</th>
			<th><th><th><th>에너지</th>
			<th><th><th><th>단백질</th>
			<th><th><th><th>지방</th>
			<th><th><th><th>탄수화물</th>
			<th><th><th><th>총당류</th>
		</tr>
		<c:forEach items="${TOTALLIST}" var="MF">
			<th><th><th><th>${MF.mf_date}</th>
			<th><th><th><th>${MF.fd_fname}</th>
			<th><th><th><th>${MF.mf_intake}</th>
			<th><th><th><th>${MF.fd_total}</th>
			<th><th><th><th>${MF.fd_energy}</th>
			<th><th><th><th>${MF.fd_protein}</th>
			<th><th><th><th>${MF.fd_fat}</th>
			<th><th><th><th>${MF.fd_car}</th>
			<th><th><th><th>${MF.fd_sugar}</th>
		</c:forEach>
	</table>
	
	<h4><a href="inform/insert">섭취정보 등록</a></h4>
	
	<h4>날짜를 입력하세요</h4>
	<form action="inform/date">
		날짜 
		<input name="date">
		<button>조회</button>
	</form>
</body>
</html>