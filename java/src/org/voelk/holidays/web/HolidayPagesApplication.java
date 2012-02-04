package org.voelk.holidays.web;

import freemarker.template.*;
import org.restlet.*;
import org.restlet.ext.freemarker.*;
import org.restlet.resource.*;
import org.voelk.holidays.web.pages.*;

import java.util.*;

public class HolidayPagesApplication extends HolidayApplication {

    private Configuration configuration;

    @Override
    public Restlet createInboundRoot() {
        configuration = new Configuration();
        configuration.setTemplateLoader(new ContextTemplateLoader(getContext(),
                "war:///WEB-INF/templates/pages"));
        configuration.setDefaultEncoding("UTF-8");
        return super.createInboundRoot();
    }

    @Override
    protected Map<String, Class<? extends ServerResource>> getRoutes() {
        Map<String, Class<? extends ServerResource>> ret = new HashMap<String, Class<? extends ServerResource>>();
        ret.put("/public/calculator", CalculatorPageResource.class);
        return ret;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}