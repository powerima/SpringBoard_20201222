<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>

<div align="center">
<h3>로그인</h3>
<hr width="80%">
<form action="login.do" method="post">
<table border="1">
	<tr>
		<td align="center">아이디</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="password" name="password"></td>		
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>