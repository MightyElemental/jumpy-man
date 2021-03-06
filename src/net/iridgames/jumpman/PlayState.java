package net.iridgames.jumpman;

import java.lang.reflect.Field;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.iridgames.jumpman.entities.Entity;
import net.iridgames.jumpman.entities.particles.EntityParticle;
import net.iridgames.jumpman.entities.player.EntityPlayer;
import net.iridgames.jumpman.world.World;
import net.iridgames.jumpman.world.objects.Material;
import net.iridgames.jumpman.world.objects.ObjPortal;
import net.iridgames.jumpman.world.objects.WorldObject;
import net.wolfgangts.gui.GUIRender;

public class PlayState extends BasicGameState {

	private final int	ID;
	public World		world;
	private GUIRender	gui;
	private Music		currentMusic;
	private Music		oldCurrentMusic;

	public PlayState( int playState ) {
		this.ID = playState;
	}

	public void loadMaterialTextures() throws IllegalArgumentException, IllegalAccessException {
		Field[] temp = Material.class.getDeclaredFields();
		System.out.println("load");
		for (Field f : temp) {
			if (f.getType().equals(Material.class)) {
				((Material) f.get("")).loadTexture();
			}
		}
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		world = new World();
		world.init(gc, sbg);
		try {
			loadMaterialTextures();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		gui = new GUIRender();

		if (JumpMan.fullscreen) gui.addButton(gc.getWidth() - 40, 10, 30, 30, "X").setClickEvent(new Runnable() {

			public void run() {
				System.exit(0);
			}
		});
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		renderWorld(gc, sbg, g);
		renderEntities(gc, sbg, g);
		renderParticles(gc, sbg, g);

		gui.render(gc, sbg, g);

	}

	public void renderWorld(GameContainer gc, StateBasedGame sbg, Graphics g) {
		g.drawImage(world.currentMapLoaded.getBackground().getScaledCopy(gc.getWidth(), gc.getHeight()), 0, 0);

		g.setColor(new Color(255, 255, 255, 1f));
		for (WorldObject worldObj : world.currentMapLoaded.objects) {
			if (!(worldObj instanceof ObjPortal)) {
				g.texture(new Rectangle(worldObj.getX(), worldObj.getY(), worldObj.getWidth(), worldObj.getHeight()), worldObj.getTexture(),
						.01f, .02f, false);
			} else {
				g.drawImage(worldObj.getTexture().getScaledCopy((int) worldObj.getWidth(), (int) worldObj.getHeight()), worldObj.getX(),
						worldObj.getY(), ((ObjPortal) worldObj).getPortalColor());
			}
		}
	}

	public void renderEntities(GameContainer gc, StateBasedGame sbg, Graphics g) {
		for (Entity e : world.entities) {
			if (e != null) {
				g.drawImage(e.getDisplayImage().getScaledCopy(e.getWidth(), e.getHeight()).getFlippedCopy(!e.isFacingLeft(), false),
						e.getPosX(), e.getPosY());
				g.setColor(new Color(255, 0, 0));
				if (e instanceof EntityPlayer) {
					EntityPlayer p = (EntityPlayer) e;

					TrueTypeFont cf = JumpMan.fontArial;
					String health = p.getHealth() + "";

					g.setFont(cf);
					g.setColor(new Color(0, 0, 0, 0.5f));
					g.fillRect(p.getPosX() + p.getWidth() / 2 - cf.getWidth(health), p.getPosY() - cf.getHeight() - 5,
							cf.getWidth(health) * 2, cf.getHeight() + 10);
					g.setColor(new Color(255, 0, 0, 1f));
					g.drawString(health, p.getPosX() + p.getWidth() / 2 - cf.getWidth(health) / 2, p.getPosY() - 20);
				}
			}
		}
	}

	public void renderParticles(GameContainer gc, StateBasedGame sbg, Graphics g) {
		for (EntityParticle part : world.particles) {
			if (part != null) {
				g.drawImage(part.getDisplayImage().getScaledCopy(part.getWidth(), part.getHeight()), part.getPosX(), part.getPosY(),
						new Color(part.color.r, part.color.g, part.color.b, part.alpha));
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// Handle music;
		updateMusic(gc, sbg, delta);

		gui.update(gc, sbg, delta);
		world.update(gc, sbg, delta);
	}

	public void updateMusic(GameContainer gc, StateBasedGame sbg, int delta) {
		if (this.currentMusic == null) {
			this.currentMusic = JumpMan.normalGameSong;
		}

		if (this.oldCurrentMusic != this.currentMusic) {
			if (oldCurrentMusic != null) this.oldCurrentMusic.stop();
			if (this.currentMusic != null) {
				this.currentMusic.setVolume(0.5f);
				this.currentMusic.loop(1f, 0.1f);
			}
		}

		this.oldCurrentMusic = this.currentMusic;
	}

	@Override
	public int getID() {
		return ID;
	}
}
