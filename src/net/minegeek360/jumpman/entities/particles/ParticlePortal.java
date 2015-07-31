package net.minegeek360.jumpman.entities.particles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.world.World;
import net.minegeek360.jumpman.world.objects.ObjPortal;

public class ParticlePortal extends EntityParticle {

	public ParticlePortal( float x, float y, World worldObj, ObjPortal portal ) {
		super("Portal Particle", x, y, worldObj);
		this.setPosX(x - (this.width / 2));
		this.setPosY(y - (this.height / 2));
		this.velocityY = -this.worldObj.rand.nextFloat() + this.worldObj.rand.nextFloat();
		this.velocityX = this.worldObj.rand.nextFloat() * 2 - 1;
		this.lifetime = 40;
		this.setDisplayImage("entity.particle.portal");
		this.alpha = 0.2f;

		this.color = portal.getPortalColor();

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		super.update(gc, sbg, delta);

		this.posX += this.velocityX * (delta / 16);
		this.posY += this.velocityY * (delta / 16);
		this.velocityX = (this.velocityX + (worldObj.rand.nextFloat() * 10 - 5f)) / 2;
	}

}
