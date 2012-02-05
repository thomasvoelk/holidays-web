package org.voelk.holidays.web.resources;

import com.google.common.base.*;
import org.restlet.resource.*;
import org.voelk.holidays.application.*;
import org.voelk.holidays.web.util.*;

import java.text.*;

public class WorkingDaysResource extends ServerResource {

    private String from = "";
    private String to = "";
    private Period period;

    @Override
    protected void doInit() throws ResourceException {
        readRequestParameters();
        createPeriod();
    }

    @SuppressWarnings("UnusedDeclaration")
    @Get("txt")
    public String represent() {
        HolidayCalculator calculator = new Application().getHolidayCalculator();
        double daysNeeded = calculator.calculateWorkingDays(period);
        return formatResponse(daysNeeded);
    }


    private void readRequestParameters() {
        from = getQuery().getFirstValue("from");
        to = getQuery().getFirstValue("to");
        if (Strings.isNullOrEmpty(from) && Strings.isNullOrEmpty(to)) {
            throw new IllegalArgumentException("You have to provide either a from or a to date");
        } else if (Strings.isNullOrEmpty(from)) {
            from = to;
        } else if (Strings.isNullOrEmpty(to)) {
            to = from;
        }
    }

    private void createPeriod() {
        period = new Period(DateUtils.convertStringToDate(from), DateUtils.convertStringToDate(to));
    }


    private String formatResponse(double daysNeeded) {
        String pattern = "#";
        if (!String.valueOf(daysNeeded).endsWith(".0")) {
            pattern += ".#";
        }
        return new DecimalFormat(pattern).format(daysNeeded);
    }
}