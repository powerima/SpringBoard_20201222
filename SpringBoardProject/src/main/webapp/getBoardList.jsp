<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
  
    
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
		<td><a href="getArticle.do?seq=${board.seq}
					&state=getBoard">${board.subject }</a></td>
		<td>${board.writer }</td>
		<td>${fn:substring(board.regdate, 0, 10) }</td>
		<td>${board.readcnt }</td>
	</tr>
</c:forEach>
</table>
</div>

<div class="page">
	<c:set var="name" value="홍길동" />
	<c:set var="currentPage" value="${pageNum }" />
	<c:set var="pageSize" value="10" />
	<c:set var="startRow" value="${(currentPage - 1) * pageSize +1 }" />
	<c:set var="endRow" value="${currentPage * pageSize }" />
	<c:set var="count" value="0" />
	<c:set var="number" value="0" />
	
	
	<c:if test="${count > 0 }">
		<c:set var="pageCount" value="${count / pageSize + (count % pageSize == 0 ? 0 : 1) }" />
		<c:set var="startPage" value="1" />
		<c:if test="${currentPage % 10 != 0 }" >
			<c:set var="startPage" value="${(currentPage/pageSize) * pageSize + 1 }" />
		</c:if>
		<c:if test="${currentPage % 10 == 0 }" >
			<c:set var="startPage" value="${(currentPage/pageSize) -1) * pageSize + 1 }" />
		</c:if>
		
		<c:set var="pageBlock" value="10" />
		<c:set var="endPage" value="${startPage + pageBlock -1 }" />
		
		<c:if test="${endPage > pageCount }" >
			<c:set var="endPage" value="pageCount" />
		</c:if>
		<c:if test="${startPage > pageBlock }" >
			<a href="list3.jsp?pageNum=${startPage - 10}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<a href="getArticleList.do?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="getArticleList.do?pageNum=${startPage + 10}">[다음 10개]</a>
		</c:if>
	</c:if>
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
