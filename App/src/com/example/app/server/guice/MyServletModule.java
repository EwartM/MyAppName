package com.example.app.server.guice;

import java.util.HashMap;
import java.util.Map;
import com.google.inject.servlet.ServletModule;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

public class MyServletModule extends ServletModule {

    @Override protected void configureServlets() {

        // NOTE: BOTH Request Factory AND Remote logging use the parameter below
        // SymbolMaps are needed to deobfuscate JS methods in stack traces
        // but I don't use this feature as I don't code JS directly and
        // enbaling deobfuscation comes at large performance cost
        // because you have to enable stackMode emulation in gwt.xml
        Map<String, String> params = new HashMap<String, String>();
        params.put("symbolMapsDirectory", "WEB-INF/deploy/app/symbolMaps/");

        // Request Factory (see parameters note above)
        serve("/gwtRequest").with( RequestFactoryServlet.class, params);

    }
}
