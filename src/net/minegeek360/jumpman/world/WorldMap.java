package net.minegeek360.jumpman.world;

import java.util.ArrayList;

public class WorldMap {

	public ArrayList<WorldObject> objects = new ArrayList<WorldObject>();

	public void init() {
		objects.add(new WorldBlock(500, 170, 4000, 10));
		objects.add(new WorldBlock(0, 300, 4000, 10));
	}

}
