package net.iridgames.jumpman.world.objects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import net.iridgames.jumpman.entities.Entity;

@SuppressWarnings( "serial" )
public class WorldObject extends Rectangle {

	protected boolean isSolid = true;

	protected Material material;

	public WorldObject( float x, float y, float width, float height, Material mat ) {
		super(x, y, width, height);
		this.material = mat;
	}

	public void onCollide(Entity entity, int edge) {
		onCollide(entity);
	}

	public void onCollide(Entity entity) {
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {

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
