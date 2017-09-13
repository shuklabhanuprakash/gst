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
          templateUrl: 'app/pages/master/company/company.html',
          title: 'Company',
          sidebarMeta: {
            order: 500,
          },
        });
  }

})();
