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
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/form.css">
<script type="text/javascript" src="js/util.js"></script>
<title>CRUD综合案例</title>
</head>
<body>
<%
	String url = basePath + "dept_list.jsp" ;
	String msg = "信息修改失败！" ;
	Dept dept = new Dept() ;
	dept.setDeptno(Integer.parseInt(request.getParameter("deptno"))) ;
	dept.setDname(request.getParameter("dname"))  ;
	dept.setLoc(request.getParameter("loc"))  ;
	IDeptService ids = ServiceFactory.getInstance(DeptServiceImpl.class) ;
	if(ids.edit(dept)){
		msg = "信息修改成功！" ;	
	}
%>
<jsp:include page="time_div.jsp">
	<jsp:param value="<%=msg%>" name="msg"/>
	<jsp:param value="<%=url%>" name="url"/>
</jsp:include>
</body>
</html>