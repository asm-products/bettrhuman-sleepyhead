package com.bettrhuman.sleepyhead.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.apache.http.client.utils.URIBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import com.bettrhuman.service.IHumanService;
import com.bettrhuman.service.models.Human;
import com.bettrhuman.service.utilities.Constants;
import com.bettrhuman.sleepyhead.api.models.FacebookUser;
import com.bettrhuman.sleepyhead.api.models.UserCredential;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;

public class AuthFilter implements IAuthFilter {
	
	private static final Logger log = Logger
			.getLogger(AuthFilter.class.getName());

	private IHumanService humanService;
	private ObjectMapper mapper;

	@Inject
	public AuthFilter(IHumanService humanService, ObjectMapper mapper) {
		super();
		this.humanService = humanService;
		this.mapper = mapper;
	}

	@Override
	public Human authenticate(UserCredential user) throws UnauthorizedException {
		String email = null;
		
		if (user.getUser() != null) {
			email = user.getUser().getEmail();
		}
		
		if(user.getFacebookAccessToken() != null)
		{
			try {
				email = this.facebookAuthenticate(user.getFacebookAccessToken()).getEmail();
			} catch (Exception e) {
				log.log(Level.SEVERE, "Facebook auth didn't work.");
			}
		}
		
		if(email == null) {
			throw new UnauthorizedException(Constants.UNAUTHENTICATED);
		}
		
		return humanService.login(email);
	}

	@Override
	public void authorize(User user, String resource) throws UnauthorizedException {
//			throws UnauthorizedException {
//		this.authenticate(user);
//		Human n = null;
//
//		try {
//			n = humanService.login(user.getEmail());
//		} catch (Exception e) {
//			throw new UnauthorizedException(Constants.UNAUTHORIZED);
//		}

	}

	@Override
	public FacebookUser facebookAuthenticate(String accessToken)
			throws URISyntaxException, IOException {
		URL url = new URIBuilder(
				"https://graph.facebook.com/oauth/access_token")
				.addParameter("grant_type", "fb_exchange_token")
				.addParameter("client_id", "1469036020045001")
				.addParameter("client_secret",
						"53b5beacd6b79613d3945d1d6fe08305")
				.addParameter("fb_exchange_token", accessToken).build().toURL();
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String token = response.toString().substring(response.indexOf("=") + 1,
				response.indexOf("&"));

		URL url2 = new URIBuilder("https://graph.facebook.com/me")
				.addParameter("access_token", token).build().toURL();
		HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
		con2.setRequestMethod("GET");
		int responseCode2 = con2.getResponseCode();
		BufferedReader in2 = new BufferedReader(new InputStreamReader(
				con2.getInputStream()));
		String inputLine2;
		StringBuffer response2 = new StringBuffer();

		while ((inputLine2 = in2.readLine()) != null) {
			response2.append(inputLine2);
		}
		in2.close();

		return mapper.readValue(response2.toString(), FacebookUser.class);
	}

}
