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
			g.fillRect(x - 5, y-height - 10, width + 10, height + 10);
			g.setColor(new Color(0, 0, 0, 255));
			g.drawString(this.hint, x, y-height-5);
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
		this.showHint = false;
	}
}
