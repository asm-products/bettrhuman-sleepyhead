package com.bettrhuman.service.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import com.bettrhuman.service.models.Human;

public class HumanDao implements IHumanDao{

	@Override
	public Human insertHuman(Human human) {
		ofy().save().entity(human).now();
		return human;
	}

	@Override
	public Human updateHuman(Human human) {
		ofy().save().entity(human).now();
		return human;
	}

}
