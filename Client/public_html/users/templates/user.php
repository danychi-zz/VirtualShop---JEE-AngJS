<!DOCTYPE html>
<html lang="en">
<!-- INCLUDES -->

<?php
include '../inc/encabezado.php';
?>

<body ng-app="app">
        </br>
        <div class="jumbotron">
        <div class="container">
            <div class="col-sm-8 col-sm-offset-2">
                <div ng-view></div>
            </div>
        </div>
    </div>   


    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular-route.min.js"></script>
    <script src="../lib-user/ngStorage.js"></script>
    <script src="users/users.module.js"></script>
    <script src="users/users.filters.js"></script>
    <script src="users/users.config.js"></script>
    <script src="users/users.constants.js"></script>
    <script src="users/users.factories.js"></script>
    <script src="users/users.js"></script>

        <?php
include '../inc/pie.php';
?> 
</body>
</html>