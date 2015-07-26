package net.minegeek360.jumpman;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.wolfgangts.jumpy.GUIButton;
import net.wolfgangts.jumpy.GUIRender;
import net.wolfgangts.jumpy.GUIToolTip;
import net.wolfgangts.jumpy.Render3D;

public class MenuState extends BasicGameState
{

	private final int ID;

	private Random		random			= new Random();
	private Render3D	Render3D;
	private GUIRender	gui;
	private GUIToolTip	tooltip;

	/* End */

	public MenuState(int stateMenu)
	{
		this.ID = stateMenu;

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		tooltip = new GUIToolTip();

		
		
		
		gui = new GUIRender();

		gui.addButton(0, gc.getHeight() / 2 - 25, gc.getWidth(), 50, "Start Game").setColor(new Color(255, 0, 0, 255)).setClickEvent(new Runnable()
		{
			public void run()
			{
				JumpMan.stateToChange = JumpMan.STATE_PLAY;
			}
		}).setHoverEvent(new Runnable(){
			public void run()
			{
				tooltip.setHint("Click to start the game.");
			}
		});
		
		gui.addButton(0,0,50,50, "Test").setClickEvent(new Runnable(){
			private int i = 0;
			
			public void run()
			{
				System.out.println(i);
				i++;
			}
		});
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		gui.render(gc, sbg, g);
		tooltip.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{

		tooltip.update();
		gui.update(gc, sbg, delta);
		if (sbg.getCurrentState().getID() != JumpMan.stateToChange)
			sbg.enterState(JumpMan.stateToChange);
	}

	@Override
	public int getID()
	{
		return ID;
	}

}
