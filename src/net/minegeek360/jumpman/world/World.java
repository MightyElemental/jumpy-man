package net.minegeek360.jumpman.world;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.Entity;
import net.minegeek360.jumpman.entities.EntityPlayer;

public class World {

	public ArrayList<Entity>	entities	= new ArrayList<Entity>();
	public ArrayList<WorldMap>	mapArray	= new ArrayList<WorldMap>();

	/** The velocity to be added every tick the entities are not on the ground */
	public float gravity = 0.6f; // should be 9.8m/s/s (9.8m per second for every second in the air)

	public void init(GameContainer gc, StateBasedGame sbg) {
		entities.add(new EntityPlayer(this));
		WorldMap map = new WorldMap();
		map.init(gc, sbg);
		mapArray.add(map);
		currentMapLoaded = mapArray.get(0);
	}

	public WorldMap currentMapLoaded;

}
