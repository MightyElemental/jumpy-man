package net.minegeek360.jumpman.entities.monsters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.EntityAI;
import net.minegeek360.jumpman.world.World;

public class EntityMonster extends EntityAI {

	public EntityMonster( String name, int sizeX, int sizeY, World worldObj ) {
		super(name, sizeX, sizeY, worldObj);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		super.update(gc, sbg, delta);
	}

	@Override
	public void think(GameContainer gc, StateBasedGame sbg, int delta) {

	}

}
