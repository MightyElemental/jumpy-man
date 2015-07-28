package net.minegeek360.jumpman.world;

import java.awt.Rectangle;

@SuppressWarnings( "serial" )
public class WorldObject extends Rectangle {

	protected boolean isSolid = true;

	public float x, y, width, height;

	public WorldObject( float x, float y, float width, float height ) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

}
