package net.iridgames.jumpman.world.editor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class TextureLoader {

	public TextureLoader() {

	}

	private Map<String, BufferedImage> imageLoads = new HashMap<String, BufferedImage>();

	/** Loads an image from the 'assets/textures' package
	 * 
	 * @param imagePath
	 *            the path to the image beginning with 'assets/textures'. Remember that you can replace slashes '/' with
	 *            dots '.'
	 * @return Image the newly loaded image */
	public BufferedImage loadImage(String imagePath) {

		BufferedImage loadedImage = null;

		String location = imagePath.replaceAll("[.]", "/");
		location += ".png";
		location = "assets/textures/" + location;
		if (imageLoads.get(location) != null) {
			return imageLoads.get(location);
		} else {
			try {
				// loadedImage = new Image(location);
				File temp = new File(this.getClass().getClassLoader().getResource(location).toURI());
				if (temp.exists()) {
					loadedImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(location));
					System.out.println("Added texture\t'" + location + "'");
				} else {
					loadedImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("assets/textures/noImage.png"));
					throw new Exception("Texture cannot be loaded:\t'" + location + "'");
				}
			} catch (Exception e) {
				try {
					loadedImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("assets/textures/noImage.png"));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (loadedImage != null) {
				imageLoads.put(location, loadedImage);
			}
		}

		return loadedImage;
	}

}
