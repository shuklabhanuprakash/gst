/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.master', [
	    'BlurAdmin.pages.master.company',
	    'BlurAdmin.pages.master.customer',
	    'BlurAdmin.pages.master.product'
	    ])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
	    $stateProvider
	        .state('master', {
	          url: '/master',
	          template : '<ui-view  autoscroll="true" autoscroll-body-top></ui-view>',
	          abstract: true,
	          title: 'Master',
	          sidebarMeta: {
	            icon: 'ion-android-laptop',
	            order: 200,
	          },
	        });
	  }

})();
