<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
</head>
<body>
<form action="/action/login">
<table style="margin:0 auto;width:300px;">
	<tr>
		<td colspan="2">用户登陆</td>
	</tr>
	<tr>
		<td>邮箱</td>
		<td><input type="text" name="email" id="email" /></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="password" name="password" id="password" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="提交" />|<input type="reset" value="重置" /></td>
	</tr>
	<tr>
		<td><a href="http://www.oschina.com/action/oauth2/authorize?response_type=code&client_id=TQKp4Oj2ublXJ80pVlvY&redirect_uri=http://www.bxltest.net/login.jsp">osc账号登陆</a></td>
		<td></td>
	</tr>
</table>
</form>
	<%String codeStr=request.getParameter("code"); %><br />
	<%String tokenStr=request.getParameter("access_token"); %>
	<a href="http://www.oschina.com/action/openapi/token?client_id=TQKp4Oj2ublXJ80pVlvY&client_secret=QPlNABOi3txpB8mGZq55nF9gOoqoPeHF&grant_type=authorization_code&redirect_uri=http://www.bxltest.net/login.jsp&code=<%=codeStr %>&dataType=json&callback=json">获取Token</a>
	<a href="http://www.oschina.com/action/openapi/user?access_token=2d6e2ff2-2a85-49ba-b815-e30151b7acca&dataType=json">获取个人信息</a>
</body>
</html>