package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.world.World;

public class EntityPlayer extends EntityLiving {

	int[] playerCont = { Input.KEY_D, Input.KEY_A, Input.KEY_W, Input.KEY_SPACE };

	public EntityPlayer() {
		super("Player", 35, 50);
		this.setHealth(50);
		this.maxHealth = 50;
		this.setDisplayImage("entity.player.player_stand");
		this.setMoveSpeed(2f);
	}

	private boolean	canGoRight	= true;
	private boolean	canGoLeft	= true;

	public void update(GameContainer gc, StateBasedGame sbg, int delta, World worldObj) {
		super.update(gc, sbg, delta, worldObj);
		Input input = gc.getInput();
		if (input.isKeyDown(playerCont[0])) {
			if (this.canGoRight) {
				this.moveRight();
			}
		}
		if (input.isKeyDown(playerCont[1])) {
			if (this.canGoLeft) {
				this.moveLeft();
			}
		}
		if (input.isKeyDown(playerCont[2])) {
			this.jump();
		}
	}
}
