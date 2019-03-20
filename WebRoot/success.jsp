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

				
				<br>
				<br>
				
				<h3 align=center>用户已注册：<%=request.getAttribute("registerName")%>
				<br>
						<a href="<%=basePath%>login.jsp" align=center>去登录刚注册的账号</a></h3>
</body>
</html>