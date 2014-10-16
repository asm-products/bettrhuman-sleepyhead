package com.bettrhuman.service;

import com.bettrhuman.service.models.Human;
import com.bettrhuman.sleepyhead.api.models.FacebookIdentifier;

public interface IHumanService {

	public Human login(String email);

	public Human birth(FacebookIdentifier identifier);

}
