(function () {
    'use strict';

    angular.module('app')
        .factory('Auth', ['$http', '$localStorage', 'urls', function ($http, $localStorage, urls) {

            function urlBase64Decode(str) {
                var output = str.replace('-', '+').replace('_', '/');
                switch (output.length % 4) {
                    case 0:
                        break;
                    case 2:
                        output += '==';
                        break;
                    case 3:
                        output += '=';
                        break;
                    default:
                        throw 'Illegal base64url string!';
                }
                return window.atob(output);
            }

            return {
                signup: function (data, success, error) {
                    $http.post(urls.BASE_API_USERS + 'signup', data).success(success).error(error)
                },
                signin: function (data, success, error) {
                    $http.post(urls.BASE_API_USERS + 'signin', data).success(success).error(error)
                },
                logout: function (success) {
                    delete $localStorage.token;
                    delete $localStorage.myOrders;
                    delete $localStorage.orderDetails;
                    delete $localStorage.orderId;
                    delete $localStorage.userInfo;
                    delete $localStorage.productsOrderDetail;
                    delete $localStorage.productsId;
                    delete $localStorage.paymentInfo;
                    delete $localStorage.orders;
                    delete $localStorage.status;
                    success();
                },
                update: function (data, success, error) {
                   $http.put(urls.BASE_API_USERS + 'update', data).success(success).error(error)
                },
                myOrders: function (success, error) {
                   $http.get(urls.BASE_API_ORDERS + 'userId').success(success).error(error)
                },
                getUserInfo: function (success, error) {
                   $http.get(urls.BASE_API_USERS + 'getUserInfo').success(success).error(error)
                },
                getProductsIdByOrderId: function (data, success, error) {
                   $http.get(urls.BASE_API_ORDER_DETAILS +'orderId/' + data).success(success).error(error)
                },
                getPaymentInfo: function (data, success, error) {
                   $http.get(urls.BASE_API_PAYMENT_DETAILS +'orderId/'+ data).success(success).error(error)
                },
                 getProductsByProductsId: function (data, success, error) {
                   $http.post(urls.BASE_API_PRODUCTS +'productsId/' , data).success(success).error(error)
                },
                getOrderDetailsByOrderId: function (data, success, error) {
                   $http.get(urls.BASE_API_ORDER_DETAILS +'orderDetailsOrderId/' + data).success(success).error(error)
                },
                deleteOrder: function (data, success, error) {
                   $http.delete(urls.BASE_API_ORDERS +'orderId/' + data).success(success).error(error)                            
                },
                  getStatus: function (statusId) {
                   if(statusId != null){
                    var status;
                    switch (statusId){
                        case 1:
                        status = "Confirmed";
                        break;

                        case 2:
                        status = "Ready for Shipping";
                        break;

                        case 3:
                        status =  "Sent";
                        break;

                        case 4:
                       status =  "Dispatched";
                        break;

                        case 5:
                       status =  "Delivery Failure";
                        break;

                        case 6:
                        status = "Canceled";
                        break;

                        default:
                        status = "Unknown";
                    }
                   }
                   return status;
                }
            };
        }
        ]);
})();