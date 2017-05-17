/**
 * Created by Mike on 16.05.2017.
 */
function del (optionID){
    $.ajax({
        type: "POST",
        url: "delete_opt",
        data: 'id='+encodeURIComponent(optionID),
        success: function() {
            $('#'+optionID).remove();
        }
    });
}