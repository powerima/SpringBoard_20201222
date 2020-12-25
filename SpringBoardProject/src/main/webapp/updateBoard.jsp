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
<form action="updateArticle.do" method="post">
<table border="1" width="500">
	<tr>
		<td width="70">제목</td>
		<td><input type="text" 
			value="${board.subject }" name="subject"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text"
			value="${board.writer }"  name="writer"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea cols="45" rows="10"
			 name="content">${board.content }</textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" onclick="location.href='updateArticle.do'" value="글수정">
			<input type="submit" onclick="location.href='getArticleList.do'" value="목록"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>