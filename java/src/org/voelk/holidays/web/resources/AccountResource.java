package org.voelk.holidays.web.resources;

import org.restlet.resource.*;

public class AccountResource extends ServerResource {
    @Get("txt")
    public String represent() {
        String test1 = (String) getRequestAttributes().get("accountId");
        String test2 = (String) getRequestAttributes().get("from");
        String test3 = (String) getRequestAttributes().get("to");
        return getQuery().getFirstValue("accountId", false, "xxx");
    }
}
