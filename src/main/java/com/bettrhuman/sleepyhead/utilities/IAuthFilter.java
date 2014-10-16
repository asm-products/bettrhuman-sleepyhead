package com.bettrhuman.sleepyhead.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.bettrhuman.service.models.Human;
import com.bettrhuman.sleepyhead.api.models.FacebookUser;
import com.bettrhuman.sleepyhead.api.models.UserCredential;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;

public interface IAuthFilter
{

  public Human authenticate(UserCredential user) throws UnauthorizedException;
  
  public void authorize(User user, String resource) throws UnauthorizedException;

  public FacebookUser facebookAuthenticate(String accessToken) throws URISyntaxException, MalformedURLException, IOException;
  
}
