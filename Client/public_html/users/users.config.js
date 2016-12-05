angular
		.module('app.users')

        .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
            
            $httpProvider.defaults.crossDomain=true;
            $httpProvider.defaults.useXDomain = true;
            $httpProvider.defaults.withCredentials = false;

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
                            $location.path('#signin');
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
                    if ( next.templateUrl === "signin.html") {
                        $location.path("#signin");
                    }
                }
            });
        });