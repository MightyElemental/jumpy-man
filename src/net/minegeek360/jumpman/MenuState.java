package net.minegeek360.jumpman;

import java.util.ArrayList;

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
	private float DELETE_THIS = 0;

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Hello WolfgangTS...", (float) ((Math.sin(DELETE_THIS / 45.0) * 100) + 300), 50);
		g.drawString("Or are you MightyElemental?", (float) ((Math.sin(DELETE_THIS / 46.0) * 100) + 350), 100);

		for (int i = 0; i < DELETE_THIS_2.size(); i++) {
			g.fillRect(DELETE_THIS_2.get(i)[0], DELETE_THIS_2.get(i)[1], 1, 1);
		}

	}

	/** A variable to be deleted */
	private ArrayList<float[]> DELETE_THIS_2 = new ArrayList<float[]>();

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		DELETE_THIS += 1 * delta / 20.0;
		DELETE_THIS_2.add(
				new float[] { DELETE_THIS * (DELETE_THIS / 500f), (float) (Math.sin(DELETE_THIS / 20.0f) * (DELETE_THIS / 5f)) + 200 });
	}

	@Override
	public int getID() {
		return ID;
	}

}
