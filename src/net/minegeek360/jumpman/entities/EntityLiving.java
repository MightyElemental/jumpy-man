package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.world.World;
import net.minegeek360.jumpman.world.objects.WorldObject;

public class EntityLiving extends Entity {

	public EntityLiving( String name, int sizeX, int sizeY, World worldObj ) {
		super(name, sizeX, sizeY, worldObj);
	}

	protected float		moveSpeed		= 2;
	protected float		jumpPower		= 20;
	protected int		maxHealth		= 20;
	protected int		health			= maxHealth;
	protected int		doubleJump		= 0;
	protected boolean	hasDoubleJump	= false;
	protected boolean	isInAir			= true;

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		super.update(gc, sbg, delta);
		float delta2 = delta / 16f;
		formatVelocity(worldObj);
		this.setPosX(this.getPosX() + (getVelocityX() * delta2));
		this.setPosY(this.getPosY() + (getVelocityY() * delta2));
		testAndHandleCollisions(delta2);
		if (isInAir) {
			this.velocityY += worldObj.gravity * delta2;
		}
	}

	private void formatVelocity(World worldObj) {
		float velShift = 10f;

		if (!isInAir) {
			if (velocityX >= moveSpeed) {
				velocityX = moveSpeed;
			} else if (velocityX <= -moveSpeed) {
				velocityX = -moveSpeed;
			}
			velShift = 10f;
		} else {
			velShift = 10000f;
		}

		if (velocityX > 0) {
			velocityX -= moveSpeed / velShift;
		} else if (velocityX < 0) {
			velocityX += moveSpeed / velShift;
		}

		if (velocityX > -0.19 && velocityX < 0.19) {
			velocityX = 0;
		}

		// Y Velocity
		if (velocityY > -0.19 && velocityY < 0.19) {
			velocityY = 0;
		}
	}

	public void testAndHandleCollisions(float delta) {
		boolean flag = false;
		for (WorldObject worldObject : worldObj.currentMapLoaded.objects) {
			if (worldObject.isSolid()) {
				if (this.getBoundsBottom().intersects(worldObject)) {
					this.velocityY = 0;
					this.setPosY(worldObject.getY() - this.height);
					flag = true;
				}
				if (this.getBoundsTop().intersects(worldObject)) {
					this.velocityY = 0;
					this.setPosY(worldObject.getY() + worldObject.getHeight() + 1);
				}
				if (this.getBoundsLeft().intersects(worldObject)) {
					this.velocityX = 0;
					this.setPosX(worldObject.getX() + worldObject.getWidth());
				}
				if (this.getBoundsRight().intersects(worldObject)) {
					this.velocityX = 0;
					this.setPosX(worldObject.getX() - this.width);
				}
			}
		}
		this.isInAir = !flag;
	}

	/** Adds velocity to the entity to move left */
	public void moveLeft() {
		if (velocityX < -moveSpeed) { return; }
		if (!isInAir) {
			this.velocityX -= moveSpeed;
		}
	}

	/** Adds velocity to the entity to move right */
	public void moveRight() {
		if (velocityX > moveSpeed) { return; }
		if (!isInAir) {
			this.velocityX += moveSpeed;
		}
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

	public float getJumpPower() {
		return jumpPower;
	}

	public void setJumpPower(float jumpPower) {
		this.jumpPower = jumpPower;
	}

}
