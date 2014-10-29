var multipleNamedViewsApp = angular.module("MultipleNamedViewsApp",
		[ "ui.router"]);

multipleNamedViewsApp.config(function($stateProvider, $urlRouterProvider) {
	var path =  getRootPath() + "/tpls/router/uirouter/";
	$urlRouterProvider.otherwise("/index");
	
	$stateProvider.state('index', {
		url : "",
		views : {
			"viewA" : {
				templateUrl : path + "index.viewA.html"
			},
			"viewB" : {
				template : "index.viewB"
			}
		}
	}).state('route1', {
		url : "/route1",
		views : {
			"viewA" : {
				template : "route1.viewA"
			},
			"viewB" : {
				template : "route1.viewB"
			}
		}
	}).state('route2', {
		url : "/route2",
		views : {
			"viewA" : {
				template : "route2.viewA"
			},
			"viewB" : {
				template : "route2.viewB"
			}
		}
	})
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