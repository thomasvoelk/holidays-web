package org.voelk.holidays.web.resources;

import com.google.gson.*;
import org.restlet.data.*;
import org.restlet.representation.*;
import org.restlet.resource.*;
import org.voelk.holidays.entities.*;
import org.voelk.holidays.web.*;

public class UserResource extends BaseServerResource {

    private String userId;
    private int holidays;

    @Override
    protected void doInit() throws ResourceException {
        readRequestParameters();
    }

    @Get("json")
    public String represent() {
        User user = getApplication().getHolidayApplication().getUserGateway().findByUserId(userId);
        return new Gson().toJson(user);
    }

    @Post
    public String save(Representation entity) {
        Form form = new Form(entity);
        int holidays = Integer.parseInt(form.getFirstValue("holidays"));
        getApplication().getHolidayApplication().getUserManager().setHolidaysForUser(userId, holidays);
        return "";
    }


    private void readRequestParameters() {
        userId = (String) getRequestAttributes().get("userId");
    }


}
