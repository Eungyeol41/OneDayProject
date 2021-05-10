<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>섭취한 음식을 입력하세요.</h5>
	<form method = "POST">
		<table>
			<tr><th>날짜</th><td><input name = "date"></td></tr>
			<tr><th>식품코드</th><td><input name = "code" value="${CODE}"></td></tr>
			<tr><th>섭취량</th><td><input name = "intake"></td></tr>
			<tr><th></th><td><button>입력</button></td></tr>
		</table>
	</form>

</body>
</html>