(function () {
    'use strict';

    angular.module('app')
        .factory('Shop', ['$http', '$localStorage', 'urls', function ($http, $localStorage, urls) {
            return {
                getProducts: function (success, error) {
                    $http.get(urls.BASE_API_PRODUCTS).success(success).error(error)
                },
                getUserInfo: function (success, error) {
                   $http.get(urls.BASE_API_USERS + 'getUserInfo').success(success).error(error)
                },
                createOrder: function (data,success, error) {
                   $http.post(urls.BASE_API_ORDERS + 'confirm', data).success(success).error(error)
                }
            };
        }
        ]);
})();