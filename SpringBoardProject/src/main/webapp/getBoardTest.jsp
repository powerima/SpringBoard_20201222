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
<div class ="articleContent">
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

<div class ="commentList">

	<div class="commentContent">
		<table width="450">
			<tr><td colspan="3" align="right">
				12.25 12:02:23<hr></td></tr>
			<tr><td width="70">123</td>
				<td>안녕하세요</td>
				<td width="45">[삭제]</td></tr>				
			<tr><td colspan="3" align="right"><hr></td></tr>
		</table><br>
	</div>
	
	<div class="commentContent">
		<table width="450">
			<tr><td colspan="3" align="right">
				12.25 12:02:23<hr></td></tr>
			<tr><td width="70">123</td>
				<td>안녕하세요</td>
				<td width="45">[삭제]</td></tr>				
			<tr><td colspan="3" align="right"><hr></td></tr>
		</table><br>
	</div>
	
	<div class="commentContent">
		<table width="450">
			<tr><td colspan="3" align="right">
				12.25 12:02:23<hr></td></tr>
			<tr><td width="70">123</td>
				<td>안녕하세요</td>
				<td width="45">[삭제]</td></tr>				
			<tr><td colspan="3" align="right"><hr></td></tr>
		</table><br>
	</div>
	

	
	<c:forEach items="${commentList }" var="comment">
	<div class="commentContent">
		<table width="450">
			<tr><td colspan="3" align="right">
				${comment.regdate }<hr></td></tr>
			<tr><td width="70">${comment.writer }</td>
				<td>${comment.contenet }</td>
				<td width="45">[삭제]</td></tr>				
			<tr><td colspan="3" align="right"><hr></td></tr>
		</table><br>
	</div>
	</c:forEach>
</div>

<div class="insertComment">
	<table border="1" width="450">
		<tr>
			<td width="100">작성자</td>
			<td><input type="text" name="writer" size="10"></td>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" size="8"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3"><textarea cols="45" rows="5" 
				name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="댓글 등록">
			</td>
		</tr>
	</table>
	<br>		
</div>
<div>
	<table width="450">
		<tr><td align="right">
			<input type="button" value="글 등록"
				onclick="location.href='insertBoard.jsp'">
			<input type="button" value="목록"
				onclick="location.href='getArticleList.do'">
		</td></tr>
	</table>	
</div>


<br><br><br>
</div>
</body>
</html>