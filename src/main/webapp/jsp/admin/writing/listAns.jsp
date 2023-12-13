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
</head>
<body>
<c:forEach var="ans" items="${anStudent}" varStatus="loop">
    Submissions
    <ul>
        <li>
            <c:choose>
                <c:when test="${ans.score == null}">
                    <a href="#" onclick="window.location.href='/admin/writing/result/${ans.id}'">Answer(${loop.index + 1}) : N/A</a>
                </c:when>
                <c:otherwise>
                    <a href="#" onclick="window.location.href='/admin/writing/result/${ans.id}'">Answer(${loop.index + 1})</a>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
</c:forEach>
</body>
</html>

</body>
</html>
