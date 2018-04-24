$(document).ready(function () {
    $('#add-user').submit(function (event) {
        event.preventDefault();
        ajaxPost();
        var words = "- Customer with Id = " + i + ", firstname = " + user.name + ", lastName = " + user.surname + "email = " + user.email + "<br>";
        $('#getResultDiv .list-group').append(words);


        function ajaxPost() {

            // PREPARE FORM DATA
            var user = {
                name: $('#name').val(),
                surname: $('#surname').val(),
                email: $('#email').val()
            }

            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json; charset=utf-8",
                url: window.location + "api/users",
                data: JSON.stringify(user),
                dataType: 'json'
            });
        };
    });
})


$(document).ready(function () {

    // GET REQUEST
    $("#getAllUserId").click(function (event) {
        event.preventDefault();
        ajaxGet();

    });

    // DO GET
    function ajaxGet() {
        $.ajax({
            type: "GET",
            url: window.location + "api/users",
            success: function (data) {


                $('#getResultDiv ul').empty();
                /*var custList = "";*/
                $.each(data, function (i, user) {
                    var words = "- Customer with Id = " + i + ", firstname = " + user.name + ", lastName = " + user.surname + "email = " + user.email + "<br>";
                    $('#getResultDiv .list-group').append(words)
                });
            },
            error: function (e) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
})