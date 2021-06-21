<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보 추가</title>
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
	        <legend>학생 정보 수정하기</legend>
	        <div>
	            <label>학번</label>
	            <input type="text" value="${ST.st_num}">
	        </div>
	        <div>
	            <label>이름</label>
	            <input type="text" name="name" value="${ST.st_name}">
	        </div>
	        <div>
	            <label>전공</label>
	            <input type="text" name="dept" value="${ST.st_dept}">
	        </div>
	        <div>
	            <label>학년</label>
	            <input type="number" name="grade" value="${ST.st_grade}">
	        </div>
	        <div>
	            <label>전화번호</label>
	            <input type="tel" name="tel" value="${ST.st_tel}">
	        </div>
	        <div>
	            <label>주소</label>
	            <input type="text" name="addr" value="${ST.st_addr}">
	        </div>
	        <div class="button">
	        	<button type="reset">다시 쓰기</button>
	        	<button id="btn_update" type="button">수정하기</button>
	        </div>
	    </fieldset>
    </form>
</body>
<script>
	document.querySelector("button#btn_update").addEventListener("click", (ev)=> {
		
		let name = document.querySelector("input[name='name']");
		let dept = document.querySelector("input[name='dept']");
		let grade = document.querySelector("input[name='grade']");
		let tel = document.querySelector("input[name='tel']");
		let addr = document.querySelector("input[name='addr']");
		
		if(name.value === "") {
			alert("이름을 꼭 입력해주세요 !!");
			name.focus();
			return false;
		}
		
		if(dept.value === "") {
			alert("전공을 꼭 입력해주세요 !!");
			dept.focus();
			return false;
		}
		
		if(grade.value === "") {
			alert("학년을 꼭 입력해주세요 !!");
			grade.focus();
			return false;
		}
		
		if(tel.value === "") {
			alert("전화번호를 꼭 입력해주세요 !!");
			tel.focus();
			return false;
		}
		
		if(addr.value === "") {
			alert("주소를 꼭 입력해주세요 !!");
			addr.focus();
			return false;
		}
		
		alert("수정" 
				+ name.value + "\n"
				+ dept.value + "\n"
				+ grade.value + "\n"
				+ tel.value + "\n"
				+ addr.value + "\n"
		);
		
		document.querySelector("form.st_insert").submit();
		
	})
</script>
</html>