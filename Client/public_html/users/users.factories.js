angular
        .module('app')
        .factory('userService', userService)

        userService.$inject = ['$http','urls','$localStorage'];    

        function userService ($http, urls, $localStorage){
            var service = {
                urlBase64Decode: urlBase64Decode,
                signup: signup,
                signin: signin,
                logout: logout,
                update: update,
                myOrders: myOrders,
                getUserInfo: getUserInfo,
                getProductsIdByOrderId: getProductsIdByOrderId,
                getPaymentInfo: getPaymentInfo,
                getProductsByProductsId: getProductsByProductsId,
                getOrderDetailsByOrderId: getOrderDetailsByOrderId,
                deleteOrder: deleteOrder,
                getStatus: getStatus
            };
            return service;
            
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
            function signup (data, success, error) {
                $http.post(urls.BASE_API_USERS + 'signup', data).success(success).error(error)
            }
            function signin (data, success, error) {
                $http.post(urls.BASE_API_USERS + 'signin', data).success(success).error(error)
            }
            function logout (success) {
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
            }
            function update (data, success, error) {
               $http.put(urls.BASE_API_USERS + 'update', data).success(success).error(error)
            }
            function myOrders (success, error) {
               $http.get(urls.BASE_API_ORDERS + 'userId').success(success).error(error)
            }
            function getUserInfo (success, error) {
                $http.get(urls.BASE_API_USERS + 'getUserInfo').success(success).error(error)
            }
            function getProductsIdByOrderId (data, success, error) {
               $http.get(urls.BASE_API_ORDER_DETAILS +'orderId/' + data).success(success).error(error)
            }
            function getPaymentInfo: function (data, success, error) {
               $http.get(urls.BASE_API_PAYMENT_DETAILS +'orderId/'+ data).success(success).error(error)
            }
            function getProductsByProductsId: function (data, success, error) {
               $http.post(urls.BASE_API_PRODUCTS +'productsId/' , data).success(success).error(error)
            }
            function getOrderDetailsByOrderId: function (data, success, error) {
               $http.get(urls.BASE_API_ORDER_DETAILS +'orderDetailsOrderId/' + data).success(success).error(error)
            }
            function deleteOrder: function (data, success, error) {
                $http.delete(urls.BASE_API_ORDERS +'orderId/' + data).success(success).error(error)                            
            }
            function getStatus: function (statusId) {
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
        }