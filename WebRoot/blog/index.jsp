<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="bean.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Map<String, Object> blog = (Map<String, Object>)request.getAttribute("singleBlog");%>
<table>
	<tr><td><%=blog.get("title") %></td></tr>
	<tr><td><%=blog.get("ctime") %></td></tr>
	<tr><td><%=blog.get("content") %></td></tr>
	<tr><td><%=blog.get("keywords") %></td></tr>
</table>
123
</body>
</html>