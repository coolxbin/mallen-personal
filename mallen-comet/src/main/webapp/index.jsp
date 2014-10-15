<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String contextPath = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=contextPath%>/common/jquery/jquery-1.11.1/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/org/cometd.js"></script>
<script type="text/javascript" src="<%=contextPath%>/jquery/jquery.cometd.js"></script>
<script type="text/javascript" src="application.js"></script>
<script type="text/javascript">
        var config = {contextPath: "<%=contextPath%>"};
</script>
</head>
<body>
	<div id="body"></div>
</body>
</html>