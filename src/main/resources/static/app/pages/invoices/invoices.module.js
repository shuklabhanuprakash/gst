/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.invoices', [
		    'BlurAdmin.pages.invoices.salesInvoice'/*,
		    'BlurAdmin.pages.invoices.purchaseInvoice'*/
	    
	    ])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
	    $stateProvider
	        .state('invoices', {
	          url: '/invoices',
	          template : '<ui-view  autoscroll="true" autoscroll-body-top></ui-view>',
	          abstract: true,
	          title: 'Invoices',
	          sidebarMeta: {
	            icon: 'ion-android-laptop',
	            order: 200,
	          },
	        });
	  }

})();
