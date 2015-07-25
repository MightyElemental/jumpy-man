package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Entity {

	protected String entityName = "Undefined";

	protected boolean isSolid;

	protected float velocityX, velocityY, locationX, locationY;

	public Entity(String name) {
		this.entityName = name;
	}

	public String getName() {
		return entityName;
	}

	public void setName(String name) {
		entityName = name;
	}

	/** Used to update the entity so it can move / think etc.
	 * 
	 * @param gc
	 *            the window the game is in
	 * @param sbg
	 *            the variable that holds the state
	 * @param delta
	 *            the time passed since the last update */
	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta);

	public boolean isSolid() {
		return isSolid;
	}

	public Entity setSolid(boolean isSolid) {
		this.isSolid = isSolid;
		return this;
	}

	public float getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(float velocityX) {
		this.velocityX = velocityX;
	}

	public float getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(float velocityY) {
		this.velocityY = velocityY;
	}

	public float getLocationX() {
		return locationX;
	}

	public void setLocationX(float locationX) {
		this.locationX = locationX;
	}

	public float getLocationY() {
		return locationY;
	}

	public void setLocationY(float locationY) {
		this.locationY = locationY;
	}

}
