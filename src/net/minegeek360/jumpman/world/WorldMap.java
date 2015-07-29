package net.minegeek360.jumpman.world;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class WorldMap {

	public ArrayList<WorldObject> objects = new ArrayList<WorldObject>();

	public void init(GameContainer gc, StateBasedGame sbg) {
		// objects.add(new WorldBlock(500, 170, 4000, 10));
		objects.add(new WorldBlock(0, 500, 4000, 50));
		objects.add(new WorldBlock(800, 50, 10, 500));
		objects.add(new WorldBlock(80, 50, 10, 500).setSolid(false));
		objects.add(new WorldObjectFluid(0, gc.getHeight() - 50, gc.getWidth(), 50));
	}
}
