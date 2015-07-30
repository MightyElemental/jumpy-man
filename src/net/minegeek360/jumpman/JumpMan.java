package net.minegeek360.jumpman;

import java.awt.Font;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/** @author MightyElemental & WolfgangTS */
public class JumpMan extends StateBasedGame {

	public static final String	GAME_VERSION		= "0.0.7";
	public static final String	GAME_NAME			= "The Adventures Of Jumpy Man";
	public static final String	GAME_NAME_DISPLAY	= GAME_NAME + " | Version " + GAME_VERSION;

	public static final int	STATE_PRELOAD	= 0;
	public static final int	STATE_MENU		= 1;
	public static final int	STATE_PLAY		= 2;

	public static ResourceLoader resLoader = new ResourceLoader();

	public static Image NULL_IMAGE;

	public static final float[][]	commonRatios		= { { 16, 9 }, { 5, 4 }, { 4, 3 } };
	public static float[]			aspectRatio;
	public static final int[][]		commonResolutions	= { { 1280, 1600, 1920, 2048 }, { 1280, 1024 },
			{ 800, 1024, 1152, 1280, 1400, 1600 } };

	public static int	width;
	public static int	maxFPS;
	public static int	stateToChange	= JumpMan.STATE_MENU;

	public static boolean	fullscreen;
	public static boolean	showFPS;
	public static boolean	vsync;
	public static boolean	fullLoaded	= false;

	public static Music	mainMenuSong;
	public static Music	normalGameSong;

	public JumpMan( String name ) {
		super(name);
		this.addState(new PreLoadState(STATE_PRELOAD));
		this.addState(new MenuState(STATE_MENU));
		this.addState(new PlayState(STATE_PLAY));
	}

	public static void main(String[] args) {
		StartupSettings settingMenu = new StartupSettings();

		settingMenu.startUp();
	}

	public static TrueTypeFont	font;
	public static TrueTypeFont	fontArial;

	public static void startGame() {
		AppGameContainer appGc;

		try {
			appGc = new AppGameContainer(new JumpMan(GAME_NAME_DISPLAY));
			appGc.setDisplayMode(width, (int) (width / aspectRatio[0] * aspectRatio[1]), fullscreen);
			appGc.setTargetFrameRate(maxFPS);
			appGc.setMaximumLogicUpdateInterval(30);
			appGc.setMinimumLogicUpdateInterval(15);
			appGc.setShowFPS(showFPS);
			appGc.setVSync(vsync);
			appGc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	private Thread loadThread = new Thread() {

		public void run() {
			mainMenuSong = resLoader.loadMusic("MainMenu");
			normalGameSong = resLoader.loadMusic("NormalGame");
			fullLoaded = true;
			try {
				loadThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	public static void crashMessage(String message) {
		JOptionPane.showMessageDialog(null, message, JumpMan.GAME_NAME + " | Crash Report", JOptionPane.ERROR_MESSAGE);
		System.exit(1);
	}

	@Override
	public synchronized void initStatesList(GameContainer gc) throws SlickException {
		NULL_IMAGE = resLoader.loadImage("noImage");
		if (NULL_IMAGE == null) {
			gc.exit();
			crashMessage("JumpMan.NULL_IMAGE is null!\nThis could cause a lot of issues, especially if the game is missing textures!");
		}
		try {
			InputStream inputStream = org.newdawn.slick.util.ResourceLoader.getResourceAsStream("res/assets/fonts/arial.ttf");
			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(15f);
			fontArial = new TrueTypeFont(awtFont2, true);

			InputStream inputStream1 = org.newdawn.slick.util.ResourceLoader.getResourceAsStream("res/assets/fonts/monkey.ttf");
			Font awtFont21 = Font.createFont(Font.TRUETYPE_FONT, inputStream1);
			awtFont21 = awtFont21.deriveFont(36f);
			font = new TrueTypeFont(awtFont21, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadThread.start();
		this.getState(STATE_PRELOAD).init(gc, this);
		this.getState(STATE_MENU).init(gc, this);
		this.getState(STATE_PLAY).init(gc, this);
		this.enterState(STATE_PRELOAD);

	}

}
