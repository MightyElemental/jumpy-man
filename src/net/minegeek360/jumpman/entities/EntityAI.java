package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public abstract class EntityAI extends EntityLiving {

	public EntityAI(String name, int sizeX, int sizeY) {
		super(name, sizeX, sizeY);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		think(gc, sbg, delta);
	}

	public abstract void think(GameContainer gc, StateBasedGame sbg, int delta);

}
