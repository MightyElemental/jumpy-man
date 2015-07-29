package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.world.World;
import net.minegeek360.jumpman.world.WorldObject;

public class EntityLiving extends Entity {

	public EntityLiving( String name, int sizeX, int sizeY, World worldObj ) {
		super(name, sizeX, sizeY, worldObj);
		this.worldObj = worldObj;
	}

	protected float		moveSpeed		= 2, jumpPower = 4;
	protected int		maxHealth		= 20;
	protected int		health			= maxHealth;
	protected int		doubleJump		= 0;
	protected boolean	hasDoubleJump	= false;
	protected boolean	isInAir			= true;

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {// SETUP THE
																			// COLLISIONS!!!!!!!!!!!
		float delta2 = delta / 16f;
		formatVelocity(worldObj);
		this.setPosX(this.getPosX() + (getVelocityX() * delta2));
		this.setPosY(this.getPosY() + (getVelocityY() * delta2));
		testAndHandleCollisions();
	}

	private void formatVelocity(World worldObj) {
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

		// Y Velocity
		if (isInAir) {
			this.velocityY += worldObj.gravity;// SETUP THE GRAVITY!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}

		if (velocityY > -0.19 && velocityY < 0.19) {
			velocityY = 0;
		}
	}

	public void testAndHandleCollisions() {
		boolean flag = false;
		for (WorldObject worldObject : worldObj.currentMapLoaded.objects) {
			if (worldObject.isSolid()) {
				if (this.getBoundsBottom().intersects(worldObject)) {
					this.velocityY = 0;
					this.setPosY(worldObject.getY() - this.height);
					this.isInAir = false;
					flag = true;
				}
				if (this.getBoundsTop().intersects(worldObject)) {
					this.velocityY = 0;
					this.setPosY(worldObject.getY()-worldObject.getHeight());
					this.isInAir = false;
					flag = true;
				}
			}
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

	/** Makes the entity jump */
	public void jump() {
		if (this.isInAir) { return; }
		if (hasDoubleJump && doubleJump < 2) { return; }
		this.velocityY -= jumpPower;
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
