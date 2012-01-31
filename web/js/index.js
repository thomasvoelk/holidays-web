$(function () {
    var dates = $("#from, #to").datepicker({
        numberOfMonths:2,
        onSelect:function (selectedDate) {
            var option = this.id == "from" ? "minDate" : "maxDate",
                instance = $(this).data("datepicker"),
                date = $.datepicker.parseDate(
                    instance.settings.dateFormat ||
                        $.datepicker._defaults.dateFormat,
                    selectedDate, instance.settings);
            dates.not(this).datepicker("option", option, date);
            $("#daysNeeded").text("Berechne...");
            $.ajax({
                url:function () {
                    var fromDate = dates.filter("#from").datepicker("getDate"),
                        toDate = dates.filter("#to").datepicker("getDate"),
                        from = "",
                        to = "";
                    if (fromDate) {
                        from = $.datepicker.formatDate('yy-mm-dd', fromDate);
                    }
                    if (toDate) {
                        to = $.datepicker.formatDate('yy-mm-dd', toDate);
                    }
                    return "ws/calculate/neededDays?from=" + from + "&to=" + to;
                }(),
                context:document.body,
                dataType:"text",
                success:function (data) {
                    $("#daysNeeded").text(data);
                }
            });
        }
    })
        ;

});