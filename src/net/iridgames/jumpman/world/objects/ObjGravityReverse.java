package net.iridgames.jumpman.world.objects;

import net.iridgames.jumpman.entities.Entity;

@SuppressWarnings( "serial" )
public class ObjGravityReverse extends WorldObject {

	private float gravitySpeed = -1.7f;

	public ObjGravityReverse( float x, float y, float w, float h ) {
		super(x, y, w, h, Material.matGravityUp);
	}

	public ObjGravityReverse( float x, float y, float w, float h, float speed ) {
		this(x, y, w, h);
	}

	@Override
	public void onCollide(Entity entity, int edge) {
		super.onCollide(entity);
		if (edge == Entity.EDGE_BOTTOM) {
			entity.addForceY(gravitySpeed);
		}
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	/** @return the gravitySpeed */
	public float getGravitySpeed() {
		return gravitySpeed;
	}

	/** @param gravitySpeed
	 *            the gravitySpeed to set */
	public ObjGravityReverse setGravitySpeed(float gravitySpeed) {
		this.gravitySpeed = gravitySpeed;
		return this;
	}

}
