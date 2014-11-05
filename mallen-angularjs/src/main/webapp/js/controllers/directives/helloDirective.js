var helloDirective = angular.module("HelloDirective",[]);

helloDirective.directive("hello",function(){
	return {
		// 匹配模式，包含A：attribute，E：element， M:注解<!-- directive:hello -->,注意空格， C: class
		// 四中匹配方式最常用的是A（默认）， E
		// 四个模式可以组合使用，如：AE，则该指令的模式可为attribute和element方式
		restrict: "AE",
		// 模板，可以替换为templateUrl
		template: "<div>Hi Everyone!<div ng-transclude></div></div>",
		// 是否替换引入指令的"标签"，针对的是标签
		replace: false,
		// 是否转换标签的"内容"，针对的是标签内容
		transclude: true
	}
});