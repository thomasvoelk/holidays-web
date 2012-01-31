package org.voelk.holidays.web;

import org.restlet.*;
import org.restlet.routing.*;
import org.voelk.holidays.web.webservices.HolidayCalculatorWebserviceResource;

public class HolidayWebservicesApplication extends Application {
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/calculate/neededDays", HolidayCalculatorWebserviceResource.class);
        return router;
    }
}