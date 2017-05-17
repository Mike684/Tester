/**
 * Created by Mike on 14.05.2017.
 */
$(document).ready(function create(){
    $("#bAdd").click(function(){
        var theme = $("#theme").val();
        $.ajax({
            type: "POST",
            url: "create_qz",
            data: 'theme='+encodeURIComponent(theme),
            success: function(response) {

                var quiz = jQuery.parseJSON(response);

                var append = "<tr id='"+quiz.quizID+"'>"+
                    "<td><p id='qzTheme'>"+theme+"</p></td>" +
                    "<td><input class='btn btn-warning' type='submit'  name='editQz' value='Edit' id='edit"+quiz.quizID+"'/></td>" +
                    "<td><input class='btn btn-danger' type='submit'"+
                    " name='deleteQuiz' value='Delete' id='"+quiz.quizID+"'/></td></tr>";
                $('#quizTable').append(append);

                $("input:text").val(null);

                $('#edit'+quiz.quizID).click(function () {
                    window.location="questions?id="+quiz.quizID;
                });
                $('#delete'+quiz.quizID).click(function () {
                    delQz(quiz.quizID);
                });
            }
        });
    });
});