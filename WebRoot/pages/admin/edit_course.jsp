<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP '/edit_course.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">


</head>

<body>
	<div id="header">
		<jsp:include page="../plugins_header.jsp"></jsp:include>
	</div>

	<div id="nav">
		<jsp:include page="../plugins_left.jsp"></jsp:include>
	</div>

	<div id="section" align="center">
		<h5>新增课程</h5>
			<table border="1" cellspacing="0" width="60%" align="center">
				<tr align="center" valign="middle">
					<td>课程名称</td>
					<td><input type="text" name="course_name"
						value="${course_name}" />
					</td>
				</tr>
				<tr align="center" valign="middle">
					<td>考核方式</td>
					<td><select id="course_mode" name="course_mode">
							<option value="1">考试</option>
							<option value="2">考核</option>
					</select></td>
				</tr>
				<tr align="center" valign="middle">
					<td>学分</td>
					<td><input type="text" name="course_credit"
						value="${course_credit}" />
					</td>
				</tr>
				<tr align="center" valign="middle">
					<td>状态</td>
					<td><select id="course_display" name="course_display">
							<option value="1">可见</option>
							<option value="0">不可见</option>
					</select>
					</td>
				</tr>
				<tr align="center">
					<td colspan=2><input type="submit" value="提交" /></td>
				</tr>
			</table>
	</div>

	<div id="footer">Copyright : unis.com</div>
</body>
</html>
