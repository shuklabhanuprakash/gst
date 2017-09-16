/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.master.company', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('master.company', {
          url: '/company',
          templateUrl: 'app/pages/master/company/companyWizardForm.html',
          title: 'Company',
          sidebarMeta: {
            order: 50,
          },
        }).state('master.company.companyList', {
			url : '/companyList',
			templateUrl : 'app/pages/master/company/companyList.html',
		}).state('master.company.companyRegistration', {
			url : '/companyRegistration',
			templateUrl : 'app/pages/master/company/companyRegistration.html',
			 params: {
		            id: null
		        }
		});

	}

})();