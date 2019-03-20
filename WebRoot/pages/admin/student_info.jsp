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

<title>My JSP '/student_info.jsp' starting page</title>

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
		<form method="post" action="<%=basePath%>AdminServlet/getStudentList">
			<h5>
				学生姓名：<input type="text" name="st_name" value="${st_name}"> 
				<input type="submit" value="查询">
			</h5>
		</form>
		<c:if test="${stuList != null }">
			<table border="1" cellspacing="0" width="60%" align="center">
				<tr align="center" valign="middle">
					<td>用户ID</td>
					<td>姓名</td>
					<td>出生日期</td>
					<td>电话</td>
					<td>角色</td>
				</tr>
				<c:forEach items="${stuList}" var="student">
					<tr>
						<td>${student.st_id }</td>
						<td>${student.st_name }</td>
						<td>${student.st_birth }</td>
						<td>${student.st_phone }</td>
						<td><c:if test="${student.st_flag ==1 }">
									管理员
								</c:if> <c:if test="${student.st_flag ==0 }">
									学生
								</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</div>

	<div id="footer">Copyright : unis.com</div>
</body>
</html>
