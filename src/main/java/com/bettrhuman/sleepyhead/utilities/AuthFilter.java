package com.bettrhuman.sleepyhead.utilities;

import javax.inject.Inject;

import lombok.AllArgsConstructor;

import com.bettrhuman.service.IHumanService;
import com.bettrhuman.service.models.Human;
import com.bettrhuman.service.utilities.Constants;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;

@AllArgsConstructor(onConstructor = @__(@Inject))
public class AuthFilter implements IAuthFilter
{

  IHumanService humanService;
  
  @Override
  public void authenticate(User user) throws UnauthorizedException
  {
    if (user == null)
    {
      throw new UnauthorizedException(Constants.UNAUTHENTICATED);
    }
  }

  @Override
  public void authorize(User user, String resource) throws UnauthorizedException
  {
    this.authenticate(user);
    Human n = null;
    
    try
    {
     n = humanService.login(user.getEmail());
    }
    catch(Exception e)
    {
      throw new UnauthorizedException(Constants.UNAUTHORIZED);
    }
    
  }

}
