package net.wolfgangts.jumpy;

import java.awt.Rectangle;

public class GUIButton
{
	private Rectangle buttonRect;
	private String title;
	private Runnable clickEvent;
	
	public GUIButton(int x, int y, int w, int h)
	{
		this.buttonRect = new Rectangle(x,y,w,h);
	}
	
	public GUIButton(int x, int y, int w, int h, String title)
	{
		this(x,y,w,h);
		this.setTitle(title);
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
		this.buttonRect = new Rectangle(x,y,i,j);
	}
	
	public Rectangle getPosition()
	{
		return this.buttonRect;
	}
	
	public void setClickEvent(Runnable clickEvent)
	{
		this.clickEvent = clickEvent;
	}
	
	public void callClickEvent()
	{
		if(this.clickEvent!=null) 
			this.clickEvent.run();
	}
}
