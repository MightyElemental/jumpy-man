package net.minegeek360.jumpman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState {

	private final int ID;

	public MenuState(int stateMenu) {
		this.ID = stateMenu;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	/** A variable to be deleted */
	private int DELETE_THIS = 0;

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Hello WolfgangTS...", (float) ((Math.sin(DELETE_THIS / 45.0) * 100) + 300), 50);
		g.drawString("Or are you MightyElemental?", (float) ((Math.sin(DELETE_THIS / 46.0) * 100) + 350), 100);
		DELETE_THIS++;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

	}

	@Override
	public int getID() {
		return ID;
	}

}
