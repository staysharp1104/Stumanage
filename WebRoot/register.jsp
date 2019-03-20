<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:#D2E9FF">
		<form action="<%=basePath%>UserServlet/regist" method="post" align=center>
			<table border="1" cellspacing="0" width="40%" align="center">
			<tr align="center" valign="middle"><td colspan=2>注册账号</td></tr>
			<tr><td>用户ID：</td><td><input type="text"  name="userid"/>*</td></tr>
			<tr><td>姓名：</td><td><input type="text"  name="name"/>*</td></tr>
			<tr><td>密码：</td><td><input type="password"  name="password"/>*</td></tr>
			<tr><td>性别：</td><td><input type="radio" name="sex" value="boy">男
			<input type="radio" name="sex" value="girl">女</td></tr>
			<tr><td>出生日期：</td><td><input id="birth" type="date" /></td></tr>
			<tr><td>手机号：</td><td><input type="text"  name="phone"/></td></tr>
			<tr align="center" valign="middle"><td colspan=2><input type="submit"  value="增加"/>
			<a href="login.jsp"  ><input type="button" value="登陆" ></a></td></tr>
			</table>
</form>
</body>
</html>