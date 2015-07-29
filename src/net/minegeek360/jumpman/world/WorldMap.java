package net.minegeek360.jumpman.world;

import java.util.ArrayList;

public class WorldMap {

	public ArrayList<WorldObject> objects = new ArrayList<WorldObject>();

	public void init() {
		// objects.add(new WorldBlock(500, 170, 4000, 10));
		objects.add(new WorldBlock(0, 500, 4000, 50));
		objects.add(new WorldBlock(800, 50, 10, 500));
		objects.add(new WorldBlock(80, 50, 10, 500));
	}

}
