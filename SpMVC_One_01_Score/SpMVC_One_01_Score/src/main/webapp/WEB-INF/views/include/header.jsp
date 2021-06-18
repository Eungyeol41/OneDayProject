<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	
	header {
		width: 100%;
		background-color: lightsteelblue;
		text-align: center;
		color: white;
		text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5);
	}
	header h1.title {
		padding: 20px;
	}
	
	nav ul {
		display: flex;
		background-color: ivory;
	}
	
	li {
		list-style: none;
		padding: 10px 12px;
	}
	li:first-child {
		margin-left: 20px;
	}
	
	li:nth-child(3) {
		margin-right: auto;
	}
	
	li:hover {
		cursor: pointer;
		background-color: gainsboro;
	}
</style>
<script>
	var rootPath = "${rootPath}";
</script>
<script src="${rootPath}/static/js/nav.js"></script>
</head>
<body>
	<header><h1 class="title">대한 고교 성적처리 2021 V1</h1></header>
	<nav>
		<ul>
			<li>HOME</li>
			<li>학생 정보</li>
			<li>성적일람표</li>
			<li>로그인</li>
		</ul>
	</nav>
</body>
</html>