package net.minegeek360.jumpman.world.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import net.minegeek360.jumpman.entities.Entity;

@SuppressWarnings( "serial" )
public class WorldObject extends Rectangle {

	protected boolean isSolid = true;

	protected Material material;

	public WorldObject( float x, float y, float width, float height, Material mat ) {
		super(x, y, width, height);
		this.material = mat;
	}

	public void onCollide(Entity entity) {
	}

	public boolean isSolid() {
		return isSolid;
	}

	public WorldObject setSolid(boolean isSolid) {
		this.isSolid = isSolid;
		return this;
	}

	public Material getMaterial() {
		return material;
	}

	public Image getTexture() {
		if (material == null) {
			System.err.println("Material = null!");
		} else if (material.getTexture() == null) {
			System.err.println("Texture = null!");
		}
		return material.getTexture();
	}

}
