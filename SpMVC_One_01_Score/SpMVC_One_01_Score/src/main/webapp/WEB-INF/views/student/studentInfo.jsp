<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생별 정보</title>
<link href="${rootPath}/static/css/home.css?ver=2021-06-18-002" rel="stylesheet" />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<table>
	<c:forEach items="${ST}" var="ST">
			<tr>
				<th>학번</th>
				<th>${ST.st_num}</th>
				<th>이름</th>
				<th>${ST.st_name}</th>
			</tr>
			<tr>
				<th>전공</th>
				<th>${ST.st_dept}</th>
				<th>학년</th>
				<th>${ST.st_grade}</th>
			</tr>
		</c:forEach>
	</table>
	<div>
		<button class="btn_st_update">학생 정보 수정</button>
		<button class="btn_st_delete">학생 정보 삭제</button>
	</div>
	
	<table>
		<tr>
			<th>NO.</th>
			<th>과목명</th>
			<th>점수</th>
		</tr>
		<c:forEach items="${SC}" var="SC" varStatus="index">
			<tr data-seq="${SC.sc_seq}">
				<th>${index.count}</th>
				<th>${SC.sc_subject}</th>
				<th>${SC.sc_score}</th>
			</tr>
		</c:forEach>
		<tr>
			<th>총점</th>
			<th>${응시과목}</th>
			<th>${총점}</th>
		</tr>
	</table>
	
	<div>
		<button class="btn_sc_insert">성적 추가</button>
	</div>
</body>
<script>
	document.querySelector("button").addEventListener("click", (ev)=> {
		let className = ev.target.className;
		
		if(className === "btn_st_update") {
			location.href="${rootPath}/WEB-INF/views/student/update.jsp";
		} else if(className === "btn_st_delete") {
			
		} else if(className === "btn_sc_insert") {
			
		}
		
	})
</script>
</html>