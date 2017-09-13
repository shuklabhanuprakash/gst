/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.master.product', [])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider) {
    $stateProvider
        .state('master.product', {
          url: '/product',
          templateUrl: 'app/pages/master/product/product.html',
          title: 'Product',
          sidebarMeta: {
            order: 500,
          },
        });
  }

})();
