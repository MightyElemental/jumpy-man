package net.minegeek360.jumpman.world.objects;

import org.newdawn.slick.geom.Rectangle;

@SuppressWarnings( "serial" )
public class WorldObject extends Rectangle {

	protected boolean isSolid = true;

	protected Material material;

	public WorldObject( float x, float y, float width, float height, Material mat ) {
		super(x, y, width, height);
		this.material = mat;
	}

	public boolean isSolid() {
		return isSolid;
	}

	public WorldObject setSolid(boolean isSolid) {
		this.isSolid = isSolid;
		return this;
	}

}
