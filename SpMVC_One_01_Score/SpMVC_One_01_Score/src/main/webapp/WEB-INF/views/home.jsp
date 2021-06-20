<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link href="${rootPath}/static/css/home.css?ver=2021-06-18-002" rel="stylesheet" />
<script>
	document.querySelector("DOMContentLoaded", ()=> {
		document.querySelector("table.view").addEventListener("click", (ev)=> {
			
			let tagName = ev.target.tagName;
			if(tagName == "TD") {
				let tr = ev.target.closet("TR").dataset
				let st_num = tr.num;
				
				location.href = "${rootPath}/student/Info?st_num=" + st_num;
			}
			
		})
	})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<table class="view">
        <tr>
            <th>학번</th>
            <th>이름</th>
            <th>전공</th>
            <th>학년</th>
            <th>응시 과목</th>
            <th>총점</th>
            <th>평균</th>
        </tr>
        <c:forEach items="${LIST}" var="LIST">
	        <tr data-num="${LIST.학번}">
	            <th>${LIST.학번}</th>
	            <th>${LIST.이름}</th>
	            <th>${LIST.전공}</th>
	            <th>${LIST.학년}</th>
	            <th>${LIST.응시과목}</th>
	            <th>${LIST.총점}</th>
	            <th>${LIST.평균}</th>
	        </tr>
        </c:forEach>
    </table>
</body>
</html>