window.store = {};

$(document).ready(function() {
    $.get("/test", function(data){
        window.store.test = data;
    });
});
var myVar = window.store.test;