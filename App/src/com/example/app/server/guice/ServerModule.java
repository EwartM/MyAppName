package com.example.app.server.guice;

import com.example.app.server.ServerBootstrapper;
import com.example.app.server.service.UserService;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
        //Request factory
        bind(RequestFactoryServlet.class).in(Singleton.class);
        //Bootstrap
        bind(ServerBootstrapper.class).asEagerSingleton();
        //Services
        bind(UserService.class).in(Singleton.class);
    }
}