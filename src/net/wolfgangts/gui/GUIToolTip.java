package net.wolfgangts.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.JumpMan;

public class GUIToolTip
{
	private boolean	showHint	= false;
	private String	hint		= "";

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	{
		if (showHint)
		{
			TrueTypeFont currentFont = JumpMan.fontArial;

			String hint = this.hint;
			
			int heightMod = Utilities.instancesOf(hint, "\n")+1;
			
			int x = gc.getInput().getMouseX();
			int y = gc.getInput().getMouseY();
			int width = currentFont.getWidth(this.hint);
			int height = currentFont.getHeight() * heightMod;
			int thickness = 1;

			g.setFont(currentFont);
			g.setColor(new Color(0, 0, 0, 255));
			g.fillRect(x - 5 - thickness, y - height - 10 - thickness, width + 10 + thickness * 2, height + 10 + thickness * 2);
			g.setColor(new Color(155, 155, 155, 255));
			g.fillRect(x - 5, y - height - 10, width + 10, height + 10);
			g.setColor(new Color(0, 0, 0, 255));
			g.drawString(hint, x, y - height - 5);
		}

	}

	public void setHint(String hint)
	{
		this.showHint = true;
		this.hint = hint;
	}

	public void update()
	{
		this.showHint = false;
	}
}
