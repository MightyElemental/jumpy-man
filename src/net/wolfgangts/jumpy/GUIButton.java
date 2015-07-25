package net.wolfgangts.jumpy;

import java.awt.Point;

public class GUIButton
{
	private Point posA;
	private Point posB;
	private String title;
	
	public GUIButton(int x, int y, int i, int j)
	{
		this.posA = new Point(x,y);
		this.posB = new Point(i,j);
	}
	
	public GUIButton(int x, int y, int i, int j, String title)
	{
		this(x,y,i,j);
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

}
