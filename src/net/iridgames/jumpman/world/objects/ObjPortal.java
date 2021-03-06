package net.iridgames.jumpman.world.objects;

import org.newdawn.slick.Color;

import net.iridgames.jumpman.entities.Entity;
import net.iridgames.jumpman.entities.particles.ParticlePortal;
import net.iridgames.jumpman.world.World;

public class ObjPortal extends WorldObject {

	private static final long serialVersionUID = 2977893535728416791L;

	public static final int	TYPE_BLUE	= 0;
	public static final int	TYPE_ORANGE	= 1;
	private int				type;
	private Color			portalColor	= Color.blue;
	private ObjPortal		connectedPortal;
	private World			worldObj;
	protected boolean		isLocked;

	public ObjPortal( float x, float y, int type, boolean isVerticle, World worldObj ) {
		super(x, y, 70, 20, Material.matPortal);
		this.worldObj = worldObj;
		if (!isVerticle) {
			this.setWidth(60);
			this.setHeight(this.getWidth() / 3.5f);
		} else {
			this.setHeight(60);
			this.setWidth(this.getHeight() / 3.5f);
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

	public boolean isSolid() {
		return false;
	}

	public ObjPortal( float x, float y, int type, boolean isVerticle, World worldObj, ObjPortal connectedPortal ) {
		this(x, y, type, isVerticle, worldObj);
		this.connectedPortal = connectedPortal;
	}

	@Override
	public void onCollide(Entity entity) {// YOU REALLY NEED TO CHANGE THIS TO WORK!!!
		super.onCollide(entity);
		if (connectedPortal == null) { return; }

		if (!entity.hasTeleported && this.type == ObjPortal.TYPE_ORANGE) {
			float destX = entity.getPosX() - this.getX() + connectedPortal.getX();
			float destY = entity.getPosY() - this.getY() + connectedPortal.getY();
			entity.setPosX(destX);
			entity.setPosY(destY);
			for (int i = 0; i < worldObj.rand.nextInt(10) + 20; i++) {
				worldObj.createParticle(new ParticlePortal(worldObj.rand.nextInt((int) connectedPortal.getWidth()) + connectedPortal.getX(),
						worldObj.rand.nextInt((int) connectedPortal.getHeight()) + connectedPortal.getY(), worldObj, connectedPortal));
			}
			entity.lastUsedPortal = this;
		}
	}

	public void lockPortal() {
		isLocked = true;
	}

	public void unlockPortal() {
		isLocked = false;
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

	public ObjPortal setConnectedPortal(ObjPortal connectedPortal) {
		this.connectedPortal = connectedPortal;
		return this;
	}

}
