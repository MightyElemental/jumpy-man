package net.iridgames.jumpman.world;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import net.iridgames.jumpman.entities.Entity;
import net.iridgames.jumpman.entities.EntityPlayer;
import net.iridgames.jumpman.entities.particles.EntityParticle;

public class World {

	public ArrayList<Entity>			entities	= new ArrayList<Entity>();
	public ArrayList<EntityParticle>	particles	= new ArrayList<EntityParticle>();
	private ArrayList<WorldMap>			mapArray	= new ArrayList<WorldMap>();

	public Random rand = new Random();

	/** The velocity to be added every tick the entities are not on the ground */
	public float gravity = 0.6f; // should be 9.8m/s/s (9.8m per second for every second in the air) //0.6 - old

	public WorldMap currentMapLoaded;

	private boolean	particlesBeingUpdated;
	private boolean	entitiesBeingUpdated;

	public void init(GameContainer gc, StateBasedGame sbg) {
		createEntity(new EntityPlayer(this));
		WorldMap map = new WorldMap();
		map.init(gc, sbg, this);
		mapArray.add(map);
		currentMapLoaded = mapArray.get(0);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		// Update entities
		ArrayList<Entity> entsToRemove = new ArrayList<Entity>();
		entitiesBeingUpdated = true;
		for (Entity ent : this.entities) {
			if (ent.isDead()) {
				entsToRemove.add(ent);
			} else {
				ent.update(gc, sbg, delta);
			}
		}
		for (Entity ent : entsToRemove) {
			this.entities.remove(ent);
		}
		entitiesBeingUpdated = false;

		// Update particles
		ArrayList<EntityParticle> partsToRemove = new ArrayList<EntityParticle>();
		particlesBeingUpdated = true;
		for (EntityParticle ent : this.particles) {
			if (ent.dead) {
				partsToRemove.add(ent);
			} else {
				ent.update(gc, sbg, delta);
			}
		}
		for (EntityParticle ent : partsToRemove) {
			this.particles.remove(ent);
		}
		particlesBeingUpdated = false;
	}

	public boolean createEntity(Entity particle) {
		if (!entitiesBeingUpdated) {
			entities.add(particle);
			return true;
		}
		return false;
	}

	public boolean createParticle(EntityParticle particle) {
		if (!particlesBeingUpdated) {
			particles.add(particle);
			return true;
		}
		return false;
	}

}
