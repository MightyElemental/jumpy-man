package net.wolfgangts.gui;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author WolfgangTS
 * @author James - size and colour
 * */
public class Render3D
{
	private ArrayList<float[]>	objects			= new ArrayList<float[]>();
	private float				gameTime;
	private float				fov				= 250;
	private float				renderDistance	= 5000;

	private Random random 		= new Random();
	private String copyright 	= "\u00a92014 MightyElemental\nMenu and starfield by WolfgangTS";

	public Render3D()
	{
		this.gameTime = 0;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	{
		for (float[] item : this.objects)
		{
			
			float x, y, z;

			x = item[0];
			y = item[1];
			z = item[2];

			if (z > 0 && z < this.renderDistance)
			{
				g.setColor(new Color(100f/z,100f/z,100f/z,1f)); // Color is now based on distance
				//g.fillRect(x/z*fov + gc.getWidth()/2, y/z*fov + gc.getHeight()/2, 1, 1);
				g.fillOval(x/z*fov + gc.getWidth()/2, y/z*fov + gc.getHeight()/2, 4/z*fov, 4/z*fov); // Size is now based on distance
			}
		}
		g.drawString(copyright, 10, gc.getHeight()-10-g.getFont().getHeight(copyright));
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
	{

		if (this.gameTime == 0)
		{
			for (int i = 0; i < 1000; i++)
			{
				this.objects.add(new float[] { 
						this.random.nextFloat() * gc.getWidth()-gc.getWidth()/2, 
						this.random.nextFloat() * gc.getHeight()-gc.getHeight()/2,
						this.random.nextFloat() * (gc.getWidth()+gc.getHeight())/2 - (gc.getWidth()+gc.getHeight())/4
						});
			}
		}
		
		this.rotate(ry(.001f));
		this.rotate(rz(.001f));
		this.gameTime += 1 * delta / 50f;
	}

	public void translate(float x, float y, float z)
	{
		for (float[] item : this.objects)
		{
			item[0] += x;
			item[1] += y;
			item[2] += z;
		}
	}

	public float[][] rx(float r)
	{
		float cosR = (float) Math.cos(r);
		float sinR = (float) Math.sin(r);

		float[][] matrix = { { 1, 0, 0 }, { 0, cosR, -sinR }, { 0, sinR, cosR } };

		return matrix;
	}

	public float[][] ry(float r)
	{
		float cosR = (float) Math.cos(r);
		float sinR = (float) Math.sin(r);

		float[][] matrix = { { cosR, 0, sinR }, { 0, 1, 0 }, { -sinR, 0, cosR } };

		return matrix;
	}

	public float[][] rz(float r)
	{
		float cosR = (float) Math.cos(r);
		float sinR = (float) Math.sin(r);

		float[][] matrix = { { cosR, -sinR, 0 }, { sinR, cosR, 0 }, { 0, 0, 1 } };

		return matrix;
	}

	public void rotate(float[][] m)
	{
		for (float[] item : this.objects)
		{
			float x, y, z;
			x = item[0];
			y = item[1];
			z = item[2];

			// Mutate the position using matrix.
			item[0] = x * m[0][0] + y * m[0][1] + z * m[0][2];
			item[1] = x * m[1][0] + y * m[1][1] + z * m[1][2];
			item[2] = x * m[2][0] + y * m[2][1] + z * m[2][2];
		}
	}
}
