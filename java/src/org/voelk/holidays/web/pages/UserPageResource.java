package org.voelk.holidays.web.pages;

import com.google.common.base.*;
import org.restlet.representation.*;
import org.restlet.resource.*;

import java.util.*;

public class UserPageResource extends PageResource {

    String userId;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        readRequestParameters();
    }

    @Override
    public Representation toHtml() {
        if (!currentUsersPageIsRequested()) {
            return forbiddenStatus();
        }
        return super.toHtml();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected String getTemplatePath() {
        return "user.ftl";
    }

    @Override
    protected Map<String, Object> getPageData() {
        Map<String, Object> pageData = new HashMap<String, Object>();
        pageData.put("userId", userId);
        return pageData;
    }

    private void readRequestParameters() {
        userId = getQuery().getFirstValue("userId");
        if (Strings.isNullOrEmpty(userId)) {
            throw new IllegalArgumentException("You have to provide a userId");
        }
    }

    private boolean currentUsersPageIsRequested() {
        return getUserId().equals(userId);
    }

}
