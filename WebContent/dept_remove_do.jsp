<%@page import="javax.swing.text.StyledEditorKit.ItalicAction"%>
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
	String reurl = basePath + "dept_list.jsp" ;
	String msg = "信息删除失败！" ;
	String ids = request.getParameter("ids") ;
	String[] result = ids.split("@") ;
	Set<Integer> deptnos = new HashSet<Integer>() ;
	for(int x = 0 ; x < result.length ; x ++){
		deptnos.add(Integer.parseInt(result[x]));
	}
	IDeptService deptService= ServiceFactory.getInstance(DeptServiceImpl.class) ;
	if(deptService.remove(deptnos)){
		msg = "信息删除成功！" ;	
	}
%>
<jsp:include page="time_div.jsp">
	<jsp:param value="<%=msg%>" name="msg"/>
	<jsp:param value="<%=reurl%>" name="url"/>
</jsp:include>
</body>
</html>