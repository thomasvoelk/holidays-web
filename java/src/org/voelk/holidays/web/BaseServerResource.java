package org.voelk.holidays.web;

import org.restlet.resource.*;

public class BaseServerResource extends ServerResource {
    @Override
    public HolidayWebApplication getApplication() {
        return (HolidayWebApplication) super.getApplication();
    }
}
