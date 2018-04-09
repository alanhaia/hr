<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<div><%=request.getParameter("msg")%></div>
	<div><span id="mytime">5</span>秒后跳转至<a href="<%=request.getParameter("url")%>">首页</a></div>
</div>
<script type="text/javascript">
	var goUrl = "<%=request.getParameter("url")%>" ;
	gotime() ;
</script>