/**
 * @author v.lugovsky created on 16.12.2015
 */
(function() {
	'use strict';

	angular.module('BlurAdmin.pages.master.product', []).config(routeConfig);

	/** @ngInject */
	function routeConfig($stateProvider, $urlRouterProvider) {
		$stateProvider.state('master.product', {
			url : '/product',
			templateUrl : 'app/pages/master/product/productWizardForm.html',
			title : 'Product',
			sidebarMeta : {
				order : 500,
			},
		}).state('master.product.productList', {
			url : '/productList',
			templateUrl : 'app/pages/master/product/productList.html',
		}).state('master.product.productRegistration', {
			url : '/productRegistration',
			templateUrl : 'app/pages/master/product/productRegistration.html',
			 params: {
		            id: null
		        }
		});

	}

})();
