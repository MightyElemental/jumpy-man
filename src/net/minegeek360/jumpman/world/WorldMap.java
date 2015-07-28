package net.minegeek360.jumpman.world;

import java.util.ArrayList;

public class WorldMap {

	public ArrayList<WorldObject> objects = new ArrayList<WorldObject>();

	public void init() {
		objects.add(new WorldBlock(50, 50, 400, 10));
	}

}
