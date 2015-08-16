package net.minegeek360.jumpman.world.objects;

import net.minegeek360.jumpman.entities.Entity;

@SuppressWarnings( "serial" )
public class ObjBouncePad extends WorldObject {

	public ObjBouncePad( float x, float y ) {
		super(x, y, 30, 20, Material.matBouncy);
	}

	@Override
	public void onCollide(Entity entity, int edge) {
		super.onCollide(entity);
		if (edge == Entity.EDGE_BOTTOM) {
			if(entity.getVelocityY() >= 9f){
				entity.setVelocityY(-entity.getVelocityY() / 0.8f);
			}
		}

	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
