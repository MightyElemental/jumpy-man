package net.minegeek360.jumpman.world;

public class WorldObject {

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
