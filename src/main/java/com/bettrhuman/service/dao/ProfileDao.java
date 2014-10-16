package com.bettrhuman.service.dao;
import static com.googlecode.objectify.ObjectifyService.ofy;

import com.bettrhuman.service.models.Profile;
import com.googlecode.objectify.Key;

public class ProfileDao implements IProfileDao {

	@Override
	public Profile readProfile(Long profileId) {
		Key<Profile> key = Key.create(Profile.class, profileId);
		return ofy().load().key(key).safe();
	}
	
	@Override
	public Profile insertProfile(Profile profile) {
		ofy().save().entity(profile).now();
		return profile;
	}

}
