<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<div align="center">
<h3>Spring 게시판 프로그램</h3>
<hr width="80%">
	<a href="join.do">회원 등록</a><br><br>	
	<c:if test="${sessionScope.member.id == null }"><a href="login.do">회원 로그인</a></c:if>
	
	<c:if test="${sessionScope.member.id != null }">
		<a href="getArticleList.do">게시판</a><br><br></c:if>
	<c:if test="${sessionScope.member.id != null }">
		<a href="getMember.do">회원 정보</a><br><br></c:if>	
	<c:if test="${sessionScope.member.role == 'ROLE_ADMIN' }">
		<a href="getMemberList.do">회원 목록</a><br><br></c:if>
	<c:if test="${sessionScope.member.id != null }">
		<a href="logout.do">로그아웃</a></c:if>
<br><br>
<br><br><br><br>Eclipse EE, Spring 4.2.4, JDK 11.0.9, MyBatis, ojdbc, fileUpload, Oracle 11g EX 
<br><br> https://github.com/powerima/SpringBoard_20201222.git
</div>
</body>
</html>