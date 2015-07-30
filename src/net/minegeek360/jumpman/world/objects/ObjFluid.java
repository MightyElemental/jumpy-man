package net.minegeek360.jumpman.world.objects;

@SuppressWarnings( "serial" )
public class ObjFluid extends WorldObject {

	public ObjFluid( float x, float y, float width, float height, Material mat ) {
		super(x, y, width, height, mat);
	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
