package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.JumpMan;

/** @author MightyElemental */
public abstract class Entity {

	protected String entityName = "Undefined";

	protected boolean isSolid;

	protected float velocityX, velocityY, locationX, locationY;

	protected int sizeX, sizeY;

	protected Image displayImage = JumpMan.NULL_IMAGE;

	public Entity(String name, int sizeX, int sizeY) {
		this.entityName = name;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
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

	public int getSizeX() {
		return sizeX;
	}

	/** Sets the width of the entity
	 * 
	 * @param sizeX
	 *            the new width for the entity */
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	/** Sets the height of the entity
	 * 
	 * @param sizeY
	 *            the new height for the entity */
	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public Image getDisplayImage() {
		return displayImage;
	}

	/** Sets the image to be displayed
	 * 
	 * @param displayImage
	 *            the new image to be displayed
	 * @return Entity for ease in construction */
	public Entity setDisplayImage(Image displayImage) {
		this.displayImage = displayImage;
		return this;
	}

}
