package org.voelk.holidays.web;

import freemarker.template.*;
import org.restlet.*;
import org.restlet.data.*;
import org.restlet.ext.freemarker.*;

public class HolidayApplication extends Application {

    private Configuration freemarkerConfiguration;

    public HolidayApplication() {
        getConnectorService().getClientProtocols().add(Protocol.WAR);
        getMetadataService().setDefaultCharacterSet(CharacterSet.UTF_8);
    }

    @Override
    public Restlet createInboundRoot() {
        configureTemplateEngine();
        return new ApplicationRouter(getContext());
    }

    private void configureTemplateEngine() {
        freemarkerConfiguration = new Configuration();
        freemarkerConfiguration.setTemplateLoader(new ContextTemplateLoader(getContext(), "war:///WEB-INF/templates/pages"));
        freemarkerConfiguration.setDefaultEncoding("UTF-8");
    }

    public Configuration getTemplateEngineConfiguration() {
        return freemarkerConfiguration;
    }
}