<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <!-- shop27:33-->
    <head>
        <meta charset="utf-8">
        <title>Review Restaurant</title>
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
        <%@include file="header.jsp" %>

        <div class="page-wrapper">
            <!-- Preloader -->
            <div class="preloader"></div>

            <!-- Main Header-->

            <!--End Page Title-->

            <!--Sidebar Page Container-->
            <div class="sidebar-page-container">
                <div class="auto-container">
                    <div class="row clearfix">

                        <!--Content Side-->
                        <div class="content-side col-xl-9 col-lg-8 col-md-12">
                            <div class="shop-single">
                                <div class="product-details">
                                    <div class="basic-details">
                                        <div class="row clearfix">
                                            <div class="image-column col-md-6 col-sm-12">
                                                <figure class="image-box"><a class="lightbox-image" title="Image Caption Here"><img src="${r.image}" alt=""></a></figure>
                                            </div>
                                            <div class="info-column col-md-6 col-sm-12">
                                                <div class="details-header">
                                                    <h4>${r.name}</h4>
                                                    <a class="reviews">Address : ${r.address}</a><br>
                                                    <c:if test="${r.numberComment > 0}">
                                                        <div class="rating">
                                                            <c:forEach begin="1" end="${r.rating}">
                                                                <span class="fa fa-star"></span>
                                                            </c:forEach>

                                                        </div>
                                                    </c:if>
                                                    <c:if test="${r.numberComment == 0}">
                                                        <div class="rating">
                                                            <span>0 Rating</span>

                                                        </div>
                                                    </c:if>

                                                    <a class="reviews" href="#">( ${r.numberComment}  Reviews )</a>
                                                </div>

                                                <div class="text">${r.detail}</div>

                                            </div>
                                        </div>
                                    </div>
                                    <!--Basic Details-->

                                    <!--Basic Details-->

                                    <!--Product Info Tabs-->
                                    <div class="product-info-tabs">
                                        <!--Product Tabs-->
                                        <div class="prod-tabs tabs-box">

                                            <!--Tab Btns-->
                                            <ul class="tab-btns tab-buttons clearfix">
                                                <li data-tab="#prod-reviews" class="tab-btn active-btn">Review</li>
                                            </ul>

                                            <!--Tabs Container-->
                                            <div class="tabs-content">

                                                <!--Tab-->
                                                <div class="tab active-tab" id="prod-reviews">
                                                    <h2 class="title">${r.numberComment} Reviews For ${r.name}</h2>
                                                    <c:if test="${r.numberComment > 0}">
                                                        <c:forEach var="i" items="${listR}">
                                                            <div class="comments-area style-two">
                                                                <!--Comment Box-->
                                                                <div class="comment-box">
                                                                    <div class="comment">
                                                                        <div class="author-thumb"><img src="${i.account.image}" alt=""></div>
                                                                        <div class="comment-inner">
                                                                            <div class="comment-info clearfix">${i.account.username} <span> &nbsp;Post: ${i.createDate}</span></div>
                                                                            <div class="rating">
                                                                                <c:forEach begin="1" end="${i.rating}">
                                                                                    <span class="fa fa-star"></span>
                                                                                </c:forEach>

                                                                            </div>
                                                                            <div class="text">${i.comment}</div>
                                                                            <c:if test="${sessionScope.account.id == i.account.id || sessionScope.account.role == 1}">
                                                                                <div><a onclick="openC(${i.id},'${i.comment}')">Edit</a> | <a href="main?action=remove-review-restaurant&id=${i.id}&re_id=${r.id}">Remove</a></div>
                                                                            </c:if>

                                                                        </div>
                                                                    </div>
                                                                </div>



                                                            </div>
                                                            <div class="shop-comment-form mb-3" id="${i.id}" style="display: none;"> 
                                                                <form method="post" action="main">
                                                                    <input type="hidden" value="edit-review-restaurant" name="action">
                                                                    <input type="hidden" value="${r.id}" name="re_id">
                                                                    <input type="hidden" value="${i.id}" name="id">
                                                                    <div class="form-group">
                                                                        <label>Your Review*</label>
                                                                        <textarea name="content" id="${i.id}_comment" required></textarea>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label>Rating</label>
                                                                        <input type="number" min="1" class="text-center" name="rating" max="5" required placeholder="1">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <button class="theme-btn btn-style-one" type="submit" name="submit-form">UPDATE</button>
                                                                        <button class="theme-btn btn-style-one" type="button" onclick="document.getElementById(${i.id}).style.display = 'none'" name="submit-form">CANCEL</button>
                                                                    </div>
                                                                </form>  
                                                            </div>

                                                        </c:forEach>

                                                    </c:if>
                                                    <!--Reviews Container-->


                                                    <!-- Comment Form -->
                                                    <div class="shop-comment-form"> 
                                                        <form method="post" action="main">
                                                            <input type="hidden" value="add-review-restaurant" name="action">
                                                            <input type="hidden" value="${r.id}" name="id">
                                                            <div class="form-group">
                                                                <label>Your Review*</label>
                                                                <textarea name="content" required></textarea>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Rating</label>
                                                                <input type="number" min="1" class="text-center" name="rating" max="5" required placeholder="1">
                                                            </div>
                                                            <div class="form-group">
                                                                <button class="theme-btn btn-style-one" type="submit" name="submit-form">ADD</button>

                                                            </div>
                                                        </form> 
                                                    </div>
                                                </div>  
                                            </div>
                                        </div>
                                    </div>
                                    <!--End Product Info Tabs-->
                                </div>
                            </div>
                        </div>


                        <!--Sidebar Side-->
                        <div class="sidebar-side col-xl-3 col-lg-4 col-md-12">
                            <aside class="sidebar">

                                <!-- Search -->

                                <!-- Top Related Posts -->
                                <div class="sidebar-widget related-posts">
                                    <div class="sidebar-title">
                                        <h2>Food of Restaurant</h2>
                                        <div class="separater"></div>
                                    </div>
                                    <c:forEach var="i" items="${listF}">
                                        <div class="post">
                                            <figure class="post-thumb"><a href="main?action=detail-food&id=${i.id}"><img src="${i.image}" alt=""></a></figure>
                                            <h4><a href="main?action=detail-food&id=${i.id}">${i.name}</a></h4>
                                            <div class="rating"><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span></div>
                                            <div class="price">${i.price}.000 VND</div>
                                        </div>
                                    </c:forEach>


                                </div>  
                            </aside>
                        </div>
                    </div>
                </div>
            </div>
            <!--End Sidebar Page Container-->

            <!-- Main Footer -->
            <%@include file="footer.jsp" %>
            <!-- End Main Footer -->

        </div>
            <script>
                
                function openC(id,value){
                    document.getElementById(id).style.display = 'block';
                    document.getElementById(id+'_comment').value = value;
                    
                }
            </script>


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

    <!-- shop27:38-->
</html>