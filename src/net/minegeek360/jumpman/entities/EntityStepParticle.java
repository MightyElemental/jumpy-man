package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.world.World;

public class EntityStepParticle extends Entity
{
	public EntityStepParticle(float x, float y, World worldObj)
	{
		super("Step Particle", 5, 5, worldObj);
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
