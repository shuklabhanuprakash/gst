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
          templateUrl: 'app/pages/master/customer/customer.html',
          title: 'Customer',
          sidebarMeta: {
            order: 500,
          },
        });
  }

})();
