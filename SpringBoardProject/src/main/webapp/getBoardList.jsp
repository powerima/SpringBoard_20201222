<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
<div align="center">
<div>
	<br><hr width="600">
</div>
<div>
<table width="600">
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
					&state=getBoard">${board.subject }</a>
		<c:if test="${board.commentcnt > 0}">
			&nbsp;[${board.commentcnt }]
		</c:if>			
		</td>
		<td>${board.writer }</td>
		<td>${fn:substring(board.regdate, 0, 10) }</td>
		<td>${board.readcnt }</td>
	</tr>
</c:forEach>
</table>
</div>
<div>
	<table width="600">
		<tr>
			<td align="right">
				<input type="button" value="글 등록" 
					onclick="location.href='insertBoard.jsp'">
				<input type="button" value="전체 목록" 
					onclick="location.href='getArticleList.do'"></td></tr>
	</table>
	<hr width="600">
</div>
<div class="page">
	<c:if test="${recordCnt > 0 }">
		<c:if test="${startPage > pageBlock }" >
			<a href="getArticleList.do?pageNum=${startPage - pageBlock}
				&searchCondition=${searchCondition }&searchKeyword=${searchKeyword }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<c:if test="${pageNum == i }">
				${i }
			</c:if>
			<c:if test="${pageNum != i }">
				[<a href="getArticleList.do?pageNum=${i }
					&searchCondition=${searchCondition }&searchKeyword=${searchKeyword }">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="getArticleList.do?pageNum=${startPage + pageBlock}
				&searchCondition=${searchCondition }&searchKeyword=${searchKeyword }">[다음 10개]</a>
		</c:if>
	</c:if>
</div>

<div>
<form action="getArticleList.do">
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
