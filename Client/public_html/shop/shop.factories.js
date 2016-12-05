angular
    .module('app.shop')  
    .factory('shopService', shopService)

    shopService.$inject = ['$http','$localStorage','urls'];   

    function shopService ($http, $localStorage, urls){
    	var service = {
    		getProducts: getProducts,
    		getUserInfo: getUserInfo,
    		createOrder: createOrder
    	};
    	return service;

        function getProducts (success, error) {
                $http.get(urls.BASE_API_PRODUCTS).success(success).error(error);
        }
        function getUserInfo (success, error) {
               $http.get(urls.BASE_API_USERS + 'getUserInfo').success(success).error(error);
        }
        function createOrder (data,success, error) {
               $http.post(urls.BASE_API_ORDERS + 'confirm', data).success(success).error(error);
        }
	}