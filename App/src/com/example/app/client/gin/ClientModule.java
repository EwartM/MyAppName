package com.example.app.client.gin;

import com.example.app.client.place.NameTokens;
import com.example.app.shared.service.MyRequestFactory;
import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;
import com.example.app.client.ui.ApplicationModule;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule.Builder()
                .tokenFormatter(RouteTokenFormatter.class)
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME) //TODO
                .unauthorizedPlace(NameTokens.HOME)
                .build());

        install(new ApplicationModule());
    }

    @Provides
    @Singleton
    @Inject //inject the event bus
    public MyRequestFactory myRequestFactory(EventBus eventBus
    ) {
        MyRequestFactory factory = GWT.create( MyRequestFactory.class );
        factory.initialize( eventBus );
        return factory;
    }
}
