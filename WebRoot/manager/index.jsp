<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台首页</title>
</head>
<body>
	<%User currentUser=(User)session.getAttribute("adou_user"); %>
	<%if(currentUser!=null){ %>
	<div class="admin_toolbar">当前用户：<%=currentUser.getStr("email") %><a href="/action/logout">注销</a></div>
	<form action="/action/uploadFile" enctype="multipart/form-data" method="POST">
		<table>
			<tr>
				<td>名称</td>
				<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td>文件</td>
				<td><input type="file" name="img" id="img" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
	<a href="/action/downloadFile?file=123.zip">123.zip</a>
	<%}else{ 
		response.sendRedirect("/index.jsp");
	}%>
	
	
</body>
</html>