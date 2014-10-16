package com.bettrhuman.sleepyhead.api.models;

import com.google.appengine.api.users.User;

public class UserCredential {

	User user;
	String facebookAccessToken;

	public UserCredential(User user, String facebookAccessToken) {
		this.user = user;
		this.facebookAccessToken = facebookAccessToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFacebookAccessToken() {
		return facebookAccessToken;
	}

	public void setFacebookAccessToken(String facebookAccessToken) {
		this.facebookAccessToken = facebookAccessToken;
	}

}
