<%-- 
    Document   : update-restaurant
    Created on : Oct 26, 2024, 3:19:25 AM
    Author     : SHD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
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
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="container mt-5">
            <h2>Update Restaurant</h2>

            <form action="update-restaurant" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${restaurant.id}">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" name="name" value="${restaurant.name}" required>
                </div>
                <div class="form-group">
                    <label for="image">Image URL:</label>
                    <input type="text" class="form-control" name="image" value="${restaurant.image}" required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control" name="address" value="${restaurant.address}" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" name="phone" value="${restaurant.phone}" required>
                </div>
                <div class="form-group">
                    <label for="detail">Detail:</label>
                    <textarea class="form-control" name="detail" required>${restaurant.detail}</textarea>
                </div>
                <div class="form-group">
                    <label for="category_id">Category:</label>
                    <select class="form-control" name="category_id" required>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.id}" <c:if test="${restaurant.cate_id == category.id}">selected</c:if>>${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="location_id">Location:</label>
                    <select class="form-control" name="location_id" required>
                        <c:forEach var="location" items="${locations}">
                            <option value="${location.id}" <c:if test="${restaurant.location_id== location.id}">selected</c:if>>${location.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
                <a href="list-restaurant" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
