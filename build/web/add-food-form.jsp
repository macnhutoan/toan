<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Add Food Item</title>
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
            <h2>Add New Food Item</h2>
            <form action="add-food" method="post">
                <input type="hidden" name="restaurant_id" value="${restaurant_id}">
                <div class="form-group">
                    <label for="name">Food Name:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="image">Image URL:</label>
                    <input type="text" class="form-control" id="image" name="image" required>
                </div>
                <div class="form-group">
                    <label for="detail">Details:</label>
                    <textarea class="form-control" id="detail" name="detail" required></textarea>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" class="form-control" id="price" name="price" required>
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <select class="form-control" id="status" name="status" required>
                        <option value="1">Available</option>
                        <option value="0">Unavailable</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Add Food</button>
                <a href="list-foods?restaurant_id=${restaurant_id}" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
            <%@ include file="footer.jsp" %>
    </body>
</html>