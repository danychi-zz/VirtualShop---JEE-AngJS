    angular
        .module('app.router')  
        .config(['$routeProvider', function($routeProvider){
            $routeProvider.
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
                when('/shop', {
                    templateUrl: 'shop/templates/shop-view.html',
                    controller: 'ShopController'
                }).            
                when('/', {
                    templateUrl: 'users/templates/welcome.html',
                    controller: 'UserController'
                }).
                when('/signin', {
                    templateUrl: 'users/templates/signin.html',
                    controller: 'UserController'
                }).
                when('/signup', {
                    templateUrl: 'users/templates/signup.html',
                    controller: 'UserController'
                }).
                 when('/user-profile', {
                    templateUrl: 'users/templates/user-profile.html',
                    controller: 'UserController'
                }).
                   when('/account-settings', {
                    templateUrl: 'users/templates/account-settings.html',
                    controller: 'UserController'
                }).
                    when('/my-orders', {
                    templateUrl: 'users/templates/my-orders.html',
                    controller: 'UserController'
                }).
                when('/logout', {
                    templateUrl: 'users/templates/logout.html',
                    controller: 'UserController'
                }).  
                when('/order-details', {
                    templateUrl: 'users/templates/order-details.html',
                    controller: 'UserController'
                }).              
                otherwise({
                    redirectTo: 'users/templates/home.html'
                });
            }]);