package org.voelk.holidays.web.pages;

import org.restlet.data.*;
import org.restlet.ext.freemarker.*;
import org.restlet.representation.*;
import org.restlet.resource.*;
import org.voelk.holidays.web.*;

import java.util.*;

public abstract class PageResource extends ServerResource {
    @Override
    public HolidayApplication getApplication() {
        return (HolidayApplication) super.getApplication();
    }

    @Get
    public Representation toHtml() {
        return toRepresentation();
    }

    protected Map<String, Object> createPageData() {
        Map<String, Object> ret = getPageData();
//        String s1 = getRequest().getRootRef().getPath();
//        String s2 = getRequest().getRootRef().toString();
//        ret.put("pageContext", s1);
        return ret;
    }

    protected MediaType getMediaType() {
        return MediaType.TEXT_HTML;
    }

    protected abstract String getTemplatePath();

    protected abstract Map<String, Object> getPageData();

    protected Representation toRepresentation() {
        return new TemplateRepresentation(getTemplatePath(), getApplication().getConfiguration(), createPageData(), getMediaType());
    }
}
