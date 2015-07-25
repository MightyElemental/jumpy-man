package net.minegeek360.jumpman.world;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.Entity;
import net.minegeek360.jumpman.entities.EntityPlayer;

public class World {

	public ArrayList<Entity> entities = new ArrayList<Entity>();

	/** The velocity to be added every tick the entities are not on the ground */
	public float gravity = 1f;

	public void init(GameContainer gc, StateBasedGame sbg) {
		entities.add(new EntityPlayer());
	}
	
	public WorldMap currentMapLoaded;

}
