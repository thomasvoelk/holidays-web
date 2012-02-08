package org.voelk.holidays.web.application;

import org.restlet.*;
import org.restlet.routing.*;
import org.restlet.security.*;
import org.voelk.holidays.web.pages.*;
import org.voelk.holidays.web.resources.*;

public class ApplicationRouter extends Router {
    public ApplicationRouter(Context context) {
        super(context);
        attachPublicResources();
        Router secureRouter = new Router(getContext());
        attachPrivateResources(secureRouter);
        attachAuthenticatorForPrivateResources(secureRouter);
    }


    private void attachPublicResources() {
        attach("/public/workingDays", WorkingDaysResource.class);
        attach("/public/calculator", CalculatorPageResource.class);
    }

    private void attachPrivateResources(Router secureRouter) {
        secureRouter.attach("/calculator", CalculatorPageResource.class);
        secureRouter.attach("/pages/user", UserPageResource.class);
        secureRouter.attach("/users/{userId}", UserResource.class);
    }

    private void attachAuthenticatorForPrivateResources(Router secureRouter) {
        Authenticator authenticator = new GaeAuthenticator(getContext());
        authenticator.setNext(secureRouter);
        attach("/private", authenticator, Template.MODE_STARTS_WITH);
    }

}
