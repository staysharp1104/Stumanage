<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<ul>
	<li><a href="<%=basePath%>AdminServlet/getStudentList">学生列表</a></li>
	<li><a href="<%=basePath%>AdminServlet/getCourseList">课程管理</a></li>
	<li><a href="<%=basePath%>AdminServlet/getSelectList">选课列表</a></li>
</ul>
