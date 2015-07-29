package net.minegeek360.jumpman.entities.monsters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.EntityAI;
import net.minegeek360.jumpman.world.World;

public class EntityMonster extends EntityAI {

	public EntityMonster( String name, int sizeX, int sizeY ) {
		super(name, sizeX, sizeY);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta, World worldObj) {
		super.update(gc, sbg, delta, worldObj);
	}

	@Override
	public void think(GameContainer gc, StateBasedGame sbg, int delta) {

	}

}
