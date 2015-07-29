package net.minegeek360.jumpman.world;

import org.newdawn.slick.geom.Rectangle;

@SuppressWarnings( "serial" )
public class WorldObject extends Rectangle {

	protected boolean isSolid = true;

	public WorldObject( float x, float y, float width, float height ) {
		super(x, y, width, height);
	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

}
