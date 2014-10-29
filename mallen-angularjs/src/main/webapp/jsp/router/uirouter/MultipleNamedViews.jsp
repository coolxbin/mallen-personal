<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html ng-app="MultipleNamedViewsApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Multiple & Named Views</title>
</head>
<body>
	<div ui-view="viewA"></div>
    <div ui-view="viewB"></div>
    <!-- Also a way to navigate -->
    <a ui-sref="route1">Route 1</a>
    <a ui-sref="route2">Route 2</a>
</body>
<script type="text/javascript" src="<%=contextPath %>/framework/angularjs/1.2.9/angular.js"></script>
<script type="text/javascript" src="<%=contextPath %>/framework/angularjs/1.2.9/angular-animate.js"></script>
<script type="text/javascript" src="<%=contextPath %>/framework/angular-ui/ui-router/angular-ui-router.js"></script>
<script type="text/javascript" src="<%=contextPath %>/js/controllers/router/uirouter/multipleNamedViews.js"></script>
</html>