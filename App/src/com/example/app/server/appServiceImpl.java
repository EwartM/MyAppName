package com.example.app.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.example.app.client.appService;

public class appServiceImpl extends RemoteServiceServlet implements appService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hiya!\"";
    }
}