package net.minegeek360.jumpman.world.objects;

import org.newdawn.slick.Image;

import net.minegeek360.jumpman.JumpMan;

public class Material {

	private Image displayImage = JumpMan.NULL_IMAGE;

	private String matName = "";

	private boolean isToxic = false;

	private Material( String name, String image ) {
		this.displayImage = JumpMan.resLoader.loadImage(image);
		this.matName = name;
	}

	public static final Material	matIron			= new Material("Iron", "materials.iron");
	public static final Material	matToxicWater	= new Material("Toxic Water", "materials.toxicWater").setToxic(true);

	public Image getTexture() {
		return displayImage;
	}

	public String getMatName() {
		return matName;
	}

	public boolean isToxic() {
		return isToxic;
	}

	public Material setToxic(boolean isToxic) {
		this.isToxic = isToxic;
		return this;
	}

}
