var routerApp = angular.module("RouterApp", ['ui.router']);

routerApp.config(function($stateProvider, $urlRouterProvider){
	var path =  getRootPath() + "/tpls/router/uirouter/twopage/";
	$urlRouterProvider.otherwise("/home");
	$stateProvider
	.state("home",{
			url: "/home",
			templateUrl: path + "home.html"
	})
	.state("home.list",{
		url: "/list",
		templateUrl: path + "home-list.html",
		 controller: function($scope) {
	            $scope.topics = ['Butterscotch', 'Black Current', 'Mango'];
	     }
	})
	.state("home.paragraph",{
		url:"/paragraph",
		template:"I could sure use a scoop of ice-cream."
	})
	.state("about",{
		url:"/about",
		views: {
			"": {
				templateUrl: path + "about.html"
			},
			"columnOne@about":{
				template:"这里是第一列的内容"
			},
			"columnTwo@about":{
				templateUrl: path + "table-data.html",
				controller:"ColumnTwoController"
			}
		}
	});
});

routerApp.controller("ColumnTwoController",function($scope){
	$scope.message="test";
	$scope.topics=[
	   {name:"Butterscotch", price:50},
	   {name:"Black Current", price:100},
	   {name:"Mango", price:20}
	];
});

function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}