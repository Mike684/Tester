/**
 * Created by Mike on 12.05.2017.
 */
$(document).ready(function create(){
    $("#bAdd").click(function(){
        var questionID = $("#questionID").val();
        var answer = $("#answer").val();
        $.ajax({
            type: "POST",
            url: "create_bl",
            data: 'questionID='+encodeURIComponent(questionID)+
            '&answer='+encodeURIComponent(answer),
            success: function(response) {

                var blankObj = jQuery.parseJSON(response);
                var apnd = "<tr id='"+blankObj.blankID+"'>"+
                    "<td><p id='blAnswer'>"+answer+"</p></td>" +
                    "<td><input class='btn btn-danger' type='submit' name='deleteOption'  value='Delete' id='"+blankObj.blankID+"'/></td></tr>"

                $('#blanks').append(apnd);

                $("input:text").val(null);

                $('#'+blankObj.blankID).click(function () {
                    del(blankObj.blankID);
                });
            }
        });
    });
});