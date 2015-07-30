package net.minegeek360.jumpman;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;

/** @author MightyElemental
 * @since 28/10/2014 */
public class ResourceLoader {

	private Map<String, Image>	mapLoads	= new HashMap<String, Image>();
	private Map<String, Sound>	soundLoads	= new HashMap<String, Sound>();
	private Map<String, Music>	musicLoads	= new HashMap<String, Music>();

	/** Loads an image from the 'res/assets/textures' folder
	 * 
	 * @param imagePath
	 *            the path to the image beginning with 'res/assets/textures'. Remember that you can replace slashes '/'
	 *            with dots '.'
	 * @return Image the newly loaded image */
	public Image loadImage(String imagePath) {

		Image loadedImage = JumpMan.NULL_IMAGE;

		String location = imagePath.replaceAll("[.]", "/");
		location += ".png";
		if (mapLoads.get(location) != null) {
			return mapLoads.get(location);
		} else {
			try {
				loadedImage = new Image("res/assets/textures/" + location);
				System.out.println("res/assets/textures/" + location + " - has been added");
			} catch (Exception e) {
				System.out.println("CANT LOAD IMAGE '" + location + "'");
			}
			mapLoads.put(location, loadedImage);
		}

		return loadedImage;
	}

	/** Loads a music file from the 'res/assets/sounds/music' folder
	 * 
	 * @param musicPath
	 *            the path to the sound file beginning with 'res/assets/sounds/music'. Remember that you can replace
	 *            slashes '/' with dots '.'
	 * @return Music the newly loaded music file */
	public Music loadMusic(String musicPath) {

		Music loadedMusic = null;

		String location = musicPath.replaceAll("[.]", "/");
		location += ".mp3";
		if (mapLoads.get(location) != null) {
			return musicLoads.get(location);
		} else {
			try {
				loadedMusic = new Music("res/assets/sounds/music/" + location);
				System.out.println("res/assets/sounds/music/" + location + " - has been added");
			} catch (Exception e) {
				System.out.println("CANT LOAD MUSIC '" + location + "'");
			}
			musicLoads.put(location, loadedMusic);
		}

		return loadedMusic;
	}

	/** Loads a sound file from the 'res/assets/sounds' folder
	 * 
	 * @param soundPath
	 *            the path to the sound file beginning with 'res/assets/sounds'. Remember that you can replace slashes
	 *            '/' with dots '.'
	 * @return Sound the newly loaded sound */
	public Sound loadSound(String soundPath) {

		Sound loadedSound = null;

		String location = soundPath.replaceAll("[.]", "/");
		location += ".mp3";
		if (mapLoads.get(location) != null) {
			return soundLoads.get(location);
		} else {
			try {
				loadedSound = new Sound("res/assets/sounds/" + location);
				System.out.println("res/assets/sounds/" + location + " - has been added");
			} catch (Exception e) {
				System.out.println("CANT LOAD SOUND '" + location + "'");
			}
			soundLoads.put(location, loadedSound);
		}

		return loadedSound;
	}

	public Image loadImageFromFile(String imagePath) {
		String location = imagePath.replaceAll("[.]", "/");
		Image temp = JumpMan.NULL_IMAGE;
		try {
			if (mapLoads.get(location) != null) {
				// System.out.println("LOADED ORIGIONAL IMAGE");
				return mapLoads.get(location);
			} else {
				temp = new Image(location);
				// System.out.println("LOADED NEW IMAGE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

}
