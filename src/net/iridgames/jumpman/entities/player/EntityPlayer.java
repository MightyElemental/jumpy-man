package net.iridgames.jumpman.entities.player;

import java.lang.reflect.Field;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import net.iridgames.jumpman.entities.EntityLiving;
import net.iridgames.jumpman.entities.particles.ParticleStep;
import net.iridgames.jumpman.world.World;
import net.iridgames.jumpman.world.objects.Material;

public class EntityPlayer extends EntityLiving {

	public Inventory inventory = new Inventory();

	int[]	playerCont		= { Input.KEY_D, Input.KEY_A, Input.KEY_W, Input.KEY_SPACE };
	int[]	playerAltCont	= { Input.KEY_RIGHT, Input.KEY_LEFT, Input.KEY_Q, Input.KEY_E };

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
		if (this.isOnGround && worldObj.rand.nextInt(5) == 0)
			worldObj.createParticle(new ParticleStep(this.getPosX() + this.width / 2, this.getPosY() + this.height - 3, worldObj));
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		this.setHealth(10000);
		super.update(gc, sbg, delta);
		Field[] temp = Material.class.getFields();
		for (Field f : temp) {
			if (f.getType().equals(Material.class)) {
				System.out.println(f.getName());
			}
		}
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
