package com.bettrhuman.service;

import com.bettrhuman.service.models.Human;
import com.bettrhuman.service.models.Profile;

public interface IProfileService {

	public Profile readProfile(Long profileId);

	public Profile createProfile(Human human);

}
