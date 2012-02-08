package org.voelk.holidays.web.pages;

import com.google.appengine.api.users.*;
import org.restlet.data.*;
import org.restlet.ext.freemarker.*;
import org.restlet.representation.*;
import org.restlet.resource.*;
import org.voelk.holidays.web.application.*;

import java.util.*;

public abstract class PageResource extends BaseServerResource {
    @Get
    public Representation toHtml() {
        return toRepresentation();
    }

    protected Map<String, Object> createPageData() {
        Map<String, Object> ret = getPageData();
        ret.put("_logoutUrl", UserServiceFactory.getUserService().createLogoutURL("/index.html"));
        ret.put("_userIsLoggedIn", UserServiceFactory.getUserService().isUserLoggedIn());
        String userId = getUserId();
        ret.put("_userId", userId);
        return ret;
    }

    protected MediaType getMediaType() {
        return MediaType.TEXT_HTML;
    }

    protected abstract String getTemplatePath();

    protected abstract Map<String, Object> getPageData();

    protected Representation toRepresentation() {
        return new TemplateRepresentation(getTemplatePath(), getApplication().getTemplateEngineConfiguration(), createPageData(), getMediaType());
    }

}
