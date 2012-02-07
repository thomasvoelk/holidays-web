package org.voelk.holidays.web;

import com.google.inject.*;
import freemarker.template.*;
import org.restlet.*;
import org.restlet.data.*;
import org.restlet.ext.freemarker.*;

public class HolidayWebApplication extends Application {

    private Configuration freemarkerConfiguration;
    private org.voelk.holidays.application.Application holidayApplication;

    public HolidayWebApplication() {
        getConnectorService().getClientProtocols().add(Protocol.WAR);
        getMetadataService().setDefaultCharacterSet(CharacterSet.UTF_8);
    }

    @Override
    public Restlet createInboundRoot() {
        createHolidayApplicationInstance();
        configureTemplateEngine();
        return new ApplicationRouter(getContext());
    }

    private void createHolidayApplicationInstance() {
        Injector injector = Guice.createInjector(new ApplicationModule());
        holidayApplication = injector.getInstance(org.voelk.holidays.application.Application.class);
    }

    private void configureTemplateEngine() {
        freemarkerConfiguration = new Configuration();
        freemarkerConfiguration.setTemplateLoader(new ContextTemplateLoader(getContext(), "war:///WEB-INF/templates/pages"));
        freemarkerConfiguration.setDefaultEncoding("UTF-8");
    }

    public Configuration getTemplateEngineConfiguration() {
        return freemarkerConfiguration;
    }

    public org.voelk.holidays.application.Application getHolidayApplication() {
        return holidayApplication;
    }
}