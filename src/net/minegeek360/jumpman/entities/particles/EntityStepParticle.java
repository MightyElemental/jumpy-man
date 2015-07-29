package net.minegeek360.jumpman.entities.particles;

import java.awt.Dimension;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.world.World;
import net.minegeek360.jumpman.world.objects.WorldObject;

/** @author WolfgangTS
 * @since 29/07/2015 */
public class EntityStepParticle extends EntityParticle {

	public EntityStepParticle( float x, float y, World worldObj ) {
		super("Step Particle", x, y, worldObj);
		this.setDimensions(new Dimension(4, 4));
		this.velocityY = -5 - this.worldObj.rand.nextFloat() * 5;
		this.velocityX = this.worldObj.rand.nextFloat() * 5 - 10;
		this.lifetime = 100;

		this.setDisplayImage("entity.particle.walk");
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		super.update(gc, sbg, delta);

		this.posX += this.velocityX * (delta / 16);
		this.posY += this.velocityY * (delta / 16);

		this.velocityX /= 2 * (delta / 16);
		this.velocityY += worldObj.gravity * (delta / 16);

		for (WorldObject obj : worldObj.currentMapLoaded.objects) {
			if (obj.intersects(new Rectangle(this.posX, this.posY, this.width, this.height))) {
				this.posY = obj.getY() - this.height;

				this.velocityX = 0;
				this.velocityY = 0;
			}
		}
	}
}
