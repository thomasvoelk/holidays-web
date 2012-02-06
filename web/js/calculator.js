/*global $, jQuery */
function emptyDateField(dateField, text) {
    "use strict";
    if (dateField.val().length === 0 || dateField.val() === text) {
        dateField.datepicker("setDate", null);
        dateField.val(text);
        dateField.addClass('empty');
    }
}

function emptyDateFields() {
    "use strict";
    emptyDateField($('#localFrom'), "Von...", $('#localTo'));
    emptyDateField($('#localTo'), "Bis...", $('#localFrom'));
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
function resetMinAndMaxDateOptions() {
    "use strict";
    $("#localFrom, #localTo").datepicker("option", "minDate", null);
    $("#localFrom, #localTo").datepicker("option", "maxDate", null);
}
function clearFormFields() {
    "use strict";
    $('#calculationForm').clearForm(true);
}
function initFormButton() {
    "use strict";
    $('#clearForm').bind('click', function () {
        resetMinAndMaxDateOptions();
        clearFormFields();
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