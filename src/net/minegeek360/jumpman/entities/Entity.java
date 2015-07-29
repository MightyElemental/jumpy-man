package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.JumpMan;
import net.minegeek360.jumpman.world.World;

/** @author MightyElemental */
public abstract class Entity {

	protected String entityName = "Undefined";

	protected boolean isSolid;

	protected float velocityX, velocityY, locationX, locationY = 50;

	protected int width, height;

	protected Image displayImage = JumpMan.NULL_IMAGE;

	protected World worldObj;

	public Entity( String name, int sizeX, int sizeY, World worldObj ) {
		this.entityName = name;
		this.width = sizeX;
		this.height = sizeY;
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle(this.locationX, this.locationY + 5, 5, this.height - 10);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle(locationX + width - 5, locationY + 5, 5, height - 10);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle(locationX + (width / 2) - (width / 4), locationY, width / 2, height / 2);
	}

	public Rectangle getBoundsBottom() {
		return new Rectangle(locationX + (width / 2) - (width / 4), locationY + (height / 2), width / 2, height / 2);
	}

	public String getName() {
		return entityName;
	}

	/** Sets the entity's name
	 * 
	 * @param name
	 *            the new name given to the entity
	 * @return Entity for ease in construction */
	public Entity setName(String name) {
		entityName = name;
		return this;
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

	public float getPosX() {
		return locationX;
	}

	public void setPosX(float locationX) {
		this.locationX = locationX;
	}

	public float getPosY() {
		return locationY;
	}

	public void setPosY(float locationY) {
		this.locationY = locationY;
	}

	public int getWidth() {
		return width;
	}

	/** Sets the width of the entity
	 * 
	 * @param sizeX
	 *            the new width for the entity */
	public void setWidth(int sizeX) {
		this.width = sizeX;
	}

	public int getHeight() {
		return height;
	}

	/** Sets the height of the entity
	 * 
	 * @param sizeY
	 *            the new height for the entity */
	public void setHeight(int sizeY) {
		this.height = sizeY;
	}

	/** @return displayImage the entity's display image */
	public Image getDisplayImage() {
		return displayImage;
	}

	/** Sets the image to be displayed
	 * 
	 * @param displayImage
	 *            the new image to be displayed
	 * @return Entity for ease in construction */
	public Entity setDisplayImage(String displayImage) {
		this.displayImage = JumpMan.resLoader.loadImage(displayImage);
		return this;
	}

}
