<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Food List</title>
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
        <div class="container-fluid mt-5">
            <h2>Food List</h2>
            <a href="add-food?restaurant_id=${restaurant_id}" class="btn btn-primary">Add New Food</a>
            <table class="table mt-3 table-bordered table-hover">
    <thead class="thead-light">
        <tr>
            <th style="width: 14.29%;">ID</th>
            <th style="width: 14.29%;">Name</th>
            <th style="width: 14.29%;">Image</th>
            <th style="width: 14.29%;">Price</th>
            <th style="width: 14.29%;">Status</th>
            <th style="width: 14.29%;">Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="food" items="${foodList}">
            <tr>
                <td>${food.id}</td>
                <td>${food.name}</td>
                <td class="text-center"> <!-- Center alignment -->
                    <img src="${food.image}" alt="${food.name}" style="width: 100px; height: 100px; object-fit: cover;">
                </td>
                <td>${food.price}</td>
                <td>${food.status == 1 ? 'Available' : 'Unavailable'}</td>
                <td>
                    <a href="update-food?id=${food.id}&restaurant_id=${restaurant_id}" class="btn btn-warning">Edit</a>
                    <form action="update-food-status" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${food.id}">
                        <input type="hidden" name="restaurant_id" value="${restaurant_id}">
                        <input type="hidden" name="status" value="${food.status == 1 ? 0 : 1}">
                        <button type="submit" class="btn btn-secondary">${food.status == 1 ? 'Suspend' : 'Activate'}</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>