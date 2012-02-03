package org.voelk.holidays.web.webservices;

import com.google.common.base.*;
import org.restlet.data.*;
import org.restlet.resource.*;
import org.voelk.holidays.*;
import org.voelk.holidays.transactions.*;

import java.text.*;
import java.util.*;

public class HolidayCalculatorWebserviceResource extends ServerResource {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private String from = "";
    private String to = "";

    @SuppressWarnings("UnusedDeclaration")
    @Get("txt")
    public String calculate() {
        readRequestParameters();
        try {
            Transaction<CalculateNeededDaysRequest, CalculateNeededDaysResponse> calculator = new CalculateNeededDaysTransaction();
            double daysNeeded = calculator.execute(new DefaultCalculateNeededDaysRequest(convert(from), convert(to))).getDays();
            return formatResponse(daysNeeded);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private String formatResponse(double daysNeeded) {
        String pattern = "#";
        if (!String.valueOf(daysNeeded).endsWith(".0")) {
            pattern += ".#";
        }
        return new DecimalFormat(pattern).format(daysNeeded);
    }

    private void readRequestParameters() {
        Parameter fromParameter = getQuery().getFirst("from");
        Parameter toParameter = getQuery().getFirst("to");
        if (parameterIsNotEmpty(fromParameter) && parameterIsNotEmpty(toParameter)) {
            from = fromParameter.getValue();
            to = toParameter.getValue();
        } else if (parameterIsNotEmpty(fromParameter)) {
            from = fromParameter.getValue();
            to = fromParameter.getValue();
        } else if (parameterIsNotEmpty(toParameter)) {
            from = toParameter.getValue();
            to = toParameter.getValue();
        }
    }

    private boolean parameterIsNotEmpty(Parameter parameter) {
        return parameter != null && !Strings.isNullOrEmpty(parameter.getValue());
    }

    private Date convert(String date) throws ParseException {
        return new SimpleDateFormat(DATE_PATTERN).parse(date);
    }

    class DefaultCalculateNeededDaysRequest implements CalculateNeededDaysRequest {

        private final Date start;
        private final Date end;

        DefaultCalculateNeededDaysRequest(Date start, Date end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Date getStartDate() {
            return start;
        }

        @Override
        public Date getEndDate() {
            return end;
        }
    }

}