(function () {
    'use strict';

    angular.module('app')
        .controller('HomeController', ['$rootScope', '$scope', '$location','$filter', '$localStorage', 'Auth',
            function ($rootScope, $scope, $location, $filter, $localStorage,  Auth) {

             

                //########## SUCCESS FUNCTIONS ########## 
                function successAuth(res) {
                    $localStorage.token = res;
                    window.location = "/";
                }

                function successUpdate(res){
                    $localStorage.token = res;
                    window.location.reload();
                    window.alert("Updated!");
                }

                  function successGetOrders(res){
                    $localStorage.orders = res;
                    $rootScope.orders = $localStorage.orders;
                    
                }

                 function succesGetUserInfo(res){
                    $localStorage.userInfo = res;
                }

                function successGetProductsId(res){
                    $localStorage.productsId = res;

                        var formData =  $localStorage.productsId ;
                        Auth.getProductsByProductsId(formData,successGetProductsByProductsId , function (res) {
                            $rootScope.error = res.error || 'Failed to get the Products.';
                         })
                    }

                 function successGetPaymentInfo(res){
                    $localStorage.paymentInfo = res;
                    $rootScope.paymentInfo =  $localStorage.paymentInfo;
                }

                 function successGetProductsByProductsId(res){
                    $localStorage.productsOrderDetail = res;
                    $rootScope.productsOrderDetail =  $localStorage.productsOrderDetail;
                }

                function successGetOrderDetailsByOrderId(res){
                    $localStorage.orderDetails = res;
                    $rootScope.orderDetails =  $localStorage.orderDetails;
                }


                function successDeleteOrder(res){
                    window.location.reload();
                    window.alert("Order deleted Successfully!");
                }




              

                //########## LOGIN/REGISTER/LOGOUT FUNCTIONS ########## 

                $scope.signin = function () {
                    var formData = {
                        email: $scope.email,
                        password: $scope.password,
                    };

                    Auth.signin(formData, successAuth, function () {
                        $rootScope.error = 'Invalid credentials.';
                    })
                };

                $scope.signup = function () {
                    var formData = {
                        email: $scope.email,
                        password: $scope.password,
                        firstName: $scope.first_name,
                        lastName: $scope.last_name,
                        username: $scope.username,
                        phone: $scope.phone,
                        postalCode: $scope.postal_code,
                        billingAddress: $scope.billing_address,
                        state: $scope.state,
                        dni: $scope.dni,
                        city: $scope.city
                    };

                    Auth.signup(formData, successAuth, function (res) {
                        $rootScope.error = res.error || 'Failed to sign up.';
                    })
                };
                 
                  $scope.update = function () {
                    var formData = {
                        email: $scope.email,
                        password: $scope.password,
                        firstName: $scope.first_name,
                        lastName: $scope.last_name,
                        username: $scope.username,
                        phone: $scope.phone,
                        postalCode: $scope.postal_code,
                        billingAddress: $scope.billing_address,
                        state: $scope.state,
                        dni: $scope.dni,
                        city: $scope.city
                    };

                    Auth.update(formData, successUpdate, function (res) {
                        $rootScope.error = res.error || 'Failed to update.';
                    })
                };

                 $scope.logout = function () {
                    Auth.logout(function () {
                        $localStorage.token = null;
                    });
                };

                //########## USER PROFILE FUNCTIONS ########## 

                $scope.myOrders = function () {
                $localStorage.status= [];
                $rootScope.status = [];
                Auth.myOrders(successGetOrders, function (res) {
                   
                    $rootScope.error = res.error || 'Failed to get Orders.';
                })
                };

                $scope.getOrders = function () {
                     if($localStorage.orders!=null){
                      $rootScope.orders = $localStorage.orders;
                      }
                
                };


                $scope.getOrderIdtoShow = function () {
                    if($localStorage.orderId!=null){
                      $rootScope.orderId = $localStorage.orderId;
                      }
                };

                $scope.setOrderIdtoShow = function (orderId) {
                    if(orderId!=null){
                      $localStorage.orderId = orderId;
                     }
                };

                $scope.getUserInfo = function () {

                    Auth.getUserInfo(succesGetUserInfo, function (res) {
                       
                        $rootScope.error = res.error || 'Failed to get the User Info.';
                         })
                }

                 $scope.recoverUserInfo = function(){
                    $rootScope.userInfo = $localStorage.userInfo;

                 }      

                 $scope.getProductsIdByOrderId = function () {

                        var formData = $rootScope.orderId;

                    Auth.getProductsIdByOrderId(formData,successGetProductsId, function (res) {
                       
                        $rootScope.error = res.error || 'Failed to get the Products Info.';
                         })
                }
                $scope.getPaymentInfo = function () {

                    var formData = $rootScope.orderId;

                    Auth.getPaymentInfo(formData,successGetPaymentInfo, function (res) {
                       
                        $rootScope.error = res.error || 'Failed to get the Payment Info.';
                         })
                }
               

                  $scope.getOrderDetailsByOrderId = function () {

                    var formData = $rootScope.orderId;

                    Auth.getOrderDetailsByOrderId(formData,successGetOrderDetailsByOrderId , function (res) {
                       
                        $rootScope.error = res.error || 'Failed to get the Order Details.';
                         })
                }

                 $scope.deleteOrder = function (orderId) {

                    var formData = orderId;

                    Auth.deleteOrder(formData,successDeleteOrder, function (res) {
                       
                        $rootScope.error = res.error || 'Failed to Delete the Order.';
                         })
                }

                $scope.getStatus = function (statusId) {
                    if($localStorage.status[$rootScope.orders.length-1]==null){
                    $localStorage.status.push(Auth.getStatus(statusId));
                    }
                     $rootScope.status =$localStorage.status;
                };
                $scope.getSingleStatus = function (statusId){
                    $localStorage.ss = (Auth.getStatus(statusId));
                    $rootScope.ss = $localStorage.ss;
                }

               
            }])
})();