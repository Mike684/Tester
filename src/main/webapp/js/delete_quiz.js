/**
 * Created by Mike on 14.05.2017.
 */
function delQz (quizID){
    $.ajax({
        type: "POST",
        url: "delete_qz",
        data: 'id='+encodeURIComponent(quizID),
        success: function() {
            $('#'+quizID).remove();
        }
    });
}