<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="cn.mldn.vo.*" %>
<%@ page import="cn.mldn.iservice.*" %>
<%@ page import="cn.mldn.deptserviceimpl.*" %>
<%@ page import="cn.mldn.util.factory.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setCharacterEncoding("UTF-8") ;
	String deptUrl = basePath + "dept_edit.jsp" ;
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/form.css">
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/dept_list.js"></script>
<title>CRUD综合案例</title>
</head>
<body>
<%
	IDeptService ids = ServiceFactory.getInstance(DeptServiceImpl.class) ;
	List<Dept> all = ids.list() ;
	Iterator<Dept> iterator = all.iterator() ;
%>
	<table border="1" style="width:100%">
		<tr>
			<td colspan="9">信息查询</td>
		</tr>
		<tr>
			<td><input type="checkbox" id="selall"></td>
			<td>部门编号</td>
			<td>部门名称</td>
			<td>部门位置</td>
			<td>部门人数</td>
			<td>平均工资</td>
			<td>平均年限</td>
			<td>最大工资</td>
			<td>最小工资</td>
			<td>操作</td>
		</tr>
<%
	while(iterator.hasNext()){
		Dept dept = iterator.next() ;
%>
		<tr>
			<td><input type="checkbox" id="celall" value=<%=dept.getDeptno()%>></td>
			<td><%=dept.getDeptno()%></td>
			<td><%=dept.getDname()%></td>
			<td><%=dept.getLoc()%></td>
			<td><%=dept.getStat().get("count")%></td>
			<td><%=dept.getStat().get("avg")%></td>
			<td><%=dept.getStat().get("avgyear")%></td>
			<td><%=dept.getStat().get("max")%></td>
			<td><%=dept.getStat().get("min")%></td>
			<td><a href="<%=deptUrl%>?deptno=<%=dept.getDeptno()%>">编辑</a></td>
		</tr>	
<%
	}
%>	
	</table>
	<input type="button" id="rmBut" value="删除选中的数据">
</body>
</html>