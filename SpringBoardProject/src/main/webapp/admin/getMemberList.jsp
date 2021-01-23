<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ include file="../top.jsp" %>
<div align="center">
<h3>회원 목록</h3>
<hr width="80%">
<table border="1" width="600">
	<tr align="center">
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>가입일자</td>
		<td>전화번호</td>
	</tr>
	<c:forEach items="${memberList }" var="member">
	<tr align="center">
		<td>${member.id }</td>
		<td>${member.password }</td>
		<td>${member.name }</td>
		<td>${member.joindate }</td>
		<td>${member.phone }</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>