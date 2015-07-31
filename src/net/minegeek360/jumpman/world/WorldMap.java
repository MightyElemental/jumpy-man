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

	public void init(GameContainer gc, StateBasedGame sbg, World worldObj) {
		// objects.add(new WorldBlock(500, 170, 4000, 10));
		background = JumpMan.resLoader.loadImage("maps.testmap.background");
		objects.add(new ObjBlock(0, 500, gc.getWidth() - 400, 50, Material.matIron));
		// objects.add(new WorldBlock(800, 50, 10, 500, Material.matIron));
		objects.add(new ObjBlock(-5, 50, 10, 500, Material.matIron).setSolid(true));
		objects.add(new ObjBlock(0, gc.getHeight(), gc.getWidth(), 50, Material.matIron));
		objects.add(new ObjFluid(0, gc.getHeight() - 50, gc.getWidth(), 50, Material.matToxicWater));
		ObjPortal port = new ObjPortal(400, 420, ObjPortal.TYPE_BLUE, true, worldObj);
		ObjPortal port2 = new ObjPortal(70, 420, ObjPortal.TYPE_ORANGE, true, worldObj, port);
		port.setConnectedPortal(port2);
		objects.add(port);
		objects.add(port2);

	}

	public Image getBackground() {
		return background;
	}
}
