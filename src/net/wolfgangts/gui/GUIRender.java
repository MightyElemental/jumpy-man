package net.wolfgangts.gui;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GUIRender {

	private ArrayList<GUIButton>	buttons			= new ArrayList<GUIButton>();
	public GUIToolTip				tooltip			= new GUIToolTip();
	private boolean					previousMouse1	= false;
	private boolean					previousMouse2	= false;
	private boolean					previousMouse3	= false;

	public GUIRender() {

	}

	public void clear() {
		this.buttons = new ArrayList<GUIButton>();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		for (Object buttonObj : buttons.toArray()) {
			GUIButton button = (GUIButton) buttonObj;
			button.render(gc, sbg, g);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		boolean mouse1 = gc.getInput().isMouseButtonDown(0);
		boolean mouse2 = gc.getInput().isMouseButtonDown(1);
		boolean mouse3 = gc.getInput().isMouseButtonDown(2);

		if (mouse1) {
			if (!previousMouse1) {
				for (Object buttonObj : buttons.toArray()) {
					GUIButton button = (GUIButton) buttonObj;
					Rectangle position = button.getPosition();

					if (position.contains(new Point(gc.getInput().getMouseX(), gc.getInput().getMouseY()))) {
						button.callClickEvent();
					}
				}
			}

			for (Object buttonObj : buttons.toArray()) {
				GUIButton button = (GUIButton) buttonObj;
				Rectangle position = button.getPosition();

				if (position.contains(new Point(gc.getInput().getMouseX(), gc.getInput().getMouseY()))) {
					button.callHoldEvent();
				}
			}
		} else {
			for (Object buttonObj : buttons.toArray()) {
				GUIButton button = (GUIButton) buttonObj;
				Rectangle position = button.getPosition();

				if (position.contains(new Point(gc.getInput().getMouseX(), gc.getInput().getMouseY()))) {
					button.callHoverEvent();
				}
			}
		}

		previousMouse1 = mouse1;
		previousMouse2 = mouse2;
		previousMouse3 = mouse3;
	}

	public ArrayList<GUIButton> getButtons() {
		return this.buttons;
	}

	public void addButton(GUIButton button) {
		buttons.add(button);
	}

	public GUIButton addButton(int x, int y, int i, int j) {
		GUIButton newButton = new GUIButton(x, y, i, j);

		buttons.add(newButton);
		return newButton;
	}

	public GUIButton addButton(int x, int y, int i, int j, String title) {
		GUIButton newButton = new GUIButton(x, y, i, j, title);

		buttons.add(newButton);
		return newButton;
	}
}
