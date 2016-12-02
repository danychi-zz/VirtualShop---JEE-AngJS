	<!-- start header -->
<head>
<meta charset="utf-8">
<title>Untitled</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://bootstraptaste.com" />
<!-- css -->
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="../css/flexslider.css" rel="stylesheet" />
<link href="../css/style.css" rel="stylesheet" />


<!-- Theme skin -->
<link href="../skins/default.css" rel="stylesheet" />
  </head>

	<header>
		<meta charset="utf-8">
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
          <!-- Token does not exist-->
                    <div ng-hide="{{token}}">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="../index.php">Untitled</a>
                        </div>
                        
                        

                        <div class="navbar-collapse collapse ">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="../index.php">Home</a></li>
                                <li><a href="../shop-views/shop.php#/">Shop</a></li>
                                <li><a href="../shop-views/shop.php#/cart">Cart</a></li>
                            </ul>
                        </div> <!-- navbar-collapse-->
                        

                       <div class="boton-box">
                                    <form action="users/templates/user.php#/signin">
                                        <input class="btn btn-theme"  type="submit" value="Login">
                                    </form>

                                    <form action="users/templates/user.php#/signup">
                                        <input class="btn btn-theme"  type="submit" value="Register">
                                    </form>
                        </div> 
                    </div>

                    <!-- Token exists-->
                    <div ng-show="{{token}}"> 
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="../index.php">Untitled</a>

                        </div>
                                         
                       
                        <div class="navbar-collapse collapse ">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="../index.php">Home</a></li>
                                <li><a href="../user-views/user.php#/user-profile">User Profile</a></li>
                                <li><a href="../shop-views/shop.php#/">Shop</a></li>
                                <li><a href="../shop-views/shop.php#/cart">Cart</a></li>
                            </ul>
                        </div> <!-- navbar-collapse-->
                        

                        <div class="boton-box">
                            <form  action="../user-views/user.php#/logout" ng-submit="logout()">
                                <input class="btn btn-theme"  type="submit" value="Logout">
                            </form>
                        </div> 
                    </div>
           
               
            </div>
        </div>
    </header>
    <!-- end header -->