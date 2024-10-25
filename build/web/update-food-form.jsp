<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Update Food Item</title>
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
            <h2>Update Food Item</h2>
            <form action="update-food" method="post">
                <input type="hidden" name="id" value="${food.id}">
                <input type="hidden" name="restaurant_id" value="${restaurant_id}">
                <div class="form-group">
                    <label for="name">Food Name:</label>
                    <input type="text" class="form-control" id="name" name="name" value="${food.name}" required>
                </div>
                <div class="form-group">
                    <label for="image">Image URL:</label>
                    <input type="text" class="form-control" id="image" name="image" value="${food.image}" required>
                </div>
                <div class="form-group">
                    <label for="detail">Details:</label>
                    <textarea class="form-control" id="detail" name="detail" required>${food.detail}</textarea>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" class="form-control" id="price" name="price" value="${food.price}" required>
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <select class="form-control" id="status" name="status" required>
                        <option value="1" <c:if test="${food.status == 1}">selected</c:if>>Available</option>
                        <option value="0" <c:if test="${food.status == 0}">selected</c:if>>Unavailable</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Update Food</button>
                </form>
            </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>