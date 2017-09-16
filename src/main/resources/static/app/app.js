'use strict';

var app = angular.module(
		'BlurAdmin',
		[ 'ngAnimate', 'ui.bootstrap', 'ui.sortable', 'ui.router', 'ngTouch',
				'toastr', 'smart-table', "xeditable", 'ui.slimscroll',
				'ngJsTree', 'angular-progress-button-styles',
				'BlurAdmin.theme', 'BlurAdmin.pages' ]).constant('_', window._);

app.controller("MainController", function($scope, $http, _, $rootScope) {
	$rootScope.countries = [];
	$rootScope.states = [];
	$rootScope.cites = [];

	const getCountries = function() {
		$rootScope.countries = $scope.loadData("json/countries.json");

	}
	const getStates = function() {

		$rootScope.states = $scope.loadData("json/states.json");
	}

	const getCities = function() {
		$rootScope.cites = $scope.loadData("json/cities.json");
	}

	$scope.loadData = function(url) {

		$http.get(url).then(function(response) {
			console.log(response.data)
			return response.data;
		}, function(error) {
			console.log("error", error);
		});
	}

	$scope.init = function() {
		getCountries();
		getStates();
		getCities();
	}
});