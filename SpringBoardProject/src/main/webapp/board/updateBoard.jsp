<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp" %>

<div align="center">
<h3>게시판</h3>
<form action="updateArticle.do" 
			method="post"  enctype="multipart/form-data">
<table border="1" width="500">
	<tr>
		<td>제목</td>
		<td><input type="text" 
			value="${board.subject }" name="subject" size="60"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="hidden" value="${board.member_id }" 
			 name="member_id">${board.member_id }</td>
	</tr>
	<tr>
		<td>파일 업로드</td>
		<td><input type="file" name="uploadFile"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea cols="45" rows="10"
			 name="content">${board.content }</textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글수정">
			<input type="button" onclick="location.href='/myapp/board/getArticleList.do'" value="목록"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>