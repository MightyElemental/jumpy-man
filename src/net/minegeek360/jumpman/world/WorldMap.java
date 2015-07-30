package net.minegeek360.jumpman.world;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.JumpMan;
import net.minegeek360.jumpman.world.objects.Material;
import net.minegeek360.jumpman.world.objects.WorldBlock;
import net.minegeek360.jumpman.world.objects.WorldObject;
import net.minegeek360.jumpman.world.objects.WorldObjectFluid;

public class WorldMap {

	public ArrayList<WorldObject> objects = new ArrayList<WorldObject>();

	protected Image background = JumpMan.NULL_IMAGE;

	public void init(GameContainer gc, StateBasedGame sbg) {
		// objects.add(new WorldBlock(500, 170, 4000, 10));
		background = JumpMan.resLoader.loadImage("maps.testmap.background");
		objects.add(new WorldBlock(0, 500, 4000, 50, Material.matIron));
		objects.add(new WorldBlock(800, 50, 10, 500, Material.matIron));
		objects.add(new WorldBlock(80, 50, 10, 500, Material.matIron).setSolid(false));
		objects.add(new WorldObjectFluid(0, gc.getHeight() - 50, gc.getWidth(), 50));
	}

	public Image getBackground() {
		return background;
	}
}
