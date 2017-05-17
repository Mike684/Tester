/**
 * Created by Mike on 12.05.2017.
 */
$(document).ready(function create(){
    $("#bAdd").click(function(){
        var questionID = $("#questionID").val();
        var option = $("#option").val();
        var answer = $("#answer").val();
        $.ajax({
            type: "POST",
            url: "create_opt",
            data: 'questionID='+encodeURIComponent(questionID)+
            '&option='+encodeURIComponent(option)+
            '&answer='+encodeURIComponent(answer),
            success: function(response) {

                var optionObj = jQuery.parseJSON(response);

                var apnd = "<tr id='"+optionObj.optionID+"'>"+
                "<td><p id='optText'>"+option+"</p></td>" +
                "<td><p id='optAnswer'>"+answer+"</p></td>" +
                "<td><input class='btn btn-danger' type='submit' name='deleteOption'  value='Delete' id='"+optionObj.optionID+"'/></td></tr>"

                $('#options').append(apnd);

                $("input:text").val(null);

                $('#'+optionObj.optionID).click(function () {
                    del(optionObj.optionID);
                });
            }
        });
    });
});