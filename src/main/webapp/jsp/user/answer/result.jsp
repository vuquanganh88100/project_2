<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- Add DataTables CSS and JavaScript -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>

    <script>
        $(document).ready(function () {
            $('#myTable').DataTable(); // Apply DataTables to your table with ID 'myTable'
        });
    </script>

</head>
<body>
<!-- Bảng hiển thị thông tin điểm số, bài kiểm tra, người chấm, và comment -->
<table>
    <thead>
    <tr>
        <th>Điểm</th>
        <th>Bài kiểm tra</th>
        <th>Kỹ năng</th>
        <th>Người chấm</th>
        <th>Comment</th>
    </tr>
    </thead>
    <tbody>
    <!-- Hiển thị thông tin của các bài kiểm tra loại 'reading' -->
    <c:forEach var="r" items="${reading}">
        <tr>
            <td>${r.score}</td>
            <td><a href="/ielts/result/reading/${r.id}">Bài số ${r.id}</a></td>
            <td>Reading</td>
            <td><!-- Người chấm --></td>
            <td><!-- Comment --></td>
        </tr>
    </c:forEach>

    <!-- Hiển thị thông tin của các bài kiểm tra loại 'writing' -->
    <c:forEach var="w" items="${writing}">
        <tr>
            <td>${w.score}</td>
            <td><a href="/ielts/result/writing/${w.id}">Bài số ${w.id}</a></td>
            <td>Writing</td>
            <!-- Thêm thông tin người chấm và comment nếu có -->
            <td>${w.marker.userName}</td>
            <td>${w.comment}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
<style>
    table {
        border-collapse: collapse;
        width: 90%; /* Độ rộng của bảng (90% của phần tử chứa bảng) */
        margin: auto; /* Căn giữa bảng */
    }


    th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    th {
        background-color: #f2f2f2;
    }

    /* Hover effect on rows */
    tr:hover {
        background-color: #f5f5f5;
    }
</style>
</style>
