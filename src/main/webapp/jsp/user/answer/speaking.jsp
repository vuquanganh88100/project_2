<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .task {
            text-align: center;
            margin: 20px;
        }

        p {
            margin-bottom: 10px;
        }

        img {
            max-width: 100%;
            height: auto;
            margin-top: 10px;
        }

        button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="file"] {
            display: none;
        }

        label {
            display: block;
            background-color: #3498db;
            color: white;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<form method="post" action="/ielts/speaking/save" enctype="multipart/form-data">

<div class="task">
    <p>${s.content}</p>
    <img src="/images/${s.img}">
    <input type="file" class="form-control" id="audioFile" name="audioFile" accept="audio/m4a" required>
    <label for="audioFile">File</label>
    <button id="submitBtn" style="display: block; margin: 20px auto;">Submit</button>

    <input type="hidden" name="testId" value="${testId}" />
    <input type="hidden" name="userId" value="${userId}" />
</div>
</form>
</body>
</html>
