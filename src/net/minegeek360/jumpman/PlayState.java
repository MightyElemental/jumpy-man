package net.minegeek360.jumpman;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.Entity;

public class PlayState extends BasicGameState {

	private final int ID;
	public ArrayList<Entity> entities;

	public PlayState(int playState) {
		this.ID = playState;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		entities = new ArrayList<Entity>();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(gc, sbg, delta);
		}
	}

	@Override
	public int getID() {
		return ID;
	}

}
