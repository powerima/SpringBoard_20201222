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
<form action="insertArticle.do" method="post">
<table border="1">
	<tr>
		<td>제목</td>
		<td><input type="text" name="subject"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea cols="40" rows="10" name="content"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글등록">
			<input type="button" value="목록"
				onclick="location.href='getBoardList.jsp'"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>