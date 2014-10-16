package com.bettrhuman.sleepyhead.api.models;

import com.bettrhuman.service.models.Human;

public class HumanEntity {

	private String email;
	private ProfileEntity profile;
	
	public HumanEntity(Human h)
	{
		this.email = h.getEmail();
		this.profile = new ProfileEntity(h.getProfile());
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}
}
