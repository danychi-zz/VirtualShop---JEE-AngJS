angular
    .module('app')
    .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
            
            $httpProvider.defaults.crossDomain=true;
            $httpProvider.defaults.useXDomain = true;
            $httpProvider.defaults.withCredentials = false;

            $routeProvider.
                when('/', {
                    templateUrl: 'shop/templates/shop-view.html',
                    controller: 'ShopController'
                }).
                when('/cart', {
                    templateUrl: 'shop/templates/cart-view.html',
                    controller: 'ShopController'
                }).
                when('/checkout', {
                    templateUrl: 'shop/templates/checkout-view.html',
                    controller: 'ShopController'
                }).   
                when('/product-details', {
                    templateUrl: 'shop/templates/product-view.html',
                    controller: 'ShopController'
                }).              
                otherwise({
                    redirectTo: 'shop/templates/shop/view.html'
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