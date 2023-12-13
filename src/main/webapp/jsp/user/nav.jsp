<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Ielts tests</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link href="home.css" rel="stylesheet">
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal">Company name</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="#">Home</a> <!-- Thêm Home link -->
        <a class="p-2 text-dark" href="#">Features</a>
        <a class="p-2 text-dark" href="#">Enterprise</a>
        <a class="p-2 text-dark" href="#">Support</a>
        <a class="p-2 text-dark" href="#">Blog</a> <!-- Thêm Blog link -->
    </nav>
    <sec:authorize access="!isAuthenticated()">
    <div class="ml-md-auto">
        <a class="btn btn-outline-primary mr-2" href="/ielts/login">Login</a>
        <a class="btn btn-outline-primary" href="/ielts/signup">Sign up</a>
    </div>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <div class="nav-item dropdown">
            <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle mr-4" aria-expanded="false">${fn:substring(pageContext.request.userPrincipal.name, 0, 3)}</a>
            <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown1111">
                <li><a class="dropdown-item" href="/backend/user/change-pass">Đổi mật khẩu</a></li>
                <li><a class="dropdown-item" href="/ielts/result">Thông tin tài khoản</a></li>
                <li><a class="dropdown-item" href="/ielts/logout">Đăng xuất</a></li>
            </ul>
        </div>
    </sec:authorize>
</div>

</body>
</html>
<style>
    /* Apply styles to the navigation bar */
    .navbar {
        background-color: #f8f9fa; /* Light gray background */
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Add a subtle box-shadow for depth */
    }

    /* Style the navigation links */
    .navbar-nav a {
        color: #343a40; /* Dark text color */
        margin: 0 10px;
        text-decoration: none;
        font-weight: bold;
    }

    /* Change color of links on hover */
    .navbar-nav a:hover {
        color: #007bff; /* Primary color on hover */
    }

    /* Style the login/signup buttons */
    .btn-outline-primary {
        border-color: #007bff; /* Primary color border */
        color: #007bff; /* Primary color text */
    }

    .btn-outline-primary:hover {
        background-color: #007bff; /* Primary color background on hover */
        color: #fff; /* White text on hover */
    }

    /* Style the user dropdown */
    .nav-item.dropdown {
        position: relative;
    }

    .nav-item.dropdown a.dropdown-toggle::after {
        display: inline-block;
        margin-left: 5px;
        vertical-align: middle;
        content: "\25BC"; /* Down arrow character */
    }

    /* Style the user dropdown menu */
    .dropdown-menu {
        border-radius: 0;
    }

    .dropdown-menu a {
        color: #343a40; /* Dark text color */
    }

    .dropdown-menu a:hover {
        background-color: #f8f9fa; /* Light gray background on hover */
        color: #007bff; /* Primary color text on hover */
    }

</style>