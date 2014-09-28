package com.bettrhuman.sleepyhead.api.models;

import com.bettrhuman.service.models.Human;

import lombok.Data;

@Data
public class HumanEntity {
	
	private String email;
	
	public HumanEntity(Human h)
	{
		this.email = h.getEmail();
	}
}
