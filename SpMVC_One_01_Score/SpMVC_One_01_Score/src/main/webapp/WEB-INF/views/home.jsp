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
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<table>
        <tr>
            <th>학번</th>
            <th>이름</th>
            <th>전공</th>
            <th>학년</th>
            <th>응시 과목</th>
            <th>총점</th>
            <th>평균</th>
        </tr>
        <!-- <c:if test="${empty SC}"></c:if> -->
        <tr>
            <th>학번</th>
            <th>이름</th>
            <th>전공</th>
            <th>학년</th>
            <th>응시 과목</th>
            <th>총점</th>
            <th>평균</th>
        </tr>
    </table>
    
</body>
</html>