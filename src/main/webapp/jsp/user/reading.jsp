<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h1 style="color: aqua; font-size: large;" >IELTS Academic Reading
</h1>

<ul>
    <c:forEach var="passage" items="${passages}">
        <li>
            <a href="">IELTS Academic Reading test ${passage.id} (40 questions)</a>

        </li>
    </c:forEach>
</ul>



</p>
</body>
</html>