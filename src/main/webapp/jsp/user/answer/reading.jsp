<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- Include jQuery -->

<style>
    /* General styles */
    body {
        font-family: Arial, sans-serif;
        line-height: 1.6;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }

    .container {
        max-width: 800px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    /* Styles for 'De bai' */
    h3 {
        font-size: 24px;
        color: #333;
        margin-bottom: 15px;
    }

    /* Styles for 'Question' */
    p {
        font-size: 18px;
        color: #666;
        margin-bottom: 10px;
    }

    /* Styles for input boxes */
    input[type="text"] {
        padding: 10px;
        width: calc(100% - 22px);
        border: 1px solid #ccc;
        border-radius: 4px;
        margin-bottom: 15px;
    }

    /* Styles for options */
    label {
        display: block;
        margin-bottom: 8px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="radio"] {
        display: inline-block;
        margin-right: 8px;
        cursor: pointer;
    }

    /* Styles for passages */
    .passage {
        margin-bottom: 20px;
        border: 1px solid #ccc;
        padding: 15px;
        border-radius: 4px;
        background-color: #f9f9f9;
    }

    .passage h2 {
        font-size: 22px;
        margin-bottom: 10px;
    }


</style>
<form action="/ielts/reading/submit" method="post" modelAttribute="answer">
<%
    for (int index = 1; index <= 3; index++) {
        out.print("<h2>Passage:" + index + "</h2>");
        out.print(request.getAttribute("passage" + index));
        out.println("<br>");
        out.print(request.getAttribute("output" + index));
        out.println("<br>");
    }
%>
    <input type="hidden" name="test_id" value="${examId}">
    <input type="hidden" name="userId" value="${userId}">

    <button type="submit">Submit Answers</button>
</form>
<script>
    var selectedAnswers = [];
    function submitAnswers() {
        var formData = {};

        $("input[type='radio']:checked, input[type='text']").each(function() {
            var questionIndex = $(this).data('questionindex');
            var inputName = $(this).attr('name');
            var inputValue = $(this).val();

            if (!formData.hasOwnProperty(inputName)) {
                formData[inputName] = {};
            }

            formData[inputName][questionIndex] = inputValue;
        });

        $.ajax({
            url: '/ielts/reading/submit',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                alert('Answers submitted successfully');
            },
            error: function() {
                alert('Error submitting answers');
            }
        });
    }




    // Update function to capture selected answers
    $(document).ready(function() {
        $("input[type='radio']").change(function() {
            var questionIndex = $(this).data('questionindex');
            var selectedOption = $(this).val();
            selectedAnswers[questionIndex] = selectedOption;

            console.log("Question Index: " + questionIndex);
            console.log("Selected Value: " + selectedOption);
        });

        $("input[type='text']").change(function() {
            var questionIndex = $(this).data('questionindex');
            var enteredText = $(this).val();
            selectedAnswers[questionIndex] = enteredText;
            console.log("Question Index: " + questionIndex);
            console.log("Selected Value: " + enteredText);
        });
    });



</script>