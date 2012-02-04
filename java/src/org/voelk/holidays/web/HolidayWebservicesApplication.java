package org.voelk.holidays.web;

import org.restlet.resource.*;
import org.voelk.holidays.web.webservices.*;

import java.util.*;

public class HolidayWebservicesApplication extends HolidayApplication {

    @Override
    protected Map<String, Class<? extends ServerResource>> getRoutes() {
        Map<String, Class<? extends ServerResource>> ret = new HashMap<String, Class<? extends ServerResource>>();
        ret.put("/public/calculate/neededDays", HolidayCalculatorWebserviceResource.class);
        return ret;
    }
}