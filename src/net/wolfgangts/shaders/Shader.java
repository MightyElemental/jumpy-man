package net.wolfgangts.shaders;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Shader
{
	private float x,y;
	private float magnitude = 50f;
	private int strength  = 100;
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	{
		g.setColor(new Color(255,255,255,255));
		for (int i = 0; i < this.strength; i++)
		{
			g.drawLine(
					this.x, 
					this.y, 
					(float) Math.sin(i) * this.magnitude + this.x, 
					(float) Math.cos(i) * this.magnitude + this.y);
		}
		
		
	}
	
	public void setPosition(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
}