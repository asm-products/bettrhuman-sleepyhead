package com.bettrhuman.service;

import javax.inject.Inject;

import com.bettrhuman.service.dao.IHumanDao;
import com.bettrhuman.service.models.Human;
import com.bettrhuman.service.models.Profile;
import com.bettrhuman.sleepyhead.api.models.FacebookIdentifier;

public class HumanService implements IHumanService {

	IHumanDao humanDao;
	IProfileService profileService;
	
	
	@Inject
	public HumanService(IHumanDao humanDao, IProfileService profileService) {
		this.humanDao = humanDao;
		this.profileService = profileService;
	}

	@Override
	public Human login(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Human birth(FacebookIdentifier identifier) {

		Human human = null;
		
		human = humanDao.readHuman(identifier);
		if(human != null)
		{
			return human;
		}
		
		human = new Human();
		human.setFacebookUserId(identifier.getFacebookUserId());
		humanDao.insertHuman(human);
		Profile profile = profileService.createProfile(human);
		human.setProfile(profile);
		
		return humanDao.updateHuman(human);
	}

}
