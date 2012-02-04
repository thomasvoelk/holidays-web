package org.voelk.holidays.web.pages;

import org.restlet.data.*;
import org.restlet.ext.freemarker.*;
import org.restlet.representation.*;
import org.restlet.resource.*;
import org.voelk.holidays.web.*;

import java.util.*;

public abstract class PageResource extends ServerResource {
    @Override
    public HolidayPagesApplication getApplication() {
        return (HolidayPagesApplication) super.getApplication();
    }

    @Get
    public Representation toHtml() {
        return toRepresentation();
    }

    protected MediaType getMediaType() {
        return MediaType.TEXT_HTML;
    }

    protected abstract String getTemplatePath();

    protected abstract Map<String, Object> getPageData();

    protected Representation toRepresentation() {
        return new TemplateRepresentation(getTemplatePath(), getApplication().getConfiguration(), getPageData(), getMediaType());
    }
}