package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Entity {

	private String entityName = "Undefined";

	public Entity(String name) {
		this.entityName = name;
	}

	public String getName() {
		return entityName;
	}

	public void setName(String name) {
		entityName = name;
	}
	
	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta);

}
