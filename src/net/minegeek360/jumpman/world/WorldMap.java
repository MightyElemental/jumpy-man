package net.minegeek360.jumpman.world;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import net.minegeek360.jumpman.JumpMan;
import net.minegeek360.jumpman.world.objects.Material;
import net.minegeek360.jumpman.world.objects.ObjBlock;
import net.minegeek360.jumpman.world.objects.ObjFluid;
import net.minegeek360.jumpman.world.objects.ObjPortal;
import net.minegeek360.jumpman.world.objects.WorldObject;

public class WorldMap {

	public ArrayList<WorldObject> objects = new ArrayList<WorldObject>();

	protected Image background = JumpMan.NULL_IMAGE;

	public void init(GameContainer gc, StateBasedGame sbg) {
		// objects.add(new WorldBlock(500, 170, 4000, 10));
		background = JumpMan.resLoader.loadImage("maps.testmap.background");
		objects.add(new ObjBlock(0, 500, gc.getWidth() - 400, 50, Material.matIron));
		// objects.add(new WorldBlock(800, 50, 10, 500, Material.matIron));
		objects.add(new ObjBlock(80, 50, 10, 500, Material.matIron).setSolid(false));
		objects.add(new ObjBlock(0, gc.getHeight(), gc.getWidth(), 50, Material.matIron));
		objects.add(new ObjFluid(0, gc.getHeight() - 50, gc.getWidth(), 50, Material.matToxicWater));
		objects.add(new ObjPortal(60, 450, ObjPortal.TYPE_BLUE, false));
	}

	public Image getBackground() {
		return background;
	}
}
