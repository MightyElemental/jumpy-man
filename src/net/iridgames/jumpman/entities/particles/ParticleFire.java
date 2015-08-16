package net.iridgames.jumpman.entities.particles;

import java.awt.Dimension;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import net.iridgames.jumpman.world.World;
import net.iridgames.jumpman.world.objects.WorldObject;

/** @author WolfgangTS
 * @since 29/07/2015 */
public class ParticleFire extends EntityParticle {

	private Color[] colorPossibilities = { Color.red, Color.orange, Color.yellow };

	public ParticleFire( float x, float y, World worldObj ) {
		super("Fire Particle", x, y, worldObj);
		this.setDimensions(new Dimension(16, 16));
		this.velocityY = -3 - this.worldObj.rand.nextFloat();
		this.velocityX = this.worldObj.rand.nextFloat() * 2 - 1;
		this.lifetime = 50;
		this.setDisplayImage("entity.particle.blaze");

		this.color = this.colorPossibilities[this.worldObj.rand.nextInt(this.colorPossibilities.length)];
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		super.update(gc, sbg, delta);

		this.posX += this.velocityX * (delta / 16);
		this.posY += this.velocityY * (delta / 16);
		this.velocityX = (this.velocityX + (worldObj.rand.nextFloat() * 10 - 5f)) / 2;

		for (WorldObject obj : worldObj.currentMapLoaded.objects) {
			if (obj.intersects(new Rectangle(this.posX, this.posY, this.width, this.height))) {
				if (obj.isSolid()) {
					this.posY = obj.getY() + this.height;

					this.velocityX = 0;
					this.velocityY = 0;
				}
			}
		}
	}
}
