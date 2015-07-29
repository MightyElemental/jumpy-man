package net.minegeek360.jumpman;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.Entity;
import net.minegeek360.jumpman.world.World;
import net.minegeek360.jumpman.world.WorldObject;
import net.wolfgangts.gui.GUIRender;
import net.wolfgangts.shaders.Shader;

public class PlayState extends BasicGameState
{

	private final int	ID;
	public World		world;
	private GUIRender	gui;
	private Shader		shader;

	public PlayState(int playState)
	{
		this.ID = playState;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		shader = new Shader();

		world = new World();
		world.init(gc, sbg);

		gui = new GUIRender();

		if (JumpMan.fullscreen)
			gui.addButton(gc.getWidth() - 40, 10, 30, 30, "X").setClickEvent(new Runnable()
			{

				public void run()
				{
					System.exit(0);
				}
			});
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.setColor(new Color(255, 255, 255, 1f));
		for (WorldObject worldObj : world.currentMapLoaded.objects)
		{
			g.fillRect(worldObj.getX(), worldObj.getY(), worldObj.getWidth(), worldObj.getHeight());
		}

		for (Entity ent : world.entities)
		{
			if (ent != null)
			{
				// g.drawImage(ent.getDisplayImage().getScaledCopy(ent.getWidth(),
				// ent.getHeight()), ent.getPosX(),
				// ent.getPosY());
				g.setColor(new Color(0, 255, 0));
				g.fillRect(ent.getPosX(), ent.getPosY(), ent.getWidth(), ent.getHeight());
				g.setColor(new Color(255, 0, 0));
				g.draw(ent.getBoundsLeft());
				g.draw(ent.getBoundsRight());
				g.draw(ent.getBoundsTop());
				g.draw(ent.getBoundsBottom());

			}
		}
		gui.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		gui.update(gc, sbg, delta);
		for (Entity ent : world.entities)
		{
			ent.update(gc, sbg, delta);
			// System.out.println(ent.getPosY());
		}
	}

	@Override
	public int getID()
	{
		return ID;
	}

}
