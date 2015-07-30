package net.minegeek360.jumpman;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.wolfgangts.gui.GUIRender;
import net.wolfgangts.gui.Render3D;

public class MenuState extends BasicGameState
{

	private final int ID;

	private Random		random	= new Random();
	private Render3D	Render3D;
	private GUIRender	gui;
	private Music		music;

	public MenuState(int stateMenu)
	{
		this.ID = stateMenu;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		this.music = JumpMan.resLoader.loadMusic("sounds.music");

		if(this.music!=null)
			this.music.play();
		
		gui = new GUIRender();

		gui.addButton(gc.getWidth() / 4, gc.getHeight() / 2 - 25, gc.getWidth() / 4 * 2, 50, "Start Game").setColor(new Color(255, 0, 0, 255)).setClickEvent(new Runnable()
		{
			public void run()
			{
				JumpMan.stateToChange = JumpMan.STATE_PLAY;
			}
		});
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		gui.render(gc, sbg, g);
		gui.tooltip.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{

		gui.tooltip.update();
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
