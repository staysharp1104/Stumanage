<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/" ;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>学生管理系统</title>
    <link type="text/css" rel="stylesheet" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
</head>
<body>
<h1>对不起，程序出现了错误，请与管理员联系！</h1>
</body>
</html>
