package org.voelk.holidays.web.application;

import com.google.inject.*;
import org.voelk.holidays.gateways.*;
import org.voelk.holidays.web.gateways.*;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserGateway.class).to(GaeDatastoreUserGateway.class);
    }
}
