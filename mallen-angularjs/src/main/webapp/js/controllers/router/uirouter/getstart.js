var getStartApp = angular.module('getStartApp', [ 'ui.router' ]);

getStartApp.config(function($stateProvider, $urlRouterProvider) {
	var path =  getRootPath() + "/tpls/router/uirouter/";
	// For any unmatched url, redirect to /state1
	$urlRouterProvider.otherwise("/state1");

	// Now set up the states
	$stateProvider.state('state1', {
		url : "/state1",
		templateUrl : path + "state1.html"
	}).state('state1.list', {
		url : "/list",
		templateUrl : path + "state1.list.html",
		controller : function($scope) {
			$scope.items = [ "A", "List", "Of", "Items" ];
		}
	}).state('state2', {
		url : "/state2",
		templateUrl : path + "state2.html"
	}).state('state2.list', {
		url : "/list",
		templateUrl : path + "state2.list.html",
		controller : function($scope) {
			$scope.things = [ "A", "Set", "Of", "Things" ];
		}
	});
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