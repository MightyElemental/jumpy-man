package net.minegeek360.jumpman.world;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.Entity;
import net.minegeek360.jumpman.entities.EntityPlayer;

public class World {

	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public void init(GameContainer gc, StateBasedGame sbg){
		entities.add(new EntityPlayer());
	}

}
