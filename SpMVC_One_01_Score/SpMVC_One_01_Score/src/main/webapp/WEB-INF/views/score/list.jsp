<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생별 성적 정보 List</title>
<link href="${rootPath}/static/css/home.css?2021-06-18-002" rel="stylesheet" />
<link href="${rootPath}/static/css/layout_button.css?2021-06-18-001" rel="stylesheet" />
<style>
	h2 {
		text-align: center;	
	}
	div {
		text-align: right;
		margin: 10px auto;
	}

</style>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h2>학생 별 성적 정보</h2>
	<table>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>전공</th>
			<th>학년</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<c:forEach items="${ST}" var="ST" varStatus="index">
			<tr>
				<th>${ST.st_num}</th>
				<th>${ST.st_name}</th>
				<th>${ST.st_dept}</th>
				<th>${ST.st_grade}</th>
				<th>${ST.st_tel}</th>
				<th>${ST.st_addr}</th>
			</tr>
		</c:forEach>
	</table>
	<div>
		<button id="sc_insert" type="button">성적 정보 추가</button>
		<button id="sc_update" type="button">성적 정보 수정</button>	
	</div>
	<table>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>전공</th>
			<th>학년</th>
		</tr>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>전공</th>
			<th>학년</th>
		</tr>
	</table>


</body>
<script>
		document.querySelector("button#sc_insert").addEventListener("click", ()=> {
			alert("정보를 추가하시겠습니까?"); 
			location.href = "${rootPath}/score/insert";
		});
		document.querySelector("button#sc_update").addEventListener("click", ()=> {
			alert("수정하시겠습니까?");
			location.href = "${rootPath}/score/update";
		});
</script>
</html>