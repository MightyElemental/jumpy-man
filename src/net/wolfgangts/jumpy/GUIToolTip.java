package net.wolfgangts.jumpy;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.JumpMan;

public class GUIToolTip
{
	private boolean	showHint	= false;
	private String	hint		= "";
	private long	time		= 0;

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
	{
		if (showHint)
		{
			int x = gc.getInput().getMouseX();
			int y = gc.getInput().getMouseY();
			int width = JumpMan.font.getWidth(this.hint);
			int height = JumpMan.font.getHeight();

			g.setColor(new Color(255, 255, 255, 255));
			g.drawRect(x, y, width, height);
			g.setColor(new Color(0, 0, 0, 255));
			g.drawString(this.hint, x + width / 2, y + height / 2);
		}

	}

	public void setHint(String hint)
	{
		this.showHint = true;
		this.hint = hint;
		this.time = System.currentTimeMillis();
	}

	public void update()
	{
		if(System.currentTimeMillis()-this.time >= 500)
		{
			this.showHint = false;
		}
	}
}
