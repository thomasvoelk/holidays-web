/*global $, jQuery */
function emptyDateField(field, text) {
    "use strict";
    if (field.val().length === 0 || field.val() === text) {
        field.datepicker("setDate", null);
        field.val(text);
        field.addClass('empty');
    }
}

function emptyDateFields() {
    "use strict";
    emptyDateField($('#localFrom'), "Von...");
    emptyDateField($('#localTo'), "Bis...");
}
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
                    selectedDate, instance.settings),
                otherFieldValue = dates.not(this).val();
            dates.not(this).datepicker("option", option, date);
            if (otherFieldValue.length === 0 || otherFieldValue === "Von..." || otherFieldValue === "Bis...") {
                dates.not(this).datepicker("setDate", null);
            }
            $('#result').hide();
            $(this).removeClass('empty');
            emptyDateFields();
            $('#inProgress').show();
            $('#calculationForm').submit();
        }
    });
    $("#localFrom").datepicker("option", "altField", '#from');
    $("#localTo").datepicker("option", "altField", '#to');
    emptyDateFields();
}

function bindSubmitToAjaxRequest() {
    "use strict";
    var options = {
        target:'#workingDays',
        success:function () {
            $('#result').show();
            $('#inProgress').hide();
        }
    };
    $('#calculationForm').ajaxForm(options);
}
function hideResultAndProgressInfo() {
    "use strict";
    $('#result').hide();
    $('#inProgress').hide();
}
function initFormButton() {
    "use strict";
    $('#clearForm').bind('click', function () {
        $('#calculationForm').clearForm(true);
        hideResultAndProgressInfo();
        emptyDateFields();
    });
}
$(function () {
    "use strict";
    hideResultAndProgressInfo();
    initFormButton();
    bindSubmitToAjaxRequest();
    initDatePickers();
    emptyDateFields();
});