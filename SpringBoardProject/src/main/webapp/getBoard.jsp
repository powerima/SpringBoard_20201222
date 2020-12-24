<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<table border="1">
	<tr>
		<td>제목</td>
		<td>${board.subject }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${board.writer }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${board.content }</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="button" value="글수정">
			<input type="button" value="삭제">
			</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>비밀번호</td> 
	</tr>
	<tr>
		<td><input type="text" name="writer"></td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>	
		<td colspan="2">
			<textarea name="content" cols="40" rows="3"></textarea>
		</td>
	</tr>
</table>
</div>
</body>
</html>