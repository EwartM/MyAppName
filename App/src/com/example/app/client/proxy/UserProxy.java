package com.example.app.client.proxy;

import com.example.app.server.domain.User;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = User.class)
public interface UserProxy extends EntityProxy {

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    String getEmail();
    void setEmail(String email);

    String getCleartextPassword();
    void setCleartextPassword(String cleartextPassword);

    Boolean isLoggedIn();
}
