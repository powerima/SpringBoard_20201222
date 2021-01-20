<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="script.js"></script>
<link rel="stylesheet" href="style.css" />
</head>
<body>
<nav>
	<a href="join.jsp">회원 등록</a>&emsp;&emsp;	
	<c:if test="${sessionScope.member.id == null }"><a href="login.do">회원 로그인</a></c:if>
	
	<c:if test="${sessionScope.member.id != null }">
		<a href="getArticleList.do">게시판</a>&emsp;&emsp;</c:if>
	<c:if test="${sessionScope.member.id != null }">
		<a href="getMember.do">회원 정보</a>&emsp;&emsp;</c:if>	
	<c:if test="${sessionScope.member.role == 'ROLE_ADMIN' }">
		<a href="getMemberList.do">회원 목록</a>&emsp;&emsp;</c:if>
	<c:if test="${sessionScope.member.id != null }">
		<a href="logout.do">로그아웃</a></c:if>
</nav>
