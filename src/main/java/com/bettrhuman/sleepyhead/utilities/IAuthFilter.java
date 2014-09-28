package com.bettrhuman.sleepyhead.utilities;

import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;

public interface IAuthFilter
{

  public void authenticate(User user) throws UnauthorizedException;
  
  public void authorize(User user, String resource) throws UnauthorizedException;
  
}
