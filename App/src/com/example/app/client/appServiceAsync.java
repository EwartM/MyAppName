package com.example.app.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface appServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
