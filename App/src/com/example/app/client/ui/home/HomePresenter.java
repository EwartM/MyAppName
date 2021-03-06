package com.example.app.client.ui.home;

import com.example.app.client.place.NameTokens;
import com.example.app.client.ui.ApplicationPresenter;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {
    interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
    }

    @NameToken(NameTokens.HOME)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    public static final NestedSlot SLOT_HOME = new NestedSlot();

    @Inject
    HomePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_APPLICATION);

        getView().setUiHandlers(this);
    }

}
