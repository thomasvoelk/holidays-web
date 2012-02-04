package org.voelk.holidays.web;

import freemarker.template.*;
import org.restlet.*;
import org.restlet.data.*;
import org.restlet.ext.freemarker.*;
import org.restlet.routing.*;
import org.voelk.holidays.web.pages.*;
import org.voelk.holidays.web.webservices.*;

public class HolidayApplication extends Application {

    private Configuration configuration;

    public HolidayApplication() {
        getConnectorService().getClientProtocols().add(Protocol.WAR);
        getMetadataService().setDefaultCharacterSet(CharacterSet.UTF_8);
    }

    @Override
    public Restlet createInboundRoot() {
        configuration = new Configuration();
        configuration.setTemplateLoader(new ContextTemplateLoader(getContext(),
                "war:///WEB-INF/templates/pages"));
        configuration.setDefaultEncoding("UTF-8");
        Router router = new Router(getContext());
        router.attach("/public/calculate/neededDays", HolidayCalculatorWebserviceResource.class);
        router.attach("/public/calculator", CalculatorPageResource.class);
        Router secureRouter = new Router(getContext());
        secureRouter.attach("/calculator", CalculatorPageResource.class);
        GaeAuthenticator authenticator = new GaeAuthenticator(getContext(), ChallengeScheme.CUSTOM, "System Authentication - Provide your credentials");
        authenticator.setNext(secureRouter);
        router.attach("/private", authenticator, org.restlet.routing.Template.MODE_STARTS_WITH);
        return router;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}