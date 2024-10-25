<!DOCTYPE html>
<html lang="en">

    <!-- login27:42-->
    <head>
        <meta charset="utf-8">
        <title>Login Page</title>
        <!-- Stylesheets -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">   
        <!--Color Switcher Mockup-->
        <link href="css/color-switcher-design.css" rel="stylesheet">
        <!--Color Themes-->
        <link id="theme-color-file" href="css/color-themes/default-theme.css" rel="stylesheet">

        <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
        <link rel="icon" href="images/favicon.png" type="image/x-icon">
        <!-- Responsive -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script><![endif]-->
        <!--[if lt IE 9]><script src="js/respond.js"></script><![endif]-->
    </head>

    <body>

        <div class="page-wrapper">
            <!-- Preloader -->
            <div class="preloader"></div>

            <!-- Main Header-->
            <%@include file="header.jsp" %>

            <!--Login Section-->
            <section class="login-section">
                <div class="auto-container">
                    <div class="row clearfix">
                        <div class="column col-lg-6 col-md-12 col-sm-12">
                            <span style="color: red">${error}</span>
                            <h2>Login</h2>

                            <!-- Login Form -->
                            <div class="login-form">
                                <!--Login Form-->
                                <form method="post" action="main">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input type="text" name="username"  required>
                                    </div>

                                    <div class="form-group">
                                        <label>Enter Your Password</label>
                                        <input type="password" name="password"  required>
                                    </div>
                                    <input type="hidden" name="action" value="login"  required>
                                    <div class="clearfix">

                                        <div class="pull-right">
                                            <div class="form-group no-margin">
                                                <button class="theme-btn btn-style-one" type="submit" name="submit-form">LOGIN</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!--End Login Form -->
                        </div>

                        <div class="column col-lg-6 col-md-12 col-sm-12">
                            <h2>Register</h2>
                            <span style="color: red">${errorRegis}</span>
                            <span style="color: green">${successRegis}</span>
                            <!-- Register Form -->
                            <div class="login-form register-form">
                                <!--Register Form-->
                                <form method="post" action="register">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input type="text" name="username" placeholder="Your Username" required>
                                    </div>

                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" name="password" placeholder="Enter Password" required>
                                    </div>

                                    <div class="form-group">
                                        <label>Full Name</label>
                                        <input type="text" name="fullname" placeholder="Full Name" required>
                                    </div>

                                    <div class="form-group">
                                        <label>Phone</label>
                                        <input type="text" name="phone" placeholder="Phone Number" required>
                                    </div>

                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" name="address" placeholder="Your Address" required>
                                    </div>

                                    <div class="form-group text-right">
                                        <button class="theme-btn btn-style-one" type="submit" name="submit-form">Register</button>
                                    </div>
                                </form>      
                            </div>
                            <!--End Register Form -->
                        </div>
                    </div>
                </div>
            </section>
            <!--End Login Section-->

            <!-- Main Footer -->
            <%@include file="footer.jsp" %>
            <!-- End Main Footer -->

        </div>



        <!--Scroll to top-->
        <div class="scroll-to-top scroll-to-target" data-target="html"><span class="fa fa-arrow-circle-o-up"></span></div>
        <script src="js/jquery.js"></script> 
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.fancybox.js"></script>
        <script src="js/owl.js"></script>
        <script src="js/wow.js"></script>
        <script src="js/appear.js"></script>
        <script src="js/mixitup.js"></script>
        <script src="js/script.js"></script>
        <!-- Color Setting -->
        <script src="js/color-settings.js"></script>
    </body>

    <!-- login27:42-->
</html>