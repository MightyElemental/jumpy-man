package net.wolfgangts.jumpy;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GUIRender
{
	private ArrayList<GUIButton> buttons = new ArrayList<GUIButton>();
	
	public GUIRender()
	{
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	{
		for(GUIButton button : (GUIButton[]) buttons.toArray())
		{
			g.fillRect(button.getPosition().x, button.getPosition().y, button.getPosition().width, button.getPosition().height);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
	{
		
	}
	
	public void addButton(GUIButton button)
	{
		buttons.add(button);
	}
	
}
