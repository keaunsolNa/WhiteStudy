<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
<div align="center">
	<!-- 서블릿 버전 계산기 실행을 위해 계산 버튼 클릭시 서블릿 호출 -->
	<form id="f1" action="Servlet01" method="get">
		<h3> 계산기</h3>
		<hr>
		<input type="text" name="num1" width="200" size="5">
		<input type="text" name="operator" width="200" size="5">
		<%-- 
		<select name="operator">
			<option value="+" selected>　+　</option>
			<option value="-">　-　</option>
			<option value="*">　*　</option>
			<option value="/">　/　</option>
		</select>
		--%>
		<input type="text" name="num2" width="200" size="5">
		<input type="submit" value="계산">
		<input type="reset" value="다시입력">
	</form>
</div>
</body>
</html>