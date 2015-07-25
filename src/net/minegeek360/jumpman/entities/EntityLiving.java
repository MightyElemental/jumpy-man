package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class EntityLiving extends Entity {

	public EntityLiving(String name, int sizeX, int sizeY) {
		super(name, sizeX, sizeY);
	}

	protected float moveSpeed;
	protected int maxHealth = 20;
	protected int health = maxHealth;

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		float delta2 = delta / 16f;
		formatVelocity();
		this.setLocationX(this.getLocationX() + (getVelocityX() * delta2));
		this.setLocationY(this.getLocationY() + (getVelocityY() * delta2));
	}

	private void formatVelocity() {
		int velShift = 10;

		if (velocityX > 0) {
			velocityX -= moveSpeed / velShift;
		} else if (velocityX < 0) {
			velocityX += moveSpeed / velShift;
		}
		if (velocityX >= moveSpeed) {
			velocityX = moveSpeed;
		} else if (velocityX <= -moveSpeed) {
			velocityX = -moveSpeed;
		}

		if (velocityX > -0.19 && velocityX < 0.19) {
			velocityX = 0;
		}

		if (velocityY > 0) {
			velocityY -= moveSpeed / velShift;
		} else if (velocityY < 0) {
			velocityY += moveSpeed / velShift;
		}
		if (velocityY >= moveSpeed) {
			velocityY = moveSpeed;
		} else if (velocityY <= -moveSpeed) {
			velocityY = -moveSpeed;
		}

		if (velocityY > -0.19 && velocityY < 0.19) {
			velocityY = 0;
		}
	}

	/** Adds velocity to the entity to move left */
	public void moveLeft() {
		if (velocityX < -moveSpeed) { return; }
		this.velocityX -= moveSpeed;
	}

	/** Adds velocity to the entity to move right */
	public void moveRight() {
		if (velocityX > moveSpeed) { return; }
		this.velocityX += moveSpeed;
	}

	/** Adds velocity to the entity to move up */
	public void moveUp() {
		if (velocityY < -moveSpeed) { return; }
		this.velocityY -= moveSpeed;
	}

	/** Adds velocity to the entity to move down */
	public void moveDown() {
		if (velocityY > moveSpeed) { return; }
		this.velocityY += moveSpeed;
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

	/** Gets the max health that the entity can have */
	public int getMaxHealth() {
		return maxHealth;
	}

	/** Sets the max health of the entity
	 * 
	 * @param maxHealth
	 *            the new max health for the entity
	 * @return Entity for ease when constructing */
	public Entity setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		return this;
	}

	/** Gets the health of the entity */
	public int getHealth() {
		return health;
	}

	/** Sets the health of the entity
	 * 
	 * @param health
	 *            the new health to be set */
	public void setHealth(int health) {
		this.health = health;
	}

}
