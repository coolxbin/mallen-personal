<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=contextPath %>/css/bootstrap/3.2.0/bootstrap.css">
<title>Two Page</title>
</head>
<body ng-app="RouterApp">
	<div class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" ui-sref="#">AngularUI Router</a>
		</div>
		<ul class="nav navbar-nav">
			<li>
				<a ui-sref="home">Home</a>
			</li>
			<li>
				<a ui-sref="about">About</a>
			</li>
		</ul>
	</div><!-- end of navigation -->
	<div class="container">
        <div ui-view=""></div>
    </div>
</body>

<script type="text/javascript" src="<%=contextPath %>/framework/angularjs/1.2.9/angular.js"></script>
<script type="text/javascript" src="<%=contextPath %>/framework/angularjs/1.2.9/angular-animate.js"></script>
<script type="text/javascript" src="<%=contextPath %>/framework/angular-ui/ui-router/angular-ui-router.js"></script>
<script type="text/javascript" src="<%=contextPath %>/js/controllers/router/uirouter/twopage.js"></script>
</html>