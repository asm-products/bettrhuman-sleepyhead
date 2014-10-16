package com.bettrhuman.service.models;

import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Profile {

	@Id
	private Long id;
	@Load
	private Ref<Human> human;
	private List<Key<Picture>> pictures;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Human getHuman() {
		return human.get();
	}
	
	public void setHuman(Human human) {
		this.human = Ref.create(human);
	}

	public List<Key<Picture>> getPictures() {
		return pictures;
	}

	public void setPictures(List<Key<Picture>> pictures) {
		this.pictures = pictures;
	}


}
