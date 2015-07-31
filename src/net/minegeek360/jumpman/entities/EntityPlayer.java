package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.particles.ParticleStep;
import net.minegeek360.jumpman.world.World;

public class EntityPlayer extends EntityLiving {

	int[]	playerCont		= { Input.KEY_D, Input.KEY_A, Input.KEY_W, Input.KEY_SPACE };
	int[]	playerAltCont	= { Input.KEY_D, Input.KEY_A, Input.KEY_K, Input.KEY_L };

	public EntityPlayer( World worldObj ) {
		super("Player", 35, 50, worldObj);
		this.setHealth(10000);
		this.maxHealth = 10000;
		this.setDisplayImage("entity.player.player");
		this.setMoveSpeed(5f);
		this.setJumpPower(10);
	}

	private boolean	canGoRight	= true;
	private boolean	canGoLeft	= true;

	public void createParticle() {
		if (!this.isInAir && worldObj.rand.nextInt(5) == 0)
			worldObj.particles.add(new ParticleStep(this.getPosX() + this.width / 2, this.getPosY() + this.height - 3, worldObj));
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		super.update(gc, sbg, delta);
		Input input = gc.getInput();
		if (input.isKeyDown(playerCont[0]) || input.isKeyDown(playerAltCont[0])) {
			if (this.canGoRight) {
				this.moveRight();
				createParticle();
			}
		}
		if (input.isKeyDown(playerCont[1]) || input.isKeyDown(playerAltCont[1])) {
			if (this.canGoLeft) {
				this.moveLeft();
				createParticle();
			}
		}
		if (input.isKeyDown(playerCont[2]) || input.isKeyDown(playerAltCont[2])) {
			this.jump();
		}
	}
}
