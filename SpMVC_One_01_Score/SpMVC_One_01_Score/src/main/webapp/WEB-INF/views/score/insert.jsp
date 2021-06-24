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
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<form class="sc_insert" method="POST">
		<fieldset>
	        <legend>성적 추가하기</legend>
	        <div>
	        	<label>학번</label>
	        	<input type="number" name="num" value="${SC.sc_stnum}">
	        </div>
	        <div>
	            <label>과목명</label>
	            <input type="text" name="subject" value="${SC.sc_subject}">
	        </div>
	        <div>
	            <label>점수</label>
	            <input type="number" name="score" value="${SC.sc_score}">
	        </div>
	        <div class="button">
	        	<button id="sc_insert" type="button">성적 추가하기</button>
	        </div>
	    </fieldset>
    </form>
</body>
<script>
	document.querySelector("button#sc_insert").addEventListener("click", (ev)=> {
		
		let num = document.querySelector("input[name='num']");
		let subject = document.querySelector("input[name='subject']");
		let score= document.querySelector("input[name='score']");
		
		if(num.value === "") {
			alert("학번을 꼭 입력해주세요 !!");
			name.focus();
			return false;
		}
		
		if(subject.value === "") {
			alert("과목명을 입력해주세요 !!");
			subject.focus();
			return false;
		}
		
		if(score.value === "") {
			alert("점수를 꼭 입력해주세요 !!");
			dept.focus();
			return false;
		}
		
		alert("추가" +"\n"
				+ num.value + "\n"
				+ subject.value + "\n"
				+ score.value
		);
		
		document.querySelector("form.sc_insert").submit();
		return false;
		
	})
</script>
</html>