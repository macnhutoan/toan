<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Add Restaurant</title>
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
        <%@include file="header.jsp" %>
        <div class="container mt-5">
            <h2>Add Restaurant</h2>

            <form action="add-restaurant" method="post">
                <input type="hidden" name="action" value="add">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" name="name" required>
                </div>
                <div class="form-group">
                    <label for="image">Image URL:</label>
                    <input type="text" class="form-control" name="image" required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control" name="address" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text" class="form-control" name="phone" required>
                </div>
                <div class="form-group">
                    <label for="detail">Detail:</label>
                    <textarea class="form-control" name="detail" required></textarea>
                </div>
                <div class="form-group">
                    <label for="category_id">Category:</label>
                    <select class="form-control" name="category_id" required>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="location_id">Location:</label>
                    <select class="form-control" name="location_id" required>
                        <c:forEach var="location" items="${locations}">
                            <option value="${location.id}">${location.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
                <a href="list-restaurant" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>