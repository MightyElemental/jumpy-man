package net.minegeek360.jumpman.world.objects;

@SuppressWarnings( "serial" )
public class WorldObjectFluid extends WorldObject {

	public WorldObjectFluid( float x, float y, float width, float height ) {
		super(x, y, width, height, Material.matToxicWater);
	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
