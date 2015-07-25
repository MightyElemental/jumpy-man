package net.wolfgangts.jumpy;


import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.JumpMan;

public class GUIRender
{
	private ArrayList<GUIButton> buttons = new ArrayList<GUIButton>();

	public GUIRender()
	{

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	{
		for (Object buttonObj : buttons.toArray())
		{
			GUIButton button = (GUIButton) buttonObj;

			Rectangle position = button.getPosition();

			g.setColor(new Color(255, 255, 255, 255));
			g.fillRect(position.x, position.y, position.width, position.height);

			g.setColor(new Color(0, 0, 0, 255));
			g.setFont(JumpMan.font);
			
			int width = JumpMan.font.getWidth(button.getTitle());
			int height = JumpMan.font.getHeight();
			
			g.drawString(button.getTitle(), position.x + position.width / 2 - width/2, position.y + position.height / 2 - height/2);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
	{
		if (gc.getInput().isMouseButtonDown(0))
		{
			for (Object buttonObj : buttons.toArray())
			{
				GUIButton button = (GUIButton) buttonObj;
				Rectangle position = button.getPosition();

				if (position.contains(new Point(gc.getInput().getMouseX(), gc.getInput().getMouseY())))
				{
					button.callClickEvent();
				}
			}
		}
	}
	
	public ArrayList<GUIButton> getButtons()
	{
		return this.buttons;
	}

	public void addButton(GUIButton button)
	{
		buttons.add(button);
	}
}
