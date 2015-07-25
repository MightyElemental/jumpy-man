package net.wolfgangts.jumpy;


import java.awt.Rectangle;

import org.newdawn.slick.Color;

public class GUIButton
{
	private Rectangle	buttonRect;
	private String		title;
	private Runnable	clickEvent;
	private Color		color;
	private Color		fontColor;

	public GUIButton(int x, int y, int w, int h)
	{
		this.buttonRect = new Rectangle(x, y, w, h);
		this.color = new Color(255,255,255,255);
		this.fontColor = new Color(0,0,0,255);
	}

	public GUIButton(int x, int y, int w, int h, String title)
	{
		this(x, y, w, h);
		this.setTitle(title);
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public Color getColor()
	{
		return this.color;
	}

	public void setFontColor(Color color)
	{
		this.fontColor = color;
	}

	public Color getFontColor()
	{
		return this.fontColor;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setPosition(Rectangle rect)
	{
		this.buttonRect = rect;
	}

	public void setPosition(int x, int y, int i, int j)
	{
		this.buttonRect = new Rectangle(x, y, i, j);
	}

	public Rectangle getPosition()
	{
		return this.buttonRect;
	}

	public GUIButton setClickEvent(Runnable clickEvent)
	{
		this.clickEvent = clickEvent;

		return this;
	}

	public void callClickEvent()
	{
		if (this.clickEvent != null)
			this.clickEvent.run();
	}
}
