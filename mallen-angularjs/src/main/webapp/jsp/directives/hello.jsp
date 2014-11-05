<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello directive</title>
</head>
<body ng-app="HelloDirective">
<div>
	this is before
	<div hello="">this is inner1</div>
	<hello>this is innner2</hello>
	this is after
</div>
</body>

<script type="text/javascript"
	src="<%=contextPath%>/framework/angularjs/1.2.9/angular.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/js/controllers/directives/helloDirective.js"></script>
</html>