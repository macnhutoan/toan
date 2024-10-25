<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Owner's Restaurant List</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <style>
            /* Set a fixed size for all restaurant images */
            .restaurant-image {
                width: 100px;
                height: 100px;
                object-fit: cover;
            }
        </style>
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <div class="container-fluid mt-5 mb-3">
            <h2>My Restaurants</h2>
            <a href="add-restaurant" class="btn btn-primary">Add New Restaurant</a>

            <!-- Restaurant list table -->
            <table class="table table-bordered table-hover">
                <thead class="thead-light">
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="restaurant" items="${restaurantList}">
                        <tr>
                            <td>
                                <img src="${restaurant.image}" alt="${restaurant.name}" class="restaurant-image">
                            </td>
                            <td>${restaurant.name}</td>
                            <td>${restaurant.address}</td>
                            <td>${restaurant.phone}</td>
                            <td>
                                <a href="list-foods?restaurant_id=${restaurant.id}" class="btn btn-primary btn-sm">View Details</a>
                                <a href="update-restaurant?id=${restaurant.id}" class="btn btn-warning">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <nav>
                    <ul class="pagination justify-content-center">
                        <c:if test="${currentPage > 1}">
                            <li class="page-item">
                                <a class="page-link" href="list-restaurant?page=${currentPage - 1}">Previous</a>
                            </li>
                        </c:if>

                        <c:forEach begin="1" end="${totalPages}" var="i">
                            <li class="page-item ${i == currentPage ? 'active' : ''}">
                                <a class="page-link" href="list-restaurant?page=${i}">${i}</a>
                            </li>
                        </c:forEach>

                        <c:if test="${currentPage < totalPages}">
                            <li class="page-item">
                                <a class="page-link" href="list-restaurant?page=${currentPage + 1}">Next</a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </table>

            <!-- Pagination controls -->

        </div>

        <%@ include file="footer.jsp" %>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>