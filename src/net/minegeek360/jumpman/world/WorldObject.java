package net.minegeek360.jumpman.world;

import java.awt.Rectangle;

@SuppressWarnings("serial")
public class WorldObject extends Rectangle {

	protected boolean isSolid = true;

	public WorldObject() {

	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

}
