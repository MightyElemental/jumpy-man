package net.iridgames.jumpman.entities.particles;

import java.awt.Dimension;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.iridgames.jumpman.entities.Entity;
import net.iridgames.jumpman.world.World;

/**
 * @author WolfgangTS
 * @since 29/07/2015
 */
public abstract class EntityParticle extends Entity
{
	
	public int		lifetime;
	public boolean	dead	= false;
	public float	alpha	= 1;
	public Color	color	= new Color(255, 255, 255);

	public EntityParticle(String name, float posX, float posY, World worldObj)
	{
		super(name, posX, posY, worldObj);
		this.setDimensions(new Dimension(16, 16));
	}

	public void setDimensions(Dimension d)
	{
		this.setWidth(d.width);
		this.setHeight(d.height);
	}

	public void setLifetime(int l)
	{
		this.lifetime = l;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
	{
		super.update(gc, sbg, delta);
		this.alpha = 1 - (this.ticksAlive / this.lifetime);

		if (this.ticksAlive > this.lifetime)
		{
			this.dead = true;
		}
	}

}
