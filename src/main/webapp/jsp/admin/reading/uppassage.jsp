<%@page pageEncoding="utf-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
</head>
<body>

<h3>Passage</h3>
<div class="container">
    <form id="passageForm" action="/admin/reading/save" method="post"enctype="multipart/form-data" >
        <input type="hidden" name="id" />

        <label for="passage1">Passage 1</label>
        <textarea id="passage1" name="passage1" placeholder="Write something.." style="height:200px"></textarea>

        <label for="passage2" style="display: none;">Passage 2</label>
        <textarea id="passage2" name="passage2" placeholder="Write something.." style="height:200px" style="display: none;"></textarea>

        <label for="passage3" style="display: none;">Passage 3</label>
        <textarea id="passage3" name="passage3" placeholder="Write something.." style="height:200px" style="display: none;"></textarea>
        <input type="hidden" name="id" value="${passage.id}" />
        <div class="mb-3">
            <label for="formFile" class="form-label">Default file input example</label>
            <input class="form-control" type="file" id="formFile" name="file">
        </div>
        <input type="submit" id="submitBtn" value="Submit">


    </form>
</div>


</body>
</html>
<script>
    document.getElementById("passageForm").addEventListener("submit", function(event) {
        var passage1 = document.getElementById("passage1").value;
        var convertedPassage1 = passage1.replace(/\\n/g, String.fromCharCode(10));
        document.getElementById("passage1").value = convertedPassage1;

        // Tương tự, bạn có thể thực hiện tương tự cho các textarea khác (passage2, passage3) nếu cần thiết

        // Tiếp tục submit form
        // event.preventDefault(); // Bỏ comment dòng này nếu bạn muốn ngăn chặn form submit để kiểm tra trước khi gửi dữ liệu
        // this.submit();
    });
</script>
