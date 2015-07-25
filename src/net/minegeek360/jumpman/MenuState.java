package net.minegeek360.jumpman;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.wolfgangts.jumpy.Renderer;

public class MenuState extends BasicGameState
{

	private final int ID;

	/** Variables to be deleted */
	private float DELETE_THIS = 0;
	private Random random = new Random();
	private Renderer rend;

	

	/** End */

	public MenuState(int stateMenu)
	{
		this.ID = stateMenu;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		rend = new Renderer();
	}
	

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawString("Hello WolfgangTS...", (float) ((Math.sin(DELETE_THIS / 45.0) * 100) + 300), 50);
		g.drawString("Or are you MightyElemental?", (float) ((Math.sin(DELETE_THIS / 46.0) * 100) + 350), 100);

		rend.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		rend.update(gc, sbg, delta);
	}
	


	@Override
	public int getID()
	{
		return ID;
	}

}
