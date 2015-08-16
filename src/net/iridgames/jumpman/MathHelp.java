package net.iridgames.jumpman;

import net.iridgames.jumpman.entities.Entity;
import net.iridgames.jumpman.world.World;

public class MathHelp {

	public static float getTerminalVelocityAir(World worldObj, Entity ent) {
		float mass = ent.entityMat.getDensity() * ent.getWidth() * ent.getHeight();
		float gravity = worldObj.gravity;
		float density = getDensityOfAir();
		float projArea = ent.getWidth();
		float dragCoef = 1.5f;

		float param1 = 2 * mass * gravity;
		float param2 = density * projArea * dragCoef;
		float termVelo = (float) Math.sqrt(param1 / param2);
		return termVelo;
	}

	/** @return float density of air at NTP (1.2kg/m^3) */
	public static float getDensityOfAir() {
		return 1.2f;
	}

}
