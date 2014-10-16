package com.bettrhuman.service.dao;

import com.bettrhuman.service.models.Profile;

public interface IProfileDao {

	public Profile readProfile(Long profileId);

	Profile insertProfile(Profile profile);

}
