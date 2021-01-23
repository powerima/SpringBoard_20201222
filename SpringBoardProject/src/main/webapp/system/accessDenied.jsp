<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp" %>

<div align="center">
<h3>죄송합니다 권한이 없습니다.</h3>
<hr width="80%">
<table border="1" width="300">
	<tr>
		<td align="center">다시 로그인 하기</td>
	</tr>
	<tr>
		<td align="center">
			<input type="button" value="로그인"
				onClick="location.href='/myapp/system/login.do'">
		</td>
	</tr>
</table>
</div>
</body>
</html>