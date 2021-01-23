<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ include file="../top.jsp" %>

<div align="center">
<h3>게시판</h3>
<div class ="articleContent">
<table border="1" width="500">
	<tr>
		<td width="70" align="center">제목</td>
		<td>${board.subject }</td>
	</tr>
	<tr>
		<td align="center">조회수</td>
		<td>${board.readcnt }</td>
	</tr>
	<tr>
		<td align="center">작성자</td>
		<td>${board.member_id }</td>
	</tr>
	<tr>
		<td align="center">내용</td>
		<td><br>
			<img src="../files/${board.filename }" width="300"><br><br>
			${board.content }
		<br><br><br><br><br><br><br><br></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			[<a href="/myapp/board/getArticle.do?seq=${board.seq }">글 수정</a>]
			[<a href="/myapp/board/deleteBoard.do?ref=${board.ref }">삭제</a>]
			[<a href="/myapp/board/getArticleList.do">목록</a>]</td>
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
			<td><input type="hidden" id="ref" value="${board.ref }">
				<input type="hidden" id="member_id" size="10"
					value="${member.id }">${member.id }</td>
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
<script>
$(document).ready(function(){
	$(".commentList").load("/myapp/board/getCommentList.do?ref=${board.ref}");
	
	
	$("#insertComment").click(function(){
		var query = {
			member_id: $("#member_id").val(),
			content: $("#content").val(),
			ref: $("#ref").val()
		};
		
		$.ajax({
			type: "GET",
			url: "/myapp/board/insertComment.do",
			data: query,
			success: function(data) {
				$(".commentList").load("/myapp/board/getCommentList.do");
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
</html>