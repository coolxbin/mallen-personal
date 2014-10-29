<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html ng-app="getStartApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=contextPath %>/css/bootstrap/3.2.0/bootstrap.css">
<title>ui-router get start</title>
</head>
<body>
	<!-- <div ui-view></div> -->
	<a ui-sref="state1">State 1</a>
    <a ui-sref="state2">State 2</a>
</body>
<script type="text/javascript" src="<%=contextPath %>/framework/angularjs/1.2.9/angular.js"></script>
<script type="text/javascript" src="<%=contextPath %>/framework/angularjs/1.2.9/angular-animate.js"></script>
<script type="text/javascript" src="<%=contextPath %>/framework/angular-ui/ui-router/angular-ui-router.js"></script>
<script type="text/javascript" src="<%=contextPath %>/js/controllers/router/uirouter/getstart.js"></script>
</html>