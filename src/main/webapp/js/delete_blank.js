/**
 * Created by Mike on 17.05.2017.
 */
function del (blankID){
    $.ajax({
        type: "POST",
        url: "delete_bl",
        data: 'id='+encodeURIComponent(blankID),
        success: function() {
            $('#'+blankID).remove();
        }
    });
}