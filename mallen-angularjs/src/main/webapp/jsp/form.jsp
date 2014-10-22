<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String contextPath = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=contextPath %>/css/bootstrap/3.2.0/bootstrap.css">
<title>form test</title>
</head>
<body ng-app="UserInfoApp">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="panel-title">双向数据绑定</div>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-12">
					<form class="form-horizontal" role="form" ng-controller="UserInfoCtrl">
						<div class="form-group">
							<lable class="col-md-2 control-label">邮箱：</lable>
							<div class="col-md-10">
								<input ng-model="userInfo.email" type="email" class="form-control" placeholder="推荐使用126邮箱">
							</div>
						</div>
						<div class="form-group">
							<lable class="col-md-2 control-label">密码：</lable>
							<div class="col-md-10">
								<input ng-model="userInfo.password" type="password" class="form-control" placeholder="只能是数字、字母、下划线">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-10">
								<div class="checkbox">
									<label>
										<input ng-model="userInfo.autoLogin" type="checkbox">自动登录
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-10">
								<button class="btn btn-default" ng-click="getFormData()">获取Form表单的值</button>
								<button class="btn btn-default" ng-click="setFormData()">设置Form表单的值</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>

<script type="text/javascript" src="<%=contextPath %>/framework/angularjs/1.2.9/angular.js"></script>
<script type="text/javascript" src="<%=contextPath %>/js/controllers/form/form.js"></script>
</html>