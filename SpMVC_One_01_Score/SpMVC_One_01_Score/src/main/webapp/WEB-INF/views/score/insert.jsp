<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생별 성적 정보 추가</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
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
		margin: 10px auto;
		border-radius: 5px;
		margin-bottom: 10px;
	}
	
	fieldset legend {
		padding: 3px;
	}
	
	div label, input {
		padding: 5px;
		margin: 10px auto;
	}
	
	div label {
		text-align: right;
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
	        <legend>성적 추가하기</legend>
	        <div>
	            <label>과목명</label>
	            <input type="text" name="subject" value="${SC.sc_subject}">
	        </div>
	        <div>
	            <label>점수</label>
	            <input type="number" name="score" value="${SC.sc_score}">
	        </div>
	        <div>
	        	<button id="sc_insert" type="button">성적 추가하기</button>
	        </div>
	    </fieldset>
    </form>
</body>
<script>
	document.querySelector("button#btn_insert").addEventListener("click", (ev)=> {
		
		let name = document.querySelector("input[name='name']");
		let dept = document.querySelector("input[name='dept']");
		let grade = document.querySelector("input[name='grade']");
		let tel = document.querySelector("input[name='tel']");
		let addr = document.querySelector("input[name='addr']");
		
		if(subject.value === "") {
			alert("과목명을 꼭 입력해주세요 !!");
			name.focus();
			return false;
		}
		
		if(score.value === "") {
			alert("점수를 꼭 입력해주세요 !!");
			dept.focus();
			return false;
		}
		
		alert("추가" +"\n"
				+ subject.value + "\n"
				+ score.value
		);
		
		document.querySelector("form.sc_insert").submit();
		return false;
		
	})
</script>
</html>