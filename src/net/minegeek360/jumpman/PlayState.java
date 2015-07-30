package net.minegeek360.jumpman;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.entities.Entity;
import net.minegeek360.jumpman.entities.EntityPlayer;
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
			g.texture(new Rectangle(worldObj.getX(), worldObj.getY(), worldObj.getWidth(), worldObj.getHeight()), worldObj.getTexture(),
					.01f, .02f);
		}

		
		
		for (Entity e : world.entities) {
			if (e != null) {
				g.drawImage(e.getDisplayImage().getScaledCopy(e.getWidth(), e.getHeight()).getFlippedCopy(!e.isFacingLeft(), false),
						e.getPosX(), e.getPosY());
				g.setColor(new Color(255, 0, 0));
				if(e instanceof EntityPlayer)
				{
					EntityPlayer p = (EntityPlayer) e;
					
					TrueTypeFont cf = JumpMan.fontArial;
					String health = p.getHealth() + "";
					System.out.println(health);
					
					
					g.setFont(cf);
					g.setColor(new Color(0,0,0, 0.5f));
					g.fillRect(p.getPosX()+p.getWidth()/2 - cf.getWidth(health), p.getPosY()-cf.getHeight()-5, cf.getWidth(health)*2, cf.getHeight()+10);
					g.setColor(new Color(255,0,0, 1f));
					g.drawString(health, p.getPosX()+p.getWidth()/2 - cf.getWidth(health)/2, p.getPosY() - 20);
				}
			}
		}

		for (EntityParticle part : world.particles) {
			if (part != null) {
				g.drawImage(part.getDisplayImage().getScaledCopy(part.getWidth(), part.getHeight()), part.getPosX(), part.getPosY(),
						new Color(255, 255, 255, part.alpha));
			}
		}

		gui.render(gc, sbg, g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		gui.update(gc, sbg, delta);
		// Update entities
		ArrayList<Entity> entsToRemove = new ArrayList<Entity>();
		for (Entity ent : world.entities) {
			if (ent.isDead()) {
				entsToRemove.add(ent);
			} else {
				ent.update(gc, sbg, delta);
			}
		}
		for (Entity ent : entsToRemove) {
			world.entities.remove(ent);
		}

		// Update particles
		ArrayList<EntityParticle> partsToRemove = new ArrayList<EntityParticle>();
		for (EntityParticle ent : world.particles) {
			if (ent.dead) {
				partsToRemove.add(ent);
			} else {
				ent.update(gc, sbg, delta);
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
