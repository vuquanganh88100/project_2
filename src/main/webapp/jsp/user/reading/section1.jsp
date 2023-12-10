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
<h2>
    READING PASSAGE 1
    <break></break>
    You should spend about 20 minutes on Questions 1–13, which are based on Reading Passage 1 below.
</h2>
<!-- Display passage1 outside the loop -->
<div>${passage1s}</div>

<ul>
    <c:forEach items="${contents}" var="content" varStatus="loop">
        <li>
            <div>${content}</div>
            <div>${types[loop.index]}</div>
        </li>
    </c:forEach>
</ul>



</body>
</html>