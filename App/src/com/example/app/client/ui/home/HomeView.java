package com.example.app.client.ui.home;

import com.example.app.client.proxy.UserProxy;
import com.example.app.shared.service.MyRequestFactory;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

    private final MyRequestFactory requestFactory;

    @UiField
    HTMLPanel main;
    @UiField
    TextBox txt_email;
    @UiField
    TextBox txt_password;
    @UiField
    Button btn_login;
    @UiField
    Label lbl_result;

    @Inject
    HomeView(
            Binder uiBinder,
            MyRequestFactory requestFactory
        ) {
        initWidget(uiBinder.createAndBindUi(this));

        this.requestFactory = requestFactory;

        btn_login.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                checkLogin();
            }
        });
    }

    private void checkLogin() {

        String email = txt_email.getText();
        String password = txt_password.getText();

        requestFactory.userRequest().authenticate(email,password).fire(
                new Receiver<UserProxy>() {
                    @Override
                    public void onSuccess(UserProxy user) {
                        if (user != null) {
                            lbl_result.setText("User logged in");
                        } else {
                            lbl_result.setText("Invalid credentials");
                        }
                    }
                    @Override
                    public void onFailure(ServerFailure error) {
                        Window.alert(error.getMessage() + error.getStackTraceString());
                    }
                });
    }

}
