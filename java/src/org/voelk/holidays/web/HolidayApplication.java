package org.voelk.holidays.web;

import org.restlet.*;
import org.restlet.data.*;
import org.restlet.resource.*;
import org.restlet.routing.*;

import java.util.*;

public abstract class HolidayApplication extends Application {

    public HolidayApplication() {
        getConnectorService().getClientProtocols().add(Protocol.WAR);
        getMetadataService().setDefaultCharacterSet(CharacterSet.UTF_8);
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        for (Map.Entry<String, Class<? extends ServerResource>> entry : getRoutes().entrySet()) {
            router.attach(entry.getKey(), entry.getValue());
        }
        return router;
    }

    protected abstract Map<String, Class<? extends ServerResource>> getRoutes();
}