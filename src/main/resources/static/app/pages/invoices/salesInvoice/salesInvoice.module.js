/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.invoices.salesInvoice', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('invoices.salesInvoice', {
          url: '/salesInvoice',
          templateUrl: 'app/pages/invoices/salesInvoice/salesInvoiceWizardForm.html',
          title: 'Sales Invoice',
          sidebarMeta: {
            order: 50,
          },
        }).state('invoices.salesInvoice.salesInvoiceList', {
			url : '/salesInvoiceList',
			templateUrl : 'app/pages/invoices/salesInvoice/salesInvoiceList.html',
		}).state('invoices.salesInvoice.salesInvoiceRegistration', {
			url : '/salesInvoiceRegistration',
			templateUrl : 'app/pages/invoices/salesInvoice/salesInvoiceRegistration.html',
			 params: {
		            id: null
		        }
		});

	}

})();