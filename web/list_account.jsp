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
        <script>
            // Function to hide the message after 2 seconds (2000 milliseconds)
            function hideMessage() {
                const messageElement = document.getElementById("messageAlert");
                if (messageElement) {
                    setTimeout(function () {
                        messageElement.style.display = 'none';
                    }, 2000); // 2000 milliseconds = 2 seconds
                }
            }
        </script>
    </head>

    <body onload="hideMessage()"> 
        <%@include file="header.jsp" %>

        <div class="container-fluid mt-5 mb-3">
            <h2>Account List</h2>

            <!-- Error or success messages -->
            <c:if test="${not empty message}">
                <div id="messageAlert" class="alert alert-success">${message}</div>
            </c:if>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Fullname</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>Role</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="account" items="${accountList}">
                        <tr>
                            <td>${account.id}</td>
                            <td>${account.username}</td>
                            <td>${account.fullname}</td>
                            <td>${account.phone}</td>
                            <td>${account.address}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${account.role == 0}">Customer</c:when>
                                    <c:when test="${account.role == 2}">Owner</c:when>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${account.status == 1}">Active</c:when>
                                    <c:when test="${account.status == 0}">Inactive</c:when>
                                </c:choose>
                            </td>
                            <td>
                                <!-- Button to toggle account status -->
                                <form action="list-account" method="post">
                                    <input type="hidden" name="accountId" value="${account.id}">
                                    <button class="btn btn-primary" type="submit">
                                        Toggle Status
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!--End Sidebar Page Container-->

        <!-- Main Footer -->
        <%@include file="footer.jsp" %>
        <!-- End Main Footer -->




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