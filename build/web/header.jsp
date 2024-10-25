<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="main-header header-style-four">

    <div class="header-lower">
        <div class="auto-container">
            <div class="main-box clearfix">
                <div class="logo-box">
                    <div class="logo"><a href="main"><img style="width: 100px;height: 100px;border-radius: 20px" src="images/download (1).jpg" alt="" title=""></a></div>
                </div>

                <div class="nav-outer">
                    <!-- Main Menu -->
                    <nav class="main-menu navbar-expand-md ">
                        <div class="navbar-header">
                            <!-- Toggle Button -->      
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="icon flaticon-menu-button"></span>
                            </button>
                        </div>

                        <div class="collapse navbar-collapse clearfix" id="navbarSupportedContent">
                            <ul class="navigation clearfix">
                                <li class="dropdown"><a href="main">Review</a></li>
                                <c:if test="${sessionScope.account.role == 1}">
                                 <li class="dropdown"><a href="list-account">Account Management</a></li>
                                </c:if>
                                  <c:if test="${sessionScope.account.role == 2}">
                                 <li class="dropdown"><a href="list-restaurant">Restaurant Management</a></li>
                                </c:if>
                                <c:if test="${sessionScope.account == null}">
                                   
                                    <li class="dropdown"><a href="main?action=login">Login</a></li> 
                                </c:if>
                                <c:if test="${sessionScope.account != null}">
                                 <li class="dropdown"><a href="#">Profile</a></li>
                                    <li class="dropdown"><a href="main?action=logout">Logout</a></li>
                                </c:if>

                                

                            </ul> 
                        </div>
                    </nav><!-- Main Menu End-->                        

                    <!-- Outer Box-->

                </div>
            </div>
        </div>
    </div>
</header>
<!--End Main Header -->

<!--Page Title-->
<section class="page-title" style="background-image:url(images/R.jpg);">
    <div class="auto-container">
        <div class="inner-container clearfix">
            <div class="title-box">
                <h1>OTID</h1>
                <span class="title">OUR TASTE - OUR IDENTITY</span>
                <span class="title">Review & Rating</span>
            </div>
        </div>
    </div>
</section>