package org.voelk.holidays.web.gateways;

import com.google.appengine.api.datastore.*;
import org.voelk.holidays.entities.*;
import org.voelk.holidays.gateways.*;

import java.util.*;

public class GaeDatastoreUserGateway implements UserGateway {


    private static final String KIND = User.class.getCanonicalName();

    @Override
    public void add(User user) {
        Entity userEntity = new Entity(KIND, user.getUserId());
        userToEntity(user, userEntity);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(userEntity);
    }

    private void userToEntity(User user, Entity userEntity) {
        userEntity.setProperty("email", user.getEmail());
        userEntity.setProperty("holidays", user.getHolidays());
    }

    @Override
    public User findByUserId(String id) {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        try {
            Entity userEntity = datastore.get(KeyFactory.createKey(KIND, id));
            Map<String, Object> properties = userEntity.getProperties();
            User user = new User(id);
            if (userEntity.hasProperty("email")) {
                user.setEmail((String) properties.get("email"));
            }
            if (userEntity.hasProperty("holidays")) {
                user.setHolidays(((Long) properties.get("holidays")).intValue());
            }
            return user;
        } catch (EntityNotFoundException e) {
            throw new ObjectNotFoundException(KIND, id);
        }
    }

    @Override
    public void store(User user) {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        try {
            Entity userEntity = datastore.get(KeyFactory.createKey(KIND, user.getUserId()));
            userToEntity(user, userEntity);
            datastore.put(userEntity);
        } catch (EntityNotFoundException e) {
            throw new ObjectNotFoundException(KIND, user.getUserId());
        }
    }
}
