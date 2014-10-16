package com.bettrhuman.sleepyhead.api;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.bettrhuman.service.IHumanService;
import com.bettrhuman.service.exceptions.UserDoesNotExistException;
import com.bettrhuman.service.models.Human;
import com.bettrhuman.service.utilities.Constants;
import com.bettrhuman.sleepyhead.api.models.FacebookIdentifier;
import com.bettrhuman.sleepyhead.api.models.HumanEntity;
import com.bettrhuman.sleepyhead.api.models.UserCredential;
import com.bettrhuman.sleepyhead.utilities.IAuthFilter;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;

@Api(name = "humans", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
		Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
		Constants.IOS_CLIENT_ID,
		com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID }, audiences = { Constants.ANDROID_AUDIENCE })
public class HumanAPI {

	private static final Logger log = Logger
			.getLogger(HumanAPI.class.getName());

	private IAuthFilter authFilter;
	private IHumanService humanService;

	@Inject
	public HumanAPI(IAuthFilter authFilter, IHumanService humanService) {
		this.authFilter = authFilter;
		this.humanService = humanService;
	}

	@ApiMethod(name = "login", httpMethod = HttpMethod.GET, path = "human/login")
	public HumanEntity login(User user, @Nullable @Named("fbAccessToken") String fbAccessToken) throws UnauthorizedException,
			UserDoesNotExistException {
		
		Human human = authFilter.authenticate(new UserCredential(user, fbAccessToken));

		return new HumanEntity(human);
	}

	@ApiMethod(name = "createUser", httpMethod = HttpMethod.POST, path = "human/facebookIdentifier")
	public HumanEntity createUser(User user,
			@Named("fbAccessToken") String fbAccessToken,
			FacebookIdentifier facebookUserId) throws UnauthorizedException {
		Human human = authFilter.authenticate(new UserCredential(user, fbAccessToken));
		
		return new HumanEntity(humanService.birth(facebookUserId));
	}
}
