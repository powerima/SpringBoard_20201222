<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(document).ready(function(){
	$(".commentList").load("getCommentList.do?ref=${board.ref}");
	
	
	$("#insertComment").click(function(){
		var query = {
			writer: $("#writer").val(),
			content: $("#content").val(),
			passwd: $("#passwd").val(),
			ref: $("#ref").val()
		};
		
		$.ajax({
			type: "GET",
			url: "/myapp/insertComment.do",
			data: query,
			success: function(data) {
				$(".commentList").load("getCommentList.do");
				document.location.reload();
			}
		});	
	});
	
	$("#deleteComment").click(function(){
		alert("deleteComment");
		/*
		var query = {
			seq: $("seq").val()
		};
		
		$.ajax({
			type: "GET",
			url: "/myapp/deleteComment.do",
			data: query,
			success: function(data) {
				$(".commentList").load("getCommentList.do");
				document.location.reload();
			}
		});
		*/
	});
	
	
});
</script>
<link rel="stylesheet" href="style.css" />
</head>
<body>
<div align="center">
<div class ="articleContent">
<table border="1" width="500">
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
		<td><br>
			<img src="files/${board.filename }" width="300"><br><br>
			${board.content }
		<br><br><br><br><br><br><br><br></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<a href="getArticle.do?seq=${board.seq }&state=updateBoard">[글 수정]</a>
			<a href="deleteBoard.do?ref=${board.ref }">[삭제]</a>
			<a href="getArticleList.do">[목록]</a></td>
	</tr>
</table>
<br><br>
</div>

<div class ="commentList">

</div>

<div class="insertComment">
	<table border="1" width="500">
		<tr>
			<td width="100">작성자</td>
			<td><input type="text" id="writer" size="10"></td>
			<td>비밀번호</td>
			<td><input type="password" id="passwd" size="8">
				<input type="hidden" id="ref" value="${board.ref }"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3"><textarea cols="45" rows="5" 
				id="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" id="insertComment" value="댓글 등록">
			</td>
		</tr>
	</table>
	<br>		
</div>
<div>
	<table width="500">
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