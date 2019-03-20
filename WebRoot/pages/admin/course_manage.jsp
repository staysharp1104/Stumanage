<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP '/course_manage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
<script>
function addCourse()
{
window.open("<%=basePath%>pages/admin/add_course.jsp","_self");
}
</script>


</head>

<body>
	<div id="header">
		<jsp:include page="../plugins_header.jsp"></jsp:include>
	</div>

	<div id="nav">
		<jsp:include page="../plugins_left.jsp"></jsp:include>
	</div>

	<div id="section" align="center">
		<form method="post" action="<%=basePath%>AdminServlet/getCourseList">
			<h5>
				课程名称：<input type="text" name="cs_name" value="${cs_name}" /> <input
					type="submit" value="查询"/>  
					      <input type="button" value="新增" onclick="addCourse()"/>
			</h5>
			
		</form>
		<c:if test="${csList != null }">
			<table border="1" cellspacing="0" width="60%" align="center">
				<tr align="center" valign="middle">
					<td>课程ID</td>
					<td>课程名称</td>
					<td>考核方式</td>
					<td>学分</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${csList}" var="course">
					<tr>
						<td>${course.course_id }</td>
						<td>${course.course_name }</td>
						<td>
						<c:if test="${course.course_mode ==1 }">
									考试
								</c:if> <c:if test="${course.course_mode ==2 }">
									考核
								</c:if></td>
						<td>${course.course_credit }</td>
						<td><c:if test="${course.course_display ==1 }">
									可见
								</c:if> <c:if test="${course.course_display ==0 }">
									不可见
								</c:if>
						</td>						
						<td>修改</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</div>

	<div id="footer">Copyright : unis.com</div>
</body>
</html>
