<%@page pageEncoding="utf-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog Upload Form</title>
    <!-- Add Bootstrap CSS link -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>Speaking</h2>
    <form action="/admin/speaking/post" method="post" enctype="multipart/form-data" >
        <div class="form-group">
            <label for="content">Speaking task 2</label>
            <textarea class="form-control" id="content" name="content" rows="6" required></textarea>
        </div>
        <div class="form-group">
            <label for="imgFile">Upload Featured Image of task 2</label>
            <input type="file" class="form-control-file" id="imgFile" name="imgFile"  required>
        </div>
        <button type="submit" class="btn btn-primary">Upload content</button>
        <input type="hidden" name="userId" value="${userId}" />

    </form>
</div>

<!-- Add Bootstrap JS and jQuery links (optional) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>



