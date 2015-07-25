package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class EntityLiving extends Entity {

	public EntityLiving(String name, int sizeX, int sizeY) {
		super(name, sizeX, sizeY);
	}

	protected float moveSpeed;

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {

	}

	/** Adds velocity to the entity to move left */
	public void moveLeft() {
		if (velocityX < -moveSpeed) { return; }
		this.velocityX -= moveSpeed / 4;
	}

	/** Adds velocity to the entity to move right */
	public void moveRight() {
		if (velocityX > moveSpeed) { return; }
		this.velocityX += moveSpeed / 4;
	}

	/** Adds velocity to the entity to move up */
	public void moveUp() {
		if (velocityY < -moveSpeed) { return; }
		this.velocityY -= moveSpeed / 4;
	}

	/** Adds velocity to the entity to move down */
	public void moveDown() {
		if (velocityY > moveSpeed) { return; }
		this.velocityY += moveSpeed / 4;
	}

	/** Gets the speed at which the entity moves */
	public float getMoveSpeed() {
		return moveSpeed;
	}

	/** Sets the speed at which the entity is to move
	 * 
	 * @param moveSpeed
	 *            the new speed for the entity to move at
	 * @return Entity for ease when constructing */
	public Entity setMoveSpeed(float moveSpeed) {
		this.moveSpeed = moveSpeed;
		return this;
	}

}
