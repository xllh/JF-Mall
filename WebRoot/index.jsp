<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	哎呀，首页啊~！
	<%=request.getAttribute("name") %>
	<a href="http://www.oschina.com/action/oauth2/authorize?response_type=code&client_id=TQKp4Oj2ublXJ80pVlvY&redirect_uri=http://www.bxltest.net/login.jsp">osc账号登陆</a>
</body>
</html>