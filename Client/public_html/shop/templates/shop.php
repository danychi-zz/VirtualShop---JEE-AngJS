<!DOCTYPE html>
<html>



<!-- INCLUDES -->

<?php
include '../inc/encabezado.php';
?>

<!-- SCRIPTS ANGULAR JS-->
<script src= "../js/jquery-1.9.1.min.js"></script>
<script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script src="../bower_components/ngcart/dist/ngCart.js"></script>

<body ng-app="app">

        <div ng-view></div>



    
</script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular-route.min.js"></script>
    <script src="../lib-user/ngStorage.js"></script>
    <script src="shop/shop.module.js"></script>
    <script src="shop/shop.filters.js"></script>
    <script src="shop/shop.config.js"></script>
    <script src="shop/shop.constants.js"></script>
    <script src="shop/shop.factories.js"></script>
    <script src="shop/shop.js"></script>
    <script src="../js/dirPagination.js"></script>
        <script>

        </script>


<?php
include '../inc/pie.php';
?> 
</body>
</html>