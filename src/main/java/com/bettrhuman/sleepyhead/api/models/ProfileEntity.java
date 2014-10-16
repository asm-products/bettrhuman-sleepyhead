package com.bettrhuman.sleepyhead.api.models;

import com.bettrhuman.service.models.Profile;

public class ProfileEntity {

	private Long id;

	public ProfileEntity(Profile profile) {
		this.id = profile.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
