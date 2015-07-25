package net.minegeek360.jumpman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.Entity;
import net.minegeek360.jumpman.world.World;

public class PlayState extends BasicGameState {

	private final int ID;
	public World world;

	public PlayState(int playState) {
		this.ID = playState;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		world = new World();
		world.init(gc, sbg);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for (int i = 0; i < world.entities.size(); i++) {
			if (world.entities.get(i) != null) {
				Entity temp = world.entities.get(i);
				g.drawImage(temp.getDisplayImage().getScaledCopy(temp.getSizeX(), temp.getSizeY()), temp.getLocationX(),
						temp.getLocationY());

			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		for (int i = 0; i < world.entities.size(); i++) {
			world.entities.get(i).update(gc, sbg, delta);
		}
	}

	@Override
	public int getID() {
		return ID;
	}

}
