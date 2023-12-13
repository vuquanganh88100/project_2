<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IELTS Writing Site</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

</head>
<body>
<nav>
    <!-- Navigation content -->
    <div class="clock" >

    </div>

    <!-- Clock display -->
</nav>

<!-- ... (previous HTML code) ... -->
<form action="/ielts/writing/save" method="post" >

<div class="container">
<div class="upper-left">
        <div class="task">
            <h2>Writing Task 1</h2>
            <!-- Content for Task 1 -->
            <p>${w.part1}</p>
            <img src="/images/${w.img}" alt="Image Description">
        </div>
        <p class="word-count">Word Count: <span id="wordCountTask1">0</span></p>
        <textarea id="textTask1" rows="10" cols="50" name="task1"></textarea>
    </div>

    <div class="upper-right">
        <div class="task">
            <h2>Writing Task 2</h2>
            <p>${w.part2}</p>
        </div>
        <p class="word-count">Word Count: <span id="wordCountTask2">0</span></p>
        <textarea id="textTask2" rows="10" cols="50" name="task2"></textarea>
    </div>

    <div class="lower-left">
        <!-- Content for Task 3 -->
        <!-- ... -->
    </div>

    <div class="lower-right">
        <!-- Content for Task 4 -->
        <!-- ... -->
    </div>
</div>
</div>
    <button id="submitBtn" style="display: block; margin: 20px auto;">Submit</button>
    <input type="hidden" name="testId" value="${testId}" />
    <input type="hidden" name="userId" value="${userId}" />

</form>

</body>
</html>
<script>
    // Đồng hồ đếm ngược từ 60 phút
    var minutes = 60;
    var seconds = 0;

    function countdown() {
        var display = document.querySelector('.clock');
        display.innerHTML ="Time Remaining "+ minutes + ":" + (seconds < 10 ? "0" : "") + seconds;

        if (seconds === 0) {
            if (minutes === 0) {
                clearInterval(interval);
                // Thực hiện hành động khi hết thời gian, ví dụ: hiển thị thông báo
                display.innerHTML = "Hết thời gian!";
            } else {
                minutes--;
                seconds = 59;
            }
        } else {
            seconds--;
        }
    }

    var interval = setInterval(countdown, 1000); // Cập nhật mỗi giây

</script>
<style>
    /* CSS Styles */
    /* CSS Styles */
    /* Style the layout as per your requirements */
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
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

    .clock {
        font-size: 18px;
        text-align: center;
        width: 100px;
        padding: 8px;
        border-radius: 5px;
        background-color: #555;
    }


    .container {
        max-width: 1200px;
        margin: 20px auto;
        display: flex;
        flex-direction: column;
        gap: 20px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    /* ... (previous CSS code) ... */

    .upper-left,
    .lower-left {
        flex: 1;
    }

    .upper-left .task,
    .lower-left .task,
    .upper-right .task{
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

    .upper-right,
    .lower-right {
        flex: 1;
        position: relative;
    }

    .upper-right .word-count,
    .lower-right .word-count {
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
<script>
    document.getElementById('textTask1').addEventListener('input', function() {
        var text = this.value;

        var words = text.trim().split(/\s+/);

        var wordCount = words.length > 0 && words[0] !== '' ? words.length : 0;

        document.getElementById('wordCountTask1').textContent = wordCount;
    });
    document.getElementById('textTask2').addEventListener('input', function() {
        var text = this.value;
        var words = text.trim().split(/\s+/);
        var wordCount = words.length > 0 && words[0] !== '' ? words.length : 0;
        document.getElementById('wordCountTask2').textContent = wordCount;
    });

</script>