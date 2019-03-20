<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>学生管理系统</title>
</head>

<body style="background-color:#D2E9FF">

	<div align="center">
		<p>学生后台管理系统</p>
	</div>
	<form method="post" action="<%=basePath%>UserServlet/login">
		<table align="center">
			<tr>
				<td>用户ID</td>
				<td><input name="userid" id="userid" type="text"
					onfocus="this.value=''" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" type="password" id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="登录" style="width:100%;" type="submit">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><a href="register.jsp"  ><input type="button" value="注册" style="width:100%;"></a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>
