angular
	.module('app.shop')  
	.constant('urls', {
	            BASE: 'http://localhost:80',
	            BASE_API_USERS: 'http://localhost:8085/virtualShopWS/api/rest/users/',
	            BASE_API_ORDERS : 'http://localhost:8085/virtualShopWS/api/rest/orders/',
	            BASE_API_PAYMENT_DETAILS : 'http://localhost:8085/virtualShopWS/api/rest/paymentDetails/',
	            BASE_API_PRODUCTS : 'http://localhost:8085/virtualShopWS/api/rest/products/',
	            BASE_API_ORDER_DETAILS : 'http://localhost:8085/virtualShopWS/api/rest/orderDetails/'
    })