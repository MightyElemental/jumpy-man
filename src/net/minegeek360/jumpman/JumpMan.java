package net.minegeek360.jumpman;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class JumpMan extends StateBasedGame {

	public static final String GAME_NAME = "Slick Test";

	public static final int menu = 0;
	public static final int play = 1;

	public static final int[] commonResolutions16_9 = { 1280, 1600, 1920, 2048 };

	public static final int width = commonResolutions16_9[1];

	public JumpMan(String name) {
		super(name);
	}

	public static void main(String[] args) {
		AppGameContainer appGc;
		try {
			appGc = new AppGameContainer(new JumpMan(GAME_NAME));
			appGc.setDisplayMode(width, (int) (width / 16.0 * 9.0), true);
			appGc.setTargetFrameRate(60);
			appGc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {

	}

}
