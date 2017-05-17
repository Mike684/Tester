/**
 * Created by Mike on 16.05.2017.
 */
$(document).ready(function() {
    $('#qzForm').validate({
        rules:{

            theme:{
                required: true,
                minlength: 5,
                maxlength: 100
            }

        },

        messages:{

            theme:{
                required: "Enter question theme",
                minlength: "Minimum symbol quantity: 5",
                maxlength: "Maximum symbol quantity: 100"
            }

        }
    });

    $('#qsForm').validate({
        rules:{

            question:{
                required: true,
                minlength: 5,
                maxlength: 100
            },

            mark:{
                required: true,
                number: true,
                minlength: 1,
                maxlength: 100
            }

        },

        messages:{

            question:{
                required: "Enter question text",
                minlength: "Minimum symbol quantity: 5",
                maxlength: "Maximum symbol quantity: 100"
            },

            mark:{
                required: "Enter mark",
                number: "It's not a number",
                minlength: "Minimum symbol quantity: 1",
                maxlength: "Maximum symbol quantity: 100"
            }

        }
    });

    $('#optForm').validate({
        rules:{

            option:{
                required: true,
                minlength: 1,
                maxlength: 50
            }
        },

        messages:{

            option:{
                required: "Enter option text",
                minlength: "Minimum symbol quantity: 1",
                maxlength: "Maximum symbol quantity: 50"
            }
        }
    });

    $('#blForm').validate({
        rules:{

            option:{
                required: true,
                minlength: 1,
                maxlength: 10
            }
        },

        messages:{

            option:{
                required: "Enter blank text",
                minlength: "Minimum symbol quantity: 1",
                maxlength: "Maximum symbol quantity: 50"
            }
        }
    });

});