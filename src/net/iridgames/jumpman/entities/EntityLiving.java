package net.iridgames.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.iridgames.jumpman.world.World;

public class EntityLiving extends Entity {

	public EntityLiving( String name, int sizeX, int sizeY, World worldObj ) {
		super(name, sizeX, sizeY, worldObj);
	}

	protected float	moveSpeed	= 2;
	/** How many meters in the air */
	protected float	jumpPower	= 1;

	protected int	maxHealth	= 20;
	protected int	health		= maxHealth;
	protected int	doubleJump	= 0;

	protected boolean hasDoubleJump = false;

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		super.update(gc, sbg, delta);
		float delta2 = delta / 16f;
		formatVelocity(worldObj);
		this.setPosX(this.getPosX() + (getVelocityX() * delta2));
		this.setPosY(this.getPosY() + (getVelocityY() * delta2));
		handleCollisionsAdvanced();
		// float temp = (float) ((worldObj.gravity / 200.0) * delta2); // GRAVITY IS MESSED UP!!!
		// System.out.println(temp);
		if (isInAir) {
			this.velocityY += worldObj.gravity;
		}
		if (isInFluid) {
			this.velocityY += worldObj.gravity * 4;
		}
		if (this.getCollidingMaterial() != null) {
			if (this.getCollidingMaterial().isToxic()) {
				this.setHealth(this.getHealth() - 2);
			}
		}
		if (this.getHealth() <= 0) {
			this.setDead(true);
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

		if (this.isInAir) {
			// System.out.println(this.terminalVelocity);
			if (velocityY > this.terminalVelocity) {

			}
		}

		// Y Velocity
		if (velocityY > -0.19 && velocityY < 0.19) {
			velocityY = 0;
		}
	}

	/** Adds velocity to the entity to move left */
	public void moveLeft() {
		if (velocityX < -moveSpeed) { return; }
		if (!isInAir) {
			this.velocityX -= moveSpeed;
		} else {
			this.velocityX -= moveSpeed / 20f;
		}
		this.facingLeft = true;
	}

	/** Adds velocity to the entity to move right */
	public void moveRight() {
		if (velocityX > moveSpeed) { return; }
		if (!isInAir) {
			this.velocityX += moveSpeed;
		} else {
			this.velocityX += moveSpeed / 20f;
		}
		this.facingLeft = false;
	}

	/** Adds velocity to the entity to move up */
	public void moveUp() {
		if (!isInAir) {
			this.velocityY += moveSpeed / 2;
		}
	}

	/** Adds velocity to the entity to move up */
	public void moveUp(float amount) {
		if (!isInAir) {
			this.velocityY += amount;
		}
	}

	/** Makes the entity jump */
	public void jump() {
		if (this.isInAir) { return; }
		if (hasDoubleJump && doubleJump < 2) { return; }
		moveUp(-jumpPower);
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
