function loadUserInfo() {
    "use strict";
    //noinspection JSUnresolvedVariable,JSUnresolvedVariable
    $.ajax({
        url:"/app/private/users/" + userId,
        dataType:"json",
        success:function (user) {
            $("#emailHeader").text(user["email"]);
            $("#holidays").val(user["holidays"]);
        }
    });
}

function bindSubmitToAjaxRequest() {
    "use strict";
    var options = {
        success:function () {
            alert("Gespeichert");
        }
    };
    $('#userForm').ajaxForm(options);
}


function bindSaveButton() {
    "use strict";
    $('#saveButton').bind('click', function () {
        $('#userForm').submit();
        return false;
    });
}

$(function () {
    "use strict";
    loadUserInfo();
    bindSubmitToAjaxRequest();
    bindSaveButton();
});