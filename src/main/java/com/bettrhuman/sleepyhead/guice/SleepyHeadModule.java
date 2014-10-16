package com.bettrhuman.sleepyhead.guice;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import com.bettrhuman.service.HumanService;
import com.bettrhuman.service.IHumanService;
import com.bettrhuman.service.IProfileService;
import com.bettrhuman.service.ProfileService;
import com.bettrhuman.service.dao.HumanDao;
import com.bettrhuman.service.dao.IHumanDao;
import com.bettrhuman.service.dao.IProfileDao;
import com.bettrhuman.service.dao.ProfileDao;
import com.bettrhuman.service.models.Human;
import com.bettrhuman.service.models.Picture;
import com.bettrhuman.service.models.Profile;
import com.bettrhuman.sleepyhead.api.HumanAPI;
import com.bettrhuman.sleepyhead.api.ProfileAPI;
import com.bettrhuman.sleepyhead.utilities.AuthFilter;
import com.bettrhuman.sleepyhead.utilities.IAuthFilter;
import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;
import com.google.inject.Provides;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.impl.translate.opt.joda.JodaTimeTranslators;

public class SleepyHeadModule extends GuiceSystemServiceServletModule {

	@Override
	  protected void configureServlets()
	  {
	    super.configureServlets();
	    
	    this.bind(IAuthFilter.class).to(AuthFilter.class).asEagerSingleton();
	    
	    this.bind(IProfileService.class).to(ProfileService.class).asEagerSingleton();
	    this.bind(IHumanService.class).to(HumanService.class).asEagerSingleton();
	    this.bind(IProfileDao.class).to(ProfileDao.class).asEagerSingleton();
	    this.bind(IHumanDao.class).to(HumanDao.class).asEagerSingleton();

	    JodaTimeTranslators.add(ObjectifyService.factory());
	    ObjectifyService.register(Human.class);
	    ObjectifyService.register(Profile.class);
	    ObjectifyService.register(Picture.class);
	    
	    // Add API classes
	    Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
	    serviceClasses.add(HumanAPI.class);
	    serviceClasses.add(ProfileAPI.class);

	    this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);
	  }
	
	@Provides
	public ObjectMapper providesObjectMapper()
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}

}
