(function () {
    'use strict';

    angular.module('app')
        .controller('ShopController', ['$rootScope', '$scope', '$location','$filter', '$localStorage', 'Shop', 'ngCart',
            function ($rootScope, $scope, $location, $filter, $localStorage, Shop, ngCart ) {

            //########## SETTING STANDARD VARIABLES ######### 
            ngCart.setTaxRate(21);
            ngCart.setShipping(3.95); 

            //########## SUCCESS CART FUNCTIONS ########## 
            function successGetProducts(res){
                    $localStorage.products = res;
                    $rootScope.products = $localStorage.products;
                }
            function succesGetUserInfo(res){
                    $localStorage.userInfo = res;
                    $rootScope.userInfo = $localStorage.userInfo;
                }
            function succesCreateOrder(res){
                window.location = "/";
                window.alert("Created!");
            }

            //########## SHOP FUNCTIONS ########## 

            $scope.randomPicture = function(){
                 $rootScope.picture = Math.floor(Math.random() * 5) + 1 ;
            }

            $scope.getProducts = function () {


                    Shop.getProducts(successGetProducts, function (res) {
                       
                        $rootScope.error = res.error || 'Failed to get the Products.';
                         })
                }
            $scope.getUserInfo = function () {

                    Shop.getUserInfo(succesGetUserInfo, function (res) {
                       
                        $rootScope.error = res.error || 'Failed to get the User Info.';
                         })
                }

              $scope.createOrder = function () {

                var orderDetails = $scope.getOrderDetails();

                var formData = {
                orderId:null,
                statusId:null,
                userId:null,
                total:ngCart.totalCost(),
                orderDate:null,
                active:null,
                orderDetails:orderDetails,
                paymentDetail:
                    {paymentDetailId:null,
                    description:$scope.description,
                    orderId:null,
                    number:$scope.number,
                    expDate:$scope.expDate,
                    holderName:$scope.holderName
                    }
                };

                    Shop.createOrder(formData, succesCreateOrder, function (res) {
                       
                        $rootScope.error = res.error || 'Failed to create the Order, check the information.';
                         })
                }
           $scope.getOrderDetails = function(){

            var items =ngCart.getItems();
            var orderDetails =[];
            for(var i in items)
            {
               orderDetails.push(
               {orderDetailId:null,
                active:1,
                orderId:null,
                productId:items[i]._id,
                quantity:items[i]._quantity,
                total:items[i]._quantity*items[i]._price
                })
            };
            return orderDetails;

           }

           $scope.setProductIdtoShow = function(productId){
            $localStorage.productId = productId;
            $rootScope.productId = $localStorage.productId;
           }
           $scope.getProductIdtoShow = function(){
            $rootScope.productId = $localStorage.productId;
           }

           $scope.setCategorytoShow = function(category){
            $localStorage.category = category;
            $rootScope.category = $localStorage.category;
           }
           $scope.getCategorytoShow= function(){
            $rootScope.category = $localStorage.category;
           }
      

            //############# FILTROS #############//


            //############# FILTRO COLOR #############//

                $scope.categoryIncludes = [];
    
                $scope.includecategory = function(category) {
                    var i = $.inArray(category, $scope.categoryIncludes);
                    if (i > -1) {
                        $scope.categoryIncludes.splice(i, 1);
                    } else {
                        $scope.categoryIncludes.push(category);
                    }
                }
                
                $scope.categoryFilter = function(products) {
                    if ($scope.categoryIncludes.length > 0) {
                        if ($.inArray(products.category, $scope.categoryIncludes) < 0)
                            return;
                    }
                    
                    return products;
                }

                    //############# FILTRO MARCA #############//

                $scope.typeIncludes = [];
    
                $scope.includetype = function(type) {
                    var i = $.inArray(type, $scope.typeIncludes);
                    if (i > -1) {
                        $scope.typeIncludes.splice(i, 1);
                    } else {
                        $scope.typeIncludes.push(type);
                    }
                }
                
                $scope.typeFilter = function(products) {
                    if ($scope.typeIncludes.length > 0) {
                        if ($.inArray(products.type, $scope.typeIncludes) < 0)
                            return;
                    }
                    
                    return products;
                }

                    //############# FILTRO GENERO#############//

                $scope.priceIncludes = [];
    
                $scope.includeprice= function(price) {
                    var i = $.inArray(price, $scope.priceIncludes);
                    if (i > -1) {
                        $scope.priceIncludes.splice(i, 1);
                    } else {
                        $scope.priceIncludes.push(price);
                    }
                }
                
                $scope.priceFilter = function(products) {
                    if ($scope.priceIncludes.length > 0) {
                        if ($.inArray(products.price, $scope.priceIncludes) < 0)
                            return;
                    }
                    
                    return products;
                }
                //############# FIN DE FILTROS #############//
            }])

})();