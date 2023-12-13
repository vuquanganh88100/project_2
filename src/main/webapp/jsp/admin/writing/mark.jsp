<%@page pageEncoding="utf-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IELTS Writing Site</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

</head>
<body>

<form action="/admin/writing/score" method="post" >

<div class="container">
    <div class="student" style="border-color: #17a2b8">
        <div class="upper-left">
            <div class="task">
                <h2>Writing Task 1</h2>
                <!-- Content for Task 1 -->
                <p>${w.part1}</p>
                <img src="/images/${w.img}" alt="Image Description" width="724" height="485">
            </div>
            <p class="word-count">Word Count: <span id="wordCountTask1">${cnt1}</span></p>
            <textarea id="textTask1" rows="10" cols="50" readonly>${answer.task1}</textarea>
        </div>

        <div class="lower-left">
            <div class="task">
                <h2>Writing Task 2</h2>
                <p>${w.part2}</p>
            </div>
            <p class="word-count">Word Count: <span id="wordCountTask2">${cnt2}</span></p>
            <textarea id="textTask2" rows="10" cols="50" readonly> ${answer.task2}</textarea>
        </div>
    </div>
    <div class="teacher">
        FEED back from teacher
        <div class="right">
            <c:if test="${answer.score==null}">
                Comment
                <textarea id="comment" rows="20" cols="50" name="comment" ></textarea>
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


</div>
</div>
    <c:if test="${answer.score==null}"><button id="submitBtn" style="display: block; margin: 20px auto;">Submit</button>
    </c:if>
    <c:if test="${answer.score!=null}"> <input type="hidden">
    </c:if>
<input type="hidden" name="markerId" value="${markerId}" />
<input type="hidden" name="ansId" value="${ansId}" />

</form>

</body>
</html>
<style>
    /* CSS Styles */
    /* CSS Styles */
    /* Style the layout as per your requirements */
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f8f8f8;
    }

    nav {
        background-color: #333;
        color: #fff;
        padding: 10px;
        position: relative;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }




    .container {
        background-color: #fff;

        max-width: 1200px;
        margin: 20px auto;
        display: flex;
        flex-direction: column;
        gap: 20px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        display: flex;
        flex-direction: row; /* Displaying the sections side by side */
        justify-content: space-between; /
    }
    .container:hover {
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.2); /* Adding a subtle shadow on hover */
    }
    .student {
        /* ... (your existing styles) ... */
        flex: 1; /* Occupy available space */
    }

    .teacher {
        /* ... (your existing styles) ... */
        display: flex;
        flex-direction: column;

    }
    .upper-left,
    .lower-left {
        flex: 1;
    }

    .upper-left .task,
    .lower-left .task,
    .lower-left .task{
        background-color: #f5f5f5;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }

    .upper-left .task h2,
    .lower-left .task h2 {
        margin-bottom: 10px;
        font-size: 18px;
    }

    .lower-left,
    .upper-left {
        flex: 1;
        position: relative;
    }

    .lower-left .word-count,
    .upper-left .word-count {
        position: absolute;
        bottom: 10px;
        right: 10px;
        font-size: 14px;
        color: #666;
    }

    textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    /* Style for word count box */
    .word-count span {
        font-weight: bold;
    }

    /* Style for hover effect on task areas */
    .task:hover {
        background-color: #e0e0e0;
        transition: background-color 0.3s ease;
    }
    #submitBtn {
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 5px;
        background-color: #4CAF50;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    #submitBtn:hover {
        background-color: #45a049;
    }

</style>
