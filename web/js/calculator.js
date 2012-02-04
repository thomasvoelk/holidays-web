/*global $, jQuery */
function initDatePickers() {
    "use strict";
    var dates = $("#localFrom, #localTo").datepicker({
        numberOfMonths:2,
        altFormat:"yy-mm-dd",
        onSelect:function (selectedDate) {
            var option = this.id === "localFrom" ? "minDate" : "maxDate",
                instance = $(this).data("datepicker"),
                date = $.datepicker.parseDate(
                    instance.settings.dateFormat ||
                        $.datepicker._defaults.dateFormat,
                    selectedDate, instance.settings);
            dates.not(this).datepicker("option", option, date);
            $("#daysNeeded").text("Berechne...");
            $('#calculationForm').submit();
        }
    });
    $("#localFrom").datepicker("option", "altField", '#from');
    $("#localTo").datepicker("option", "altField", '#to');
}
function bindSubmitToAjaxRequest() {
    "use strict";
    var options = {
        target:'#daysNeeded'
    };
    $('#calculationForm').ajaxForm(options);
}

$(function () {
    "use strict";
    bindSubmitToAjaxRequest();
    initDatePickers();
});