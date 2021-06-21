<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보 List</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<style>
h2 {
	text-align: center;
	margin: 10px auto;
	margin-top: 40px;
}

div {
	text-align: right;
	margin: 10px auto;
}

button {
	
}
</style>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h2>학생 정보</h2>
	<table>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>전공</th>
			<th>학년</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<c:forEach items="${STLIST}" var="ST">
			<tr data-num="${ST.st_num}">
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
		<button id="st_insert" type="button">학생 정보 추가</button>
	</div>
</body>
<script>
		document.querySelector("button#st_insert").addEventListener("click", ()=> {
			alert("정보를 추가하시겠습니까?"); 
			location.href = "${rootPath}/student/insert";
		});
		
		document.querySelector("table").addEventListener("click", (ev)=> {
			
			let tagName = ev.target.tagName;
			console.log(tagName);
			
			if(tagName == "TH") {
				let st_num = ev.target.closest("TR").dataset.num;
				console.log(st_num);
				alert(st_num + "을 확인합니다.");
				
				location.href = "${rootPath}/student/Info?st_num=" + st_num;
			}
		});
</script>
</html>