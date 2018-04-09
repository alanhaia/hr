<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setCharacterEncoding("UTF-8") ;
	String doUrl = basePath + "dept_add_do.jsp" ;
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/form.css">
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/dept_add.js"></script>
<title>dept_add.jsp</title>
</head>
<body>
	<form action="<%=doUrl%>" method="post" id="myForm">
		<table border="1">
			<tr>
				<td colspan="3">添加部门信息</td>
			</tr>
			<tr>
				<td>部门编号：</td>
				<td><input type="text" id="deptno" name="deptno" class="init"></td>
				<td>请填写有效的部门编号！</td>
			</tr>
			<tr>
				<td>部门名称：</td>
				<td><input type="text" id="dname" name="dname" class="init"></td>
				<td>请填写有效的部门名称！</td>
			</tr>
			<tr>
				<td>部门位置：</td>
				<td><input type="text" id="loc" name="loc" class="init"></td>
				<td>请填写有效的部门位置！</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="提交">
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>