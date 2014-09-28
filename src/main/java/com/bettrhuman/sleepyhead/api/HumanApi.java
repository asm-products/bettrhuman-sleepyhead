package com.bettrhuman.sleepyhead.api;

import java.util.logging.Logger;

import javax.inject.Inject;

import lombok.AllArgsConstructor;

import com.bettrhuman.service.IHumanService;
import com.bettrhuman.service.exceptions.UserDoesNotExistException;
import com.bettrhuman.service.utilities.Constants;
import com.bettrhuman.sleepyhead.api.models.HumanEntity;
import com.bettrhuman.sleepyhead.utilities.IAuthFilter;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;

@Api(name = "humans", version = "v1",
    scopes = { Constants.EMAIL_SCOPE },
    clientIds = { Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
        Constants.IOS_CLIENT_ID, com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID }, audiences = { Constants.ANDROID_AUDIENCE })
@AllArgsConstructor(onConstructor = @__(@Inject))
public class HumanApi {

	  private static final Logger log = Logger
	      .getLogger(HumanApi.class.getName());

	  private IAuthFilter authFilter;
	  private IHumanService humanService;

	  @ApiMethod(name = "login", httpMethod = HttpMethod.GET, path = "human/login")
	  public HumanEntity login(User user) throws UnauthorizedException, UserDoesNotExistException
	  {
	    authFilter.authenticate(user);
	    
	    return new HumanEntity(humanService.login(user.getEmail()));
	  }
}
