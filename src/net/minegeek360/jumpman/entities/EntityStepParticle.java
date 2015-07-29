package net.minegeek360.jumpman.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.world.World;

public class EntityStepParticle extends Entity
{
	public EntityStepParticle(String name, World worldObj)
	{
		super(name, 1, 1, worldObj);
		this.velocityY = 20;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
	{
		this.locationX+=this.velocityX*(delta/17);
		this.locationY+=this.velocityY*(delta/17);
		
		this.velocityX/=2*(delta/17);
		this.velocityY-=worldObj.gravity*(delta/17);
	}
}
