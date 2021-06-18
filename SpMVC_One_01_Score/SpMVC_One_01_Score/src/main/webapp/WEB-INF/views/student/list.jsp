<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보 List</title>
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
	<h2>학생 정보</h2>
	<div>
		<button id="insert" type="button">학생 정보 추가</button>
		<button id="update" type="button">학생 정보 수정</button>	
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
		document.querySelector("button#insert").addEventListener("click", ()=> {
			alert("정보를 추가하시겠습니까?"); 
			location.href = "${rootPath}/student/insert"
		});
		document.querySelector("button#update").addEventListener("click", ()=> {
			alert("수정하시겠습니까?");
			location.href = "${rootPath}/student/update"
		});
</script>
</html>