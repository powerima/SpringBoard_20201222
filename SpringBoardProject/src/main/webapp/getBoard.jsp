<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<div>
<table border="1" width="450">
	<tr>
		<td width="70">제목</td>
		<td>${board.subject }</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${board.readcnt }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${board.writer }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${board.content }
		<br><br><br><br><br><br><br><br></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<a href="getArticle.do?seq=${board.seq }&state=updateBoard">[글 수정]</a>
			<a href="deleteBoard.do?seq=${board.seq }">[삭제]</a>
			<a href="getArticleList.do">[목록]</a></td>
	</tr>
</table>
<br><br>
</div>

</div>
</body>
</html>