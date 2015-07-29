package net.minegeek360.jumpman.entities.particles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.Entity;
import net.minegeek360.jumpman.world.World;

public abstract class EntityParticle extends Entity {

	public EntityParticle( String name, float posX, float posY, World worldObj ) {
		super(name, posX, posY, worldObj);
	}

	@Override
	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta);

}
