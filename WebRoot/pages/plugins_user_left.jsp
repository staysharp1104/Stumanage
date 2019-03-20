<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

   	<ul>
			<li><a href="<%=basePath%>StudentServlet/getMyInfo">个人中心</a>
			</li>
			<li><a href="<%=basePath%>StudentServlet/getCourseList">课程列表</a></li>
			<li><a href="<%=basePath%>pages/back/index.jsp">选课管理</a></li>
		</ul>
