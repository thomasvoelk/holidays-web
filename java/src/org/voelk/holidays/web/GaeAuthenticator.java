package org.voelk.holidays.web;

import org.restlet.*;
import org.restlet.security.*;
import org.voelk.holidays.gateways.*;

public class GaeAuthenticator extends org.restlet.ext.gae.GaeAuthenticator {

    public GaeAuthenticator(Context context) {
        super(context);
    }

    public GaeAuthenticator(Context context, boolean optional) {
        super(context, optional);
    }

    public GaeAuthenticator(Context context, boolean optional, Enroler enroler) {
        super(context, optional, enroler);
    }

    @Override
    protected boolean authenticate(Request request, Response response) {
        boolean userIsAuthenticated = super.authenticate(request, response);
        if (userIsAuthenticated) {
            User restletUser = request.getClientInfo().getUser();
            if (!userExists(restletUser)) {
                org.voelk.holidays.entities.User user = new org.voelk.holidays.entities.User(restletUser.getIdentifier());
                user.setEmail(restletUser.getEmail());
                getUserGateway().add(user);

            }
        }
        return userIsAuthenticated;
    }

    private UserGateway getUserGateway() {
        HolidayWebApplication holidayWebApplication = (HolidayWebApplication) getApplication();
        return holidayWebApplication.getHolidayApplication().getUserGateway();
    }

    private boolean userExists(User restletUser) {
        try {
            org.voelk.holidays.entities.User user = getUserGateway().findByUserId(restletUser.getIdentifier());
            return user != null;
        } catch (ObjectNotFoundException ex) {
            return false;
        }
    }


}
