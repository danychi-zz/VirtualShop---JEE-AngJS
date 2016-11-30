	(function () {
    'use strict';

    angular.module('app', [
        'angularUtils.directives.dirPagination',
        'ngStorage',
        'ngCart',
        'ngRoute'
    ]).filter('unique', function() {
                return function(collection, keyname) {
                    var output = [], 
                          keys = [];

                    angular.forEach(collection, function(item) {
                          var key = item[keyname];
                          if(keys.indexOf(key) === -1) {
                              keys.push(key);
                              output.push(item);
                          }
                    });

                return output;
                };
            })

        .constant('urls', {
            BASE: 'http://localhost:80',
            BASE_API_USERS: 'http://localhost:8085/virtualShopWS/api/rest/users/',
            BASE_API_ORDERS : 'http://localhost:8085/virtualShopWS/api/rest/orders/',
            BASE_API_PAYMENT_DETAILS : 'http://localhost:8085/virtualShopWS/api/rest/paymentDetails/',
            BASE_API_PRODUCTS : 'http://localhost:8085/virtualShopWS/api/rest/products/',
            BASE_API_ORDER_DETAILS : 'http://localhost:8085/virtualShopWS/api/rest/orderDetails/'
        })
        .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
            
            $httpProvider.defaults.crossDomain=true;
            $httpProvider.defaults.useXDomain = true;
            $httpProvider.defaults.withCredentials = false;

            $routeProvider.
                when('/', {
                    templateUrl: 'shop-view.html',
                    controller: 'ShopController'
                }).
                when('/cart', {
                    templateUrl: 'cart-view.html',
                    controller: 'ShopController'
                }).
                when('/checkout', {
                    templateUrl: 'checkout-view.html',
                    controller: 'ShopController'
                }).   
                when('/product-details', {
                    templateUrl: 'product-view.html',
                    controller: 'ShopController'
                }).              
                otherwise({
                    redirectTo: '/'
                });

        

            $httpProvider.interceptors.push(['$q', '$location', '$localStorage', function ($q, $location, $localStorage) {
                return {
                    'request': function (config) {
                        config.headers = config.headers || {};
                        if ($localStorage.token) {
                            config.headers.Authorization =  $localStorage.token;
                        }
                        return config;
                    },
                    'responseError': function (response) {
                        if (response.status === 401 || response.status === 403) {
                            delete $localStorage.token;
                            window.location = "/user-views/user.php?#/signin";
                        }
                        return $q.reject(response);
                    }
                };
            }]);
        }
        ]).run(function($rootScope, $location, $localStorage) {
            $rootScope.token=false;
            if($localStorage.token){$rootScope.token =true;}
            
            $rootScope.$on( "$routeChangeStart", function(event, next) {
                if ($localStorage.token == null) {
                    if ( next.templateUrl === "user-views/restricted.html") {
                        $location.path("/signin");
                    }
                }
            });
        });
})();