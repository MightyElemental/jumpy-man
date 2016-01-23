package net.iridgames.jumpman.world.objects;

import org.newdawn.slick.Image;

import net.iridgames.jumpman.JumpMan;

public class Material {

	private Image displayImage = JumpMan.NULL_IMAGE;

	private String	matName	= "";
	private String	texLoc	= "noImage";

	private boolean	isToxic	= false;
	private boolean	isFluid	= false;

	private float density = 1000f;

	private Material( String name, String image ) {
		this(name);
		texLoc = image;
	}

	private Material( String name ) {
		this.matName = name;
	}

	public static final Material	matNull			= new Material("Null", "noImage");
	public static final Material	matIron			= new Material("Iron", "materials.iron");
	public static final Material	matPortal		= new Material("Portal", "materials.portal");
	public static final Material	matFluid		= new Material("Fluid", "materials.fluid").setFluid(true).setDensity(600);
	public static final Material	matGravityUp	= new Material("Gravity Up Field", "materials.gravUpField");
	public static final Material	matEntity		= new Material("Entity").setDensity(1300);

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

	public boolean isFluid() {
		return isFluid;
	}

	public Material setFluid(boolean isFluid) {
		this.isFluid = isFluid;
		return this;
	}

	public float getDensity() {
		return density;
	}

	public Material setDensity(float density) {
		this.density = density;
		return this;
	}

	/** @return the texLoc */
	public String getTexLoc() {
		return texLoc;
	}

	public void loadTexture() {
		this.displayImage = JumpMan.resLoader.loadImage(texLoc);
	}

}
