<%@page pageEncoding="utf-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Page Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            max-width: 800px; /* Điều chỉnh giá trị này tùy thuộc vào kích thước mong muốn */
            margin: 20px auto;
        }

        p {
            width: 100%;
            box-sizing: border-box;
            padding: 10px;
            border: 1px solid #ccc;
            margin-bottom: 10px;
        }

        img {
            width: 100%;
            max-width: 100%;
            height: auto;
            border: 1px solid #ccc;
            margin-bottom: 10px;
        }

        .teacher {
            width: 48%; /* 48% để giữ cho mỗi phần chiếm 50%, bạn có thể điều chỉnh nếu cần */
        }

        audio {
            width: 100%;
        }

        textarea {
            width: 100%;
            box-sizing: border-box;
            padding: 5px;
            margin-bottom: 10px;
        }

        #submitBtn {
            display: block;
            margin: 20px auto;
        }
    </style>
</head>
<body>
<form action="/admin/speaking/score" method="post">
    <div class="container">
        <p>${s.content}</p>
        <img src="/images/${s.img}">
        <div class="teacher">
            <audio controls>
                <source src="/audio/${answer.audio}" type="audio/mp4">
            </audio>
            FEED back from teacher
            <c:if test="${answer.score==null}">
                Comment
                <textarea id="comment" rows="20" cols="50" name="comment"></textarea>
                Score
                <textarea id="score" rows="5" cols="50" name="score"></textarea>
            </c:if>
            <c:if test="${answer.score!=null}">
                Comment
                <textarea id="comment" rows="20" cols="50" readonly>${answer.comment}</textarea>
                Score
                <textarea id="score" rows="5" cols="50" readonly>${answer.score}</textarea>
            </c:if>
        </div>
    </div>
    <c:if test="${answer.score==null}">
        <button id="submitBtn">Submit</button>
    </c:if>
    <c:if test="${answer.score!=null}">
        <input type="hidden">
    </c:if>
    <input type="hidden" name="markerId" value="${markerId}" />
    <input type="hidden" name="ansId" value="${ansId}" />
</form>
</body>
</html>
