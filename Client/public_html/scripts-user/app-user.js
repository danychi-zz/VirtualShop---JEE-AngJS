(function () {
    'use strict';

    angular.module('app', [
        'ngStorage',
        'ngRoute'
    ])

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
            $httpProvider.defaults.withCredentials = true;

            $routeProvider.
                when('/', {
                    templateUrl: 'home.html',
                    controller: 'HomeController'
                }).
                when('/signin', {
                    templateUrl: 'signin.html',
                    controller: 'HomeController'
                }).
                when('/signup', {
                    templateUrl: 'signup.html',
                    controller: 'HomeController'
                }).
                 when('/user-profile', {
                    templateUrl: 'user-profile.html',
                    controller: 'HomeController'
                }).
                   when('/account-settings', {
                    templateUrl: 'account-settings.html',
                    controller: 'HomeController'
                }).
                    when('/my-orders', {
                    templateUrl: 'my-orders.html',
                    controller: 'HomeController'
                }).
                when('/logout', {
                    templateUrl: 'logout.html',
                    controller: 'HomeController'
                }).  
                when('/order-details', {
                    templateUrl: 'order-details.html',
                    controller: 'HomeController'
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
                            $location.path('/signin');
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
                    if ( next.templateUrl === "user-views/signin.html") {
                        $location.path("/signin");
                    }
                }
            });
        });
})();