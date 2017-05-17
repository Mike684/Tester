/**
 * Created by Mike on 12.05.2017.
 */
$(document).ready(function create() {
    $("#bAdd").click(function () {
        var quizID = $("#quizID").val();
        var question = $("#question").val();
        var type = $("#type").val();
        var mark = $("#mark").val();
        $.ajax({
            type: "POST",
            url: "create_qs",
            data: 'quizID=' + encodeURIComponent(quizID) +
            '&question=' + encodeURIComponent(question) +
            '&type=' + encodeURIComponent(type) +
            '&mark=' + encodeURIComponent(mark),
            success: function (response) {

                var question = jQuery.parseJSON(response);

                var apnd = "<tr id='" + question.questionID + "'>" +
                    "<td><p id='qsText'>"+question.text+"</p></td>" +
                    "<td><p id='qsType'>"+type+"</p></td>" +
                    "<td><input class='btn btn-warning' type='submit' name='editQs' value='Edit' id='edit" + question.questionID + "' /></td>" +
                    "<td><input class='btn btn-danger' type='submit' name='deleteQs' value='Delete' id='" + question.questionID + "' /></td>" +
                    "</tr>";
                $('#questions').append(apnd);

                $("input:text").val(null);

                $('#edit'+ question.questionID).click(function () {
                    window.location="options?id="+question.questionID;
                });
                $('#'+ question.questionID).click(function () {
                    del(question.questionID);
                });
            }
        });
    });
});
