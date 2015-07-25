package net.minegeek360.jumpman;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.wolfgangts.jumpy.Renderer;

public class MenuState extends BasicGameState {

	private final int ID;

	private Random random = new Random();
	private Renderer rend;

	/* End */

	public MenuState(int stateMenu) {
		this.ID = stateMenu;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		rend = new Renderer();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// rend.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// rend.update(gc, sbg, delta);
	}

	@Override
	public int getID() {
		return ID;
	}

}
