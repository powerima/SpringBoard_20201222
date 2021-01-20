<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>

<div align="center">
<h3>회원 정보</h3>
<hr width="80%">
<table border="1" width="500">
	<tr>	
		<td align="center">아이디</td>
		<td>${member.id }</td>		
	</tr>
	<tr>
		<td align="center">이름</td>
		<td>${member.name }</td>
	</tr>
	<tr>
		<td align="center">전화번호</td>
		<td>${member.phone }</td>
	</tr>
	<tr>
		<td align="center">이메일</td>
		<td>${member.email }</td>
	</tr>
	<tr>
		<td align="center">우편번호</td>
		<td>${member.post }</td>		
	</tr>
	<tr>
		<td align="center">주소</td>
		<td>${member.address1 }  ${member.address2 }</td>
	</tr>	
	<tr>
		<td align="center">가입일자</td>
		<td>${member.joindate }</td>
	</tr>
</table>

<br>
[<a href="updateMember.do">회원 정보 수정</a>]
</div>
</body>
</html>