<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<h1>学生管理系统</h1>
<h5 align=right>
	${admin.st_name}，您好！ <span id="white"><a
		href="<%=basePath%>UserServlet/LogOut">退出</a> </span>
</h5>