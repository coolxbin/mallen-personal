var userInfoApp = angular.module('UserInfoApp', []);

userInfoApp.controller('UserInfoCtrl', [ '$scope', function($scope) {
	$scope.userInfo = {
		email : "11111111@126.com",
		password : "11111111",
		autoLogin : true
	};

	$scope.getFormData = function() {
		console.log($scope.userInfo);
	}

	$scope.setFormData = function() {
		$scope.userInfo = {
			email : "22222222@126.com",
			password : "22222222",
			autoLogin : false
		};
	}
} ]);