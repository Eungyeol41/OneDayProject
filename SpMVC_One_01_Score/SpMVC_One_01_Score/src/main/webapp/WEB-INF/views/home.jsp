<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<table id="view">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>전공</th>
			<th>학년</th>
			<th>응시 과목</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<c:forEach items="${LISTDTO}" var="LIST">
			<tr data-num="${LIST.v_num}">
				<th>${LIST.v_num}</th>
				<th>${LIST.v_name}</th>
				<th>${LIST.v_dept}</th>
				<th>${LIST.v_grade}</th>
				<th>${LIST.v_subject}</th>
				<th>${LIST.v_total}</th>
				<th>${LIST.v_avg}</th>
			</tr>
		</c:forEach>
	</table>
</body>
<script>
		document.querySelector("table#view").addEventListener("click", (ev)=> {
			
			let tagName = ev.target.tagName;
			console.log(tagName);
			
			if(tagName == "TH") {
				let st_num = ev.target.closest("TR").dataset.num;
				console.log(st_num);
				alert(st_num + "을 확인합니다.");
				
				location.href = "${rootPath}/student/info?st_num=" + st_num;
			}
		});
</script>
</html>