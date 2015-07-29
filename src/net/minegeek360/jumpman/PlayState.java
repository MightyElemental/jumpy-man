package net.minegeek360.jumpman;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.Entity;
import net.minegeek360.jumpman.entities.particles.EntityParticle;
import net.minegeek360.jumpman.world.World;
import net.minegeek360.jumpman.world.objects.WorldObject;
import net.wolfgangts.gui.GUIRender;

public class PlayState extends BasicGameState {

	private final int	ID;
	public World		world;
	private GUIRender	gui;

	public PlayState( int playState ) {
		this.ID = playState;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		world = new World();
		world.init(gc, sbg);

		gui = new GUIRender();

		if (JumpMan.fullscreen) gui.addButton(gc.getWidth() - 40, 10, 30, 30, "X").setClickEvent(new Runnable() {

			public void run() {
				System.exit(0);
			}
		});
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		g.drawImage(world.currentMapLoaded.getBackground().getScaledCopy(gc.getWidth(), gc.getHeight()), 0, 0);

		g.setColor(new Color(255, 255, 255, 1f));
		for (WorldObject worldObj : world.currentMapLoaded.objects) {
			g.fillRect(worldObj.getX(), worldObj.getY(), worldObj.getWidth(), worldObj.getHeight());
		}

		for (Entity ent : world.entities) {
			if (ent != null) {
				g.drawImage(ent.getDisplayImage().getScaledCopy(ent.getWidth(), ent.getHeight()).getFlippedCopy(!ent.isFacingLeft(), false),
						ent.getPosX(), ent.getPosY());
				g.setColor(new Color(255, 0, 0));
				/*
				 * g.draw(ent.getBoundsLeft()); g.draw(ent.getBoundsRight()); g.draw(ent.getBoundsTop());
				 * g.draw(ent.getBoundsBottom());
				 */

			}
		}

		for (EntityParticle part : world.particles) {
			if (part != null) {
				g.drawImage(part.getDisplayImage().getScaledCopy(part.getWidth(), part.getHeight()), part.getPosX(), part.getPosY());
			}
		}

		gui.render(gc, sbg, g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		gui.update(gc, sbg, delta);
		for (Entity ent : world.entities) {
			ent.update(gc, sbg, delta);
		}

		ArrayList<EntityParticle> partsToRemove = new ArrayList<EntityParticle>();
		for (EntityParticle ent : world.particles) {
			ent.update(gc, sbg, delta);
			if (ent.dead) {
				partsToRemove.add(ent);
			}
		}
		for (EntityParticle ent : partsToRemove) {
			world.particles.remove(ent);
		}
	}

	@Override
	public int getID() {
		return ID;
	}
}
