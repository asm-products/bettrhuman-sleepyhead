package com.bettrhuman.sleepyhead.api.models;

import com.bettrhuman.service.models.Human;

public class HumanEntity {

	private String email;
	
	public HumanEntity(Human h)
	{
		this.email = h.getEmail();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
