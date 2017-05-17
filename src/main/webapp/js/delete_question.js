/**
 * Created by Mike on 14.05.2017.
 */
function del (questionID){
    $.ajax({
        type: "POST",
        url: "delete_qs",
        data: 'id='+encodeURIComponent(questionID),
        success: function() {
            $('#'+questionID).remove();
        }
    });
}