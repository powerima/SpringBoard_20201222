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
<table border="1" width="600">
	<tr>
		<td align="right">
			<input type="button" value="글 등록" 
				onclick="location.href='insertBoard.jsp'"></td>
	</tr>
</table>
<table border="1" width="600">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>				
	</tr>
<c:forEach items="${boardList }" var="board">
	<tr>
		<td>${board.seq }</td>
		<td>${board.subject }</td>
		<td>${board.writer }</td>
		<td>${board.regdate }</td>
		<td>${board.readcnt }</td>
	</tr>
</c:forEach>
</table>
</div>
<div>
<form action="getBoardList.do">
<select name="searchCondition">
	<option value="subject">제목</option>
	<option value="writer">작성자</option>
</select>
<input type="text" name="searchKeyword" />
<input type="submit" value="검색" />
</form>
</div>
</div>
</body>
</html>
