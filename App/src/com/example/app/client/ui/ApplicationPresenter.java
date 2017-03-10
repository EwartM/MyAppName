package com.example.app.client.ui;

import com.example.app.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> implements ApplicationUiHandlers {
    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {
    }


    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    public static final NestedSlot SLOT_APPLICATION = new NestedSlot();
    private final PlaceManager placeManager;

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager
            ) {
        super(eventBus, view, proxy, RevealType.Root);

        getView().setUiHandlers(this);

        this.placeManager = placeManager;

        PlaceRequest requestedPlace;
        requestedPlace = new PlaceRequest.Builder().nameToken(NameTokens.HOME).build();
    }

}
