package net.minegeek360.jumpman.world.objects;

import org.newdawn.slick.Image;

import net.minegeek360.jumpman.JumpMan;

public class Material {

	private Image	displayImage;
	private String	matName	= "";

	private Material( String name, String image ) {
		this.displayImage = JumpMan.resLoader.loadImage(image);
		this.matName = name;
	}

	public static final Material	matIron			= new Material("Iron", "materials.iron");
	public static final Material	matToxicWater	= new Material("Toxic Water", "materials.toxicWater");

	public Image getDisplayImage() {
		return displayImage;
	}

	public String getMatName() {
		return matName;
	}

}
