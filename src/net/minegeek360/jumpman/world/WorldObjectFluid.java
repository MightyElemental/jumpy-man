package net.minegeek360.jumpman.world;

@SuppressWarnings( "serial" )
public class WorldObjectFluid extends WorldObject {

	public WorldObjectFluid( float x, float y, float width, float height ) {
		super(x, y, width, height);
	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
