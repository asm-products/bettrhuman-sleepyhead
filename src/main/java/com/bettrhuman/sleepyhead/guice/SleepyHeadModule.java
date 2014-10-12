package com.bettrhuman.sleepyhead.guice;

import java.util.HashSet;
import java.util.Set;

import com.bettrhuman.service.HumanService;
import com.bettrhuman.service.IHumanService;
import com.bettrhuman.service.utilities.GoogleCloudStorage;
import com.bettrhuman.service.utilities.ICloudStorage;
import com.bettrhuman.sleepyhead.api.HumanAPI;
import com.bettrhuman.sleepyhead.utilities.AuthFilter;
import com.bettrhuman.sleepyhead.utilities.IAuthFilter;
import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;
import com.google.inject.Provides;

public class SleepyHeadModule extends GuiceSystemServiceServletModule {

	@Override
	  protected void configureServlets()
	  {
	    super.configureServlets();
	    
	    this.bind(IAuthFilter.class).to(AuthFilter.class).asEagerSingleton();
	    this.bind(ICloudStorage.class).to(GoogleCloudStorage.class).asEagerSingleton();
	    
	    this.bind(IHumanService.class).to(HumanService.class).asEagerSingleton();

	    // Add API classes
	    Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
	    serviceClasses.add(HumanAPI.class);

	    this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);
	  }
	
	  @Provides
	  public GcsService providesGcsService()
	  {
	    return GcsServiceFactory.createGcsService(RetryParams.getDefaultInstance());
	  }


}
