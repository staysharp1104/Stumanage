<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body >
<div id="container" >

		<div id="header" style="background-color:#ADADAD;height:100px;">
			<h1 style="margin-bottom:0;text-align:center">学生管理系统</h1>
		</div>

		<div id="menu" style="background-color:#c4eeff;height:500px;width:150px;float:left;">
<ul  id="side-menu">
<li><a href="<%=basePath%>pages/back/index.jsp">学生列表</a></li>
<li><a href="<%=basePath%>pages/back/index.jsp">学生管理</a></li>
<li><a href="<%=basePath%>pages/back/index.jsp">增加学生</a></li>
</ul>
</div>
 
<div id="content" style="height:500px;float:left;">
内容在这里</div>
 
<div id="footer" style="background-color:#ADADAD;clear:both;text-align:center;">
版权 © unis.com</div>
 
</div>

</body>
</html>