$(document).ready(function() {
    $.ajax({
        type : "GET",
        contentType : "application/json",
        url : window.location + "api/note"
    }).then(function(note) {
        $('.greeting-id').append(note.name);
        $('.greeting-content').append(note.text);

    });
});

$(document).ready(function() {
    $.ajax({
        type : "GET",
        contentType : "application/json",
        url : window.location + "api/user"
    }).then(function(user) {
        $('.user-id').append(user.id);
        $('.user-content').append(user.email);

    });
});