package com.example.app.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("appService")
public interface appService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use appService.App.getInstance() to access static instance of appServiceAsync
     */
    public static class App {
        private static appServiceAsync ourInstance = GWT.create(appService.class);

        public static synchronized appServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
