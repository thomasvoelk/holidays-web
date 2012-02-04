package org.voelk.holidays.web;

import com.google.appengine.api.users.*;
import org.restlet.*;
import org.restlet.data.*;
import org.restlet.security.*;

public class GaeAuthenticator extends ChallengeAuthenticator {
    public GaeAuthenticator(Context context, ChallengeScheme challengeScheme, String realm) {
        super(context, challengeScheme, realm);
    }

    @Override
    protected boolean authenticate(Request request, Response response) {
        if (!UserServiceFactory.getUserService().isUserLoggedIn()) {
            String path = request.getOriginalRef().getPath();
            String loginURL = UserServiceFactory.getUserService().createLoginURL(path);
            response.redirectTemporary(loginURL);
            return false;
        } else {
            return true;
        }
    }
}
