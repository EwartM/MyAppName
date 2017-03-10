package com.example.app.shared.service;

import com.example.app.client.proxy.UserProxy;
import com.example.app.server.locator.DaoServiceLocator;
import com.example.app.server.service.UserService;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;

public interface MyRequestFactory extends RequestFactory {

    //USER
    UserRequest userRequest();

    @Service(value = UserService.class, locator = DaoServiceLocator.class)
    public interface UserRequest extends RequestContext {
        Request<UserProxy> authenticate(String submittedEmail, String submittedPassword);
    }

}