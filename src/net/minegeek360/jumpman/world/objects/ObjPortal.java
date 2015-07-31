package net.minegeek360.jumpman.world.objects;

import org.newdawn.slick.Color;

import net.minegeek360.jumpman.entities.Entity;

public class ObjPortal extends WorldObject {

	private static final long serialVersionUID = 2977893535728416791L;

	public static final int	TYPE_BLUE	= 0;
	public static final int	TYPE_ORANGE	= 1;
	private int				type;
	private Color			portalColor	= Color.blue;
	private ObjPortal		connectedPortal;

	public ObjPortal( float x, float y, int type, boolean isVerticle ) {
		super(x, y, 70, 20, Material.matPortal);
		if (isVerticle) {
			this.setWidth(70);
			this.setHeight(20);
		} else {
			this.setWidth(20);
			this.setHeight(70);
		}
		this.type = type;
		switch (type) {
			case 0:
				portalColor = Color.blue;
				break;
			case 1:
				portalColor = Color.orange;
				break;
			default:
				portalColor = Color.blue;
				break;
		}
	}

	public ObjPortal( float x, float y, int type, boolean isVerticle, ObjPortal connectedPortal ) {
		this(x, y, type, isVerticle);
		this.connectedPortal = connectedPortal;
	}

	@Override
	public void onCollide(Entity entity) {// YOU REALLY NEED TO CHANGE THIS TO WORK!!!
		super.onCollide(entity);
		entity.setPosX(connectedPortal.getCenterX());
		entity.setPosY(connectedPortal.getCenterY());
	}

	public int getType() {
		return type;
	}

	public Color getPortalColor() {
		return portalColor;
	}

	public ObjPortal getConnectedPortal() {
		return connectedPortal;
	}

	public void setConnectedPortal(ObjPortal connectedPortal) {
		this.connectedPortal = connectedPortal;
	}

}
