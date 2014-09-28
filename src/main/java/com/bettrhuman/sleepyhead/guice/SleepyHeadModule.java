package com.bettrhuman.sleepyhead.guice;

import java.util.HashSet;
import java.util.Set;

import com.bettrhuman.service.utilities.GoogleCloudStorage;
import com.bettrhuman.service.utilities.ICloudStorage;
import com.bettrhuman.sleepyhead.api.HumanApi;
import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;

public class SleepyHeadModule extends GuiceSystemServiceServletModule {

	@Override
	  protected void configureServlets()
	  {
	    super.configureServlets();
	    
	    this.bind(ICloudStorage.class).to(GoogleCloudStorage.class).asEagerSingleton();

	    // Add API classes
	    Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
	    serviceClasses.add(HumanApi.class);

	    this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);
	  }

}
