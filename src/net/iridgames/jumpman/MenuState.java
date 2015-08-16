package net.iridgames.jumpman;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.wolfgangts.gui.GUIRender;
import net.wolfgangts.gui.Render3D;

public class MenuState extends BasicGameState {

	private final int	ID;
	private Render3D	Render3D;
	private GUIRender	gui;

	public MenuState( int stateMenu ) {
		this.ID = stateMenu;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		gui = new GUIRender();
		this.Render3D = new Render3D();

		mainMenu(gc, sbg);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Render3D.render(gc, sbg, g);
		gui.render(gc, sbg, g);
		gui.tooltip.render(gc, sbg, g);
	}

	private boolean playingMusic = false;

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Render3D.update(gc, sbg, delta);
		if (!playingMusic) {
			if (JumpMan.mainMenuSong != null) {
				JumpMan.mainMenuSong.loop();
				playingMusic = true;
			}
		}

		gui.tooltip.update();
		gui.update(gc, sbg, delta);
		if (sbg.getCurrentState().getID() != JumpMan.stateToChange) {
			sbg.enterState(JumpMan.stateToChange);
			JumpMan.mainMenuSong.loop();
		}
	}

	@Override
	public int getID() {
		return ID;
	}

	public void mainMenu(final GameContainer gc, final StateBasedGame sbg) {
		gui.clear();

		gui.addButton(gc.getWidth() / 4, gc.getHeight() / 4 * 1, gc.getWidth() / 4 * 2, 50, "Start Game")
				.setColor(new Color(255, 0, 0, 255)).setClickEvent(new Runnable() {

					public void run() {
						JumpMan.stateToChange = JumpMan.STATE_PLAY;
					}
				});
		gui.addButton(gc.getWidth() / 4, gc.getHeight() / 4 * 2, gc.getWidth() / 4 * 2, 50, "Settings").setClickEvent(new Runnable() {

			public void run() {
				settingsMenu(gc, sbg);
			}
		});
		gui.addButton(gc.getWidth() / 4, gc.getHeight() / 4 * 3, gc.getWidth() / 4 * 2, 50, "Exit").setClickEvent(new Runnable() {

			public void run() {
				gc.exit();
			}
		});
	}

	public void settingsMenu(final GameContainer gc, final StateBasedGame sbg) {
		gui.clear();

		gui.addButton(50, 50, 200, 50, "Go back!").setClickEvent(new Runnable() {

			public void run() {
				mainMenu(gc, sbg);
			}
		});
	}

}
