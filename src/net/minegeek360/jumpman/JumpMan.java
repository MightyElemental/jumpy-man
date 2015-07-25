package net.minegeek360.jumpman;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class JumpMan extends StateBasedGame {

	public static final String GAME_VERSION = "0.0.0";

	public static final String GAME_NAME = "The Adventures Of Jumpy Man | Version " + GAME_VERSION;

	public static final int STATE_MENU = 0;
	public static final int STATE_PLAY = 1;

	public static final int[] commonResolutions16_9 = { 1280, 1600, 1920, 2048 };
	public static final double[][] commonRatios = { { 16, 9 }, { 5, 4 }, { 8, 5 }, { 4, 3 } };

	public static final int width = commonResolutions16_9[1];
	public static final double[] aspectRatio = commonRatios[0];

	public JumpMan(String name) {
		super(name);
		this.addState(new MenuState(STATE_MENU));
		this.addState(new PlayState(STATE_PLAY));
	}

	public static void main(String[] args) {
		StartupSettings settingMenu = new StartupSettings();
		
		settingMenu.startUp();
	}
	
	public static void startGame()
	{
		AppGameContainer appGc;
		
		try {
			appGc = new AppGameContainer(new JumpMan(GAME_NAME));
			appGc.setDisplayMode(width, (int) (width / aspectRatio[0] * aspectRatio[1]), false);
			appGc.setTargetFrameRate(60);
			appGc.setMaximumLogicUpdateInterval(30);
			appGc.setMinimumLogicUpdateInterval(15);
			appGc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(STATE_MENU).init(gc, this);
		this.getState(STATE_PLAY).init(gc, this);
		this.enterState(STATE_MENU);
	}

}
