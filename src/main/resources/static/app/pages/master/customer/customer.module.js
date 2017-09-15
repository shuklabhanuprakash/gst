/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.master.customer', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('master.customer', {
          url: '/customer',
          templateUrl: 'app/pages/master/customer/customerWizardForm.html',
          title: 'Customer',
          sidebarMeta: {
            order: 1670,
          },
        }).state('master.customer.customerList', {
			url : '/customerList',
			templateUrl : 'app/pages/master/customer/customerList.html',
		}).state('master.customer.customerRegistration', {
			url : '/customerRegistration',
			templateUrl : 'app/pages/master/customer/customerRegistration.html',
			 params: {
		            id: null
		        }
		});

	}

})();