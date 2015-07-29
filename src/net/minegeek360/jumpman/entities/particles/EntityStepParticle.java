package net.minegeek360.jumpman.entities.particles;

import java.awt.Dimension;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.world.World;

public class EntityStepParticle extends EntityParticle
{
	public EntityStepParticle(float x, float y, World worldObj)
	{
		super("Step Particle", x, y, worldObj);
		this.setDimensions(new Dimension(50, 50));
		this.velocityY = 20;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
	{
		this.posX+=this.velocityX*(delta/17);
		this.posY+=this.velocityY*(delta/17);
		
		this.velocityX/=2*(delta/17);
		this.velocityY-=worldObj.gravity*(delta/17);
	}
}
