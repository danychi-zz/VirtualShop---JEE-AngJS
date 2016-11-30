angular
		.module('app')

        .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
            
            $httpProvider.defaults.crossDomain=true;
            $httpProvider.defaults.useXDomain = true;
            $httpProvider.defaults.withCredentials = false;

            $routeProvider.
                when('/', {
                    templateUrl: 'users/templates/home.html',
                    controller: 'HomeController'
                }).
                when('/signin', {
                    templateUrl: 'users/templates/signin.html',
                    controller: 'HomeController'
                }).
                when('/signup', {
                    templateUrl: 'users/templates/signup.html',
                    controller: 'HomeController'
                }).
                 when('/user-profile', {
                    templateUrl: 'users/templates/user-profile.html',
                    controller: 'HomeController'
                }).
                   when('/account-settings', {
                    templateUrl: 'users/templates/account-settings.html',
                    controller: 'HomeController'
                }).
                    when('/my-orders', {
                    templateUrl: 'users/templates/my-orders.html',
                    controller: 'HomeController'
                }).
                when('/logout', {
                    templateUrl: 'users/templates/logout.html',
                    controller: 'HomeController'
                }).  
                when('/order-details', {
                    templateUrl: 'users/templates/order-details.html',
                    controller: 'HomeController'
                }).              
                otherwise({
                    redirectTo: 'users/templates/home.html'
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
};