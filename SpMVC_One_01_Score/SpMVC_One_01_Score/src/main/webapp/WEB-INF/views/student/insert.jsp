<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보 추가</title>
<link href="${rootPath}/static/css/layout_button.css?2021-06-18-002" rel="stylesheet" />
<style>
	* {
		margin: 0;
		padding: 0;
	}
	
	form {
		margin-top: 30px;
	}

	fieldset {
		width: 60%;
		text-align: center;
		margin: 0 auto;
		border-radius: 5px;
	}
	
	fieldset legend {
		padding: 3px;
	}
	
	div label, input {
		padding: 5px;
		margin: 10px auto;
	}
	
	div input {
		border-radius: 5px;
		border-color: lavender;
	}
	
	div.button {
		text-align: right;
		margin-bottom: 5px;
		margin-right: 30%;
	}
	
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<form class="st_insert" method="POST">
		<fieldset>
	        <legend>학생 정보 추가하기</legend>
	        <div>
	            <label>학번</label>
	            <input type="text" value="">
	        </div>
	        <div>
	            <label>이름</label>
	            <input type="text">
	        </div>
	        <div>
	            <label>전공</label>
	            <input type="text">
	        </div>
	        <div>
	            <label>학년</label>
	            <input type="text">
	        </div>
	        <div class="button">
	        	<button type="reset">다시 쓰기</button>
	        	<button id="btn_insert" type="button">추가하기</button>
	        </div>
	    </fieldset>
    </form>
</body>
</html>