package net.minegeek360.jumpman;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.wolfgangts.jumpy.GUIButton;
import net.wolfgangts.jumpy.GUIRender;
import net.wolfgangts.jumpy.Render3D;

public class MenuState extends BasicGameState
{

	private final int ID;

	private Random		random	= new Random();
	private Render3D	Render3D;
	private GUIRender	gui;
	private int stateToChange = JumpMan.STATE_MENU;

	/* End */

	public MenuState(int stateMenu)
	{
		this.ID = stateMenu;
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		Render3D = new Render3D();
		gui = new GUIRender();

		gui.addButton(new GUIButton(10, 10, 50, 50, "Hi").setClickEvent(new Runnable()
		{
			public void run()
			{
				stateToChange = JumpMan.STATE_MENU;
			}
		}));

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		gui.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		gui.update(gc, sbg, delta);
		if(sbg.getCurrentState().getID() != stateToChange)
			sbg.enterState(stateToChange);
	}

	@Override
	public int getID()
	{
		return ID;
	}

}
