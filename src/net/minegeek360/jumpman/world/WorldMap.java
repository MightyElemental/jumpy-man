package net.minegeek360.jumpman.world;

import java.util.ArrayList;

public class WorldMap {

	public ArrayList<WorldObject> objects = new ArrayList<WorldObject>();

	public void init() {
		objects.add(new WorldBlock(0, 170, 4000, 10));
	}

}
