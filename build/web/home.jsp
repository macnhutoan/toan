<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Review Restaurant</title>
        <!-- Stylesheets -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link href="css/color-switcher-design.css" rel="stylesheet">
        <link id="theme-color-file" href="css/color-themes/default-theme.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
        <link rel="icon" href="images/favicon.png" type="image/x-icon">
        <!-- Responsive -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    </head>

    <body>
        <%@include file="header.jsp" %>

        <div class="page-wrapper">
            <!-- Preloader -->
            <div class="preloader"></div>

            <!--Sidebar Page Container-->
            <div class="sidebar-page-container">
                <div class="auto-container">
                    <div class="row clearfix">
                        <!--Content Side-->
                        <div class="content-side col-xl-12 col-lg-12 col-md-12">
                            <div class="our-shop">
                                <form action="main" method="GET">
                                    <input type="hidden" name="action" value="home"/>
                                    <div class="row clearfix">
                                        <!-- Category Filter -->
                                        <div class="col-lg-4 col-md-6 col-sm-12">
                                            <select name="cate_id" class="form-control">
                                                <option value="">All Categories</option>
                                                <c:forEach var="c" items="${listC}">
                                                    <option value="${c.id}" ${c.id == param.cate_id ? "selected" : ""}>${c.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <!-- Location Filter -->
                                        <div class="col-lg-4 col-md-6 col-sm-12">
                                            <select name="location_id" class="form-control">
                                                <option value="">All Locations</option>
                                                <c:forEach var="l" items="${listL}">
                                                    <option value="${l.id}" ${l.id == param.location_id ? "selected" : ""}>${l.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <!-- Search Bar -->
                                        <div class="col-lg-4 col-md-6 col-sm-12">
                                            <input type="text" name="search" value="${param.search}" class="form-control" placeholder="Search by name">
                                        </div>
                                    </div>
                                    <!-- Filter Button -->
                                    <div class="row clearfix">
                                        <div class="col-lg-12 col-md-12 col-sm-12 mt-3">
                                            <button type="submit" class="btn btn-primary">Filter</button>
                                        </div>
                                    </div>
                                </form>

                                <div class="row clearfix mt-4">
                                    <c:forEach var="r" items="${listR}">
                                        <div class="shop-item col-xl-4 col-lg-6 col-md-6 col-sm-12">
                                            <div class="inner-box">
                                                <div class="image">
                                                    <img style="width: 300px;height: 300px" src="${r.image}" alt="" />
                                                    <div class="overlay-box">
                                                        <ul class="cart-option">
                                                            <li><a href="main?action=detail&id=${r.id}"><span class="fa fa-link"></span></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="lower-content">
                                                    <h3><a href="main?action=detail&id=${r.id}">${r.name}</a></h3>
                                                    <div class="price">${r.category.name}</div>
                                                    <div class="clearfix">
                                                        <div class="pull-left">
                                                            <a class="add-cart" href="main?action=detail&id=${r.id}">Review</a>
                                                        </div>
                                                        <div class="pull-right">
                                                            <div class="rating">
                                                                <c:if test="${r.rating > 0}">
                                                                    <c:forEach begin="1" end="${r.rating}">
                                                                        <span class="fa fa-star"></span>
                                                                    </c:forEach>
                                                                </c:if>
                                                                <c:if test="${r.rating == 0}">
                                                                    <span>No Rating</span>
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>

                                <!-- Pagination -->
                                <c:if test="${noPaging == null}">
                                    <div class="styled-pagination">
                                        <ul class="clearfix">
                                            <c:forEach var="i" begin="1" end="${totalPage}">
                                                <li class="${i == page ? "active" : ""}">
                                                    <a href="main?action=home&page=${i}&cate_id=${param.cate_id}&location_id=${param.location_id}&search=${param.search}">${i}</a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>

            <%@include file="footer.jsp" %>
        </div>

        <!--Scroll to top-->
        <div class="scroll-to-top scroll-to-target" data-target="html"><span class="fa fa-arrow-circle-o-up"></span></div>
        <script src="js/jquery.js"></script> 
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.fancybox.js"></script>
        <script src="js/jquery-ui.js"></script> 
        <script src="js/owl.js"></script>
        <script src="js/wow.js"></script>
        <script src="js/appear.js"></script>
        <script src="js/script.js"></script>
        <!-- Color Setting -->
        <script src="js/color-settings.js"></script>
    </body>
</html>