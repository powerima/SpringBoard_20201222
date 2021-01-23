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
<link rel="stylesheet" href="/myapp/css/style.css" />
</head>
<body>
<nav>
	<a href="/myapp/index.jsp">메인 화면</a>&emsp;&emsp;	
	<a href="/myapp/system/join.do">회원 등록</a>&emsp;&emsp;	
	<c:if test="${sessionScope.member.id == null }"><a href="/myapp/system/login.do">회원 로그인</a></c:if>
	
	<c:if test="${sessionScope.member.id != null }">
		<a href="/myapp/board/getArticleList.do">게시판</a>&emsp;&emsp;</c:if>
	<c:if test="${sessionScope.member.id != null }">
		<a href="/myapp/member/getMember.do">회원 정보</a>&emsp;&emsp;</c:if>	
	<c:if test="${sessionScope.member.role == 'ROLE_ADMIN' }">
		<a href="/myapp/member/getMemberList.do">회원 목록</a>&emsp;&emsp;</c:if>
	<c:if test="${sessionScope.member.id != null }">
		<a href="/myapp/system/logout.do">로그아웃</a></c:if>
</nav>
