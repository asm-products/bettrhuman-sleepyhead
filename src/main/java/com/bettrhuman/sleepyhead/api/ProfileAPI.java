package com.bettrhuman.sleepyhead.api;

import java.util.logging.Logger;

import com.bettrhuman.service.IProfileService;
import com.bettrhuman.service.utilities.Constants;
import com.bettrhuman.sleepyhead.api.models.ProfileEntity;
import com.bettrhuman.sleepyhead.utilities.IAuthFilter;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;

@Api(name = "profiles", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
		Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
		Constants.IOS_CLIENT_ID,
		com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID }, audiences = { Constants.ANDROID_AUDIENCE })
public class ProfileAPI {

	private static final Logger log = Logger.getLogger(ProfileAPI.class
			.getName());

	private IAuthFilter authFilter;
	private IProfileService profileService;

	public ProfileAPI(IAuthFilter authFilter, IProfileService profileService) {
		this.authFilter = authFilter;
		this.profileService = profileService;
	}

	@ApiMethod(name = "readProfile", httpMethod = HttpMethod.GET, path = "{profileId}")
	public ProfileEntity login(User user, @Named("profileId") Long profileId)
			throws UnauthorizedException {
		authFilter.authenticate(user);

		return new ProfileEntity(profileService.readProfile(profileId));
	}
}
