package com.example.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.ApplicationController;

public class MyEntryPoint implements EntryPoint {
    private static final ApplicationController CONTROLLER =
            GWT.create(ApplicationController.class);

    @Override
    public void onModuleLoad() {

        CONTROLLER.init();
    }
}
