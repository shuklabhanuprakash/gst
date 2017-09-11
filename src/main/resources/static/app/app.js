'use strict';

var gstApp = angular.module('BlurAdmin', [ 'ngAnimate', 'ui.bootstrap',
		'ui.sortable', 'ui.router', 'ngTouch', 'toastr', 'smart-table',
		"xeditable", 'ui.slimscroll', 'ngJsTree',
		'angular-progress-button-styles',

		'BlurAdmin.theme', 'BlurAdmin.pages' ]);

gstApp.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/dashboard');

	$stateProvider.state('dashboard', {
		url : '/dashboard',
		templateUrl : 'app/pages/dashboard/dashboard.html',
		title : 'Dashboard',
		sidebarMeta : {
			icon : 'ion-android-home',
			order : 0,
		},
	});

});