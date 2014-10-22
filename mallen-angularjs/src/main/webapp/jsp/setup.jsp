<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="setupApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first angular js</title>
</head>
<body>
<h1>before</h1>
	<div ng-view>
	</div>
<h1>after</h1>
</body>
<%
	String contextPath = request.getContextPath();
%>
<script type="text/javascript" src="<%=contextPath %>/framework/angularjs/1.2.9/angular.js"></script>
<script type="text/javascript" src="<%=contextPath %>/framework/angularjs/1.2.9/angular-route.js"></script>
<script type="text/javascript" src="<%=contextPath %>/js/controllers/setup/setupApp.js"></script>
<script type="text/javascript" src="<%=contextPath %>/js/controllers/setup/controllers.js"></script>
</html>