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

	protected float ticksAlive;

	protected float velocityX, velocityY, posX, posY;

	protected int width, height;

	protected Image displayImage = JumpMan.NULL_IMAGE;

	protected World worldObj;

	public Entity( String name, int width, int height, World worldObj ) {
		this.entityName = name;
		this.width = width;
		this.height = height;
		this.worldObj = worldObj;
	}

	public Entity( String name, float posX, float posY, World worldObj ) {
		this.entityName = name;
		this.posX = posX;
		this.posY = posY;
		this.worldObj = worldObj;
	}

	public Entity( String name, World worldObj ) {
		this.entityName = name;
		this.worldObj = worldObj;
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle(this.posX, this.posY + 5, 5, this.height - 10);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle(posX + width - 5, posY + 5, 5, height - 10);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle(posX + (width / 2) - (width / 4), posY, width / 2, height / 2);
	}

	public Rectangle getBoundsBottom() {
		return new Rectangle(posX + (width / 2) - (width / 4), posY + (height / 2), width / 2, height / 2);
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
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		ticksAlive += 1 * delta / 16f;
	}

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
		return posX;
	}

	public void setPosX(float locationX) {
		this.posX = locationX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float locationY) {
		this.posY = locationY;
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

	/** The time in game ticks the entity has been alive */
	public float getTicksAlive() {
		return ticksAlive;
	}

}
