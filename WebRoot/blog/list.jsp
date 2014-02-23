<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<%
	myPage<Blog> blogPageList = (myPage<Blog>)request.getAttribute("blogPageList");
	List<Blog> blogList = (ArrayList<Blog>)blogPageList.getList();
	for(int i=0;i<blogList.size();i++){
		Map<String, Object> blog = (Map<String, Object>)blogList.get(i);
%>
	<tr>
		<td><%=blog.get("id") %></td>
		<td><a href="/blog/<%=blog.get("guid") %>"><%=blog.get("title") %></a></td>
		<td><%=blog.get("createtime") %></td>
	</tr>
<%}%>
</table>

</body>
</html>