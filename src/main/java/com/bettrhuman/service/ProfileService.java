package com.bettrhuman.service;

import javax.inject.Inject;

import com.bettrhuman.service.dao.IProfileDao;
import com.bettrhuman.service.models.Human;
import com.bettrhuman.service.models.Profile;

public class ProfileService implements IProfileService {

	IProfileDao profileDao;
	
	@Inject
	public ProfileService(IProfileDao profileDao) {
		this.profileDao = profileDao;
	}
	
	@Override
	public Profile readProfile(Long profileId) {
		return profileDao.readProfile(profileId);
	}
	
	@Override
	public Profile createProfile(Human human) {
		Profile profile = new Profile();
		profile.setHuman(human);
		return profileDao.insertProfile(profile);
	}

}
