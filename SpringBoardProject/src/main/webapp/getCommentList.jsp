<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
<c:forEach items="${commentList }" var="comment">
<div class="commentContent">
	<table width="500">
		<tr><td colspan="3" align="right">
			${comment.regdate }
			<input type="hidden" name="seq" value="${comment.seq }"></td></tr>
		<tr><td width="70">${comment.writer }</td>
			<td>&emsp;${comment.content }</td>
			<td width="45"><input type="button"	value="삭제" 
				onclick="location.href='deleteComment.do?seq=${comment.seq}&ref=${comment.ref }'"></td></tr>		
	</table><br>
</div>
</c:forEach>
</body>
</html>