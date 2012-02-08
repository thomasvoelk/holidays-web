package org.voelk.holidays.web.application;

import com.google.common.base.*;
import org.restlet.data.*;
import org.restlet.representation.*;
import org.restlet.resource.*;

public class BaseServerResource extends ServerResource {
    @Override
    public HolidayWebApplication getApplication() {
        return (HolidayWebApplication) super.getApplication();
    }

    protected Representation forbiddenStatus() {
        getResponse().setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        return null;
    }

    protected String getUserId() {
        if (getClientInfo().getUser() != null) {
            return Strings.nullToEmpty(getClientInfo().getUser().getIdentifier());
        } else {
            return "";
        }
    }
}
