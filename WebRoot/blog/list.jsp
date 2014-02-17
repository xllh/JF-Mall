<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
123 list.jsp
<table>
<%	
	List<Object> blogList = (ArrayList<Object>)request.getAttribute("blogs");
		for(int i=0;i<blogList.size();i++){
			Map<String, Object> blog = (Map<String, Object>)blogList.get(i);
%>
	<tr>
		<td><%=blog.get("id") %></td>
		<td><%=blog.get("title") %></td>
		<td><%=blog.get("create_time") %></td>
	</tr>
<%}%>
</table>

</body>
</html>