package com.bettrhuman.service.dao;

import com.bettrhuman.service.models.Human;
import com.bettrhuman.sleepyhead.api.models.FacebookIdentifier;

public interface IHumanDao {

	public Human insertHuman(Human human);

	public Human updateHuman(Human human);

	public Human readHuman(FacebookIdentifier identifier);

	
}
