<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách bài kiểm tra Reading IELTS</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<jsp:include page="/jsp/user/nav.jsp"></jsp:include>

<h1 style="margin-top:50px">Danh sách bài kiểm tra Reading IELTS</h1>

<table>

    <c:forEach var="test" items="${testReading}">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/ielts/reading/practice/exam/${test.id}">
                    Bài kiểm tra số ${test.id}
                </a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }

    h1 {
        color: #333;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

</style>