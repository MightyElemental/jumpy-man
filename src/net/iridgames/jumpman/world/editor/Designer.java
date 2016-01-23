package net.iridgames.jumpman.world.editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import net.iridgames.jumpman.world.objects.Material;
import net.iridgames.jumpman.world.objects.ObjBlock;
import net.iridgames.jumpman.world.objects.ObjFluid;
import net.iridgames.jumpman.world.objects.ObjGravityReverse;
import net.iridgames.jumpman.world.objects.WorldObject;

@SuppressWarnings( "serial" )
public class Designer extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

	public List<WorldObject> objects = new ArrayList<WorldObject>();

	public int		camX;
	public int		camY;
	public float	camZoom	= 1;

	private WorldEditor editor;

	public float sizeRatio = 1;

	public Color	grayTransBlock	= new Color(.5f, .5f, .5f, 0.8f);
	public Color	greenTransBlock	= new Color(.4f, .8f, .4f, 0.8f);

	public Designer( WorldEditor worldEditor ) {
		editor = worldEditor;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
		// objects.add(new WorldBlock(500, 170, 4000, 10));
		// objects.add(new WorldBlock(800, 50, 10, 500, Material.matIron));
		objects.add(new ObjBlock(-5, 50, 10, 500, Material.matIron).setSolid(true));
		// objects.add(port);
		// objects.add(port2);
		objects.add(new ObjGravityReverse(300, 415, 30, 70));
		objects.add(new ObjBlock(330, 275, 10, 200, Material.matIron));
		objects.add(new ObjFluid(0, 720 - 50, 1280, 50, Material.matFluid.setToxic(true)));
		objects.add(new ObjBlock(0, 500, 1280 - 400, 50, Material.matIron));
		reloadObjects();
		paint.start();
	}

	TextureLoader loader = new TextureLoader();

	public void paint(Graphics g1) {
		sizeRatio = this.getWidth() / 1280f;
		super.paint(g1);
		Graphics2D g = (Graphics2D) g1;
		if (editor.checkboxShowGrid.getState()) {
			for (float i = 0; i < this.getWidth(); i += ((int) editor.spinnerGridSize.getValue()) * camZoom) {
				int i1 = (int) i;
				g.drawLine(i1, 0, i1, this.getHeight());
			}
			for (float i = 0; i < this.getHeight(); i += ((int) editor.spinnerGridSize.getValue()) * camZoom) {
				int i1 = (int) i;
				g.drawLine(0, i1, this.getWidth(), i1);
			}
		}
		for (int i = 0; i < objects.size(); i++) {
			WorldObject wo = objects.get(i);
			g.setColor(Color.BLACK);

			g.drawRect((int) ((camX) * sizeRatio * camZoom), (int) ((camY) * sizeRatio * camZoom), (int) ((getWidth()) * camZoom),
					(int) ((getHeight()) * camZoom));
			g.drawRect((int) ((camX - 5) * sizeRatio * camZoom), (int) ((camY - 5) * sizeRatio * camZoom),
					(int) ((getWidth() + 10) * camZoom), (int) ((getHeight() + 10) * camZoom));

			if (i == editor.list.getSelectedIndex()) {
				g.setColor(greenTransBlock);
			} else {
				g.setColor(grayTransBlock);
			}

			int x = (int) (((wo.getX() + camX) * sizeRatio) * camZoom);
			int y = (int) (((wo.getY() + camY) * sizeRatio) * camZoom);
			int w = (int) ((wo.getWidth() * sizeRatio) * camZoom);
			int h = (int) ((wo.getHeight() * sizeRatio) * camZoom);

			if (editor.rdbtnmntmTexture.isSelected()) {
				BufferedImage image = loader.loadImage(objects.get(i).getMaterial().getTexLoc());
				g.drawImage(image, x, y, w, h, null);
			} else {
				g.fillRect(x, y, w, h);
			}
			g.setColor(Color.BLACK);
			g.drawRect(x, y, w, h);
			if (i == editor.list.getSelectedIndex()) {
				g.setColor(Color.GREEN);
				g.drawRect(x, y, w, h);
			}
			if (editor.checkboxShowNumbers.getState()) {
				g.setColor(grayTransBlock.darker());
				g.fillRect(x, y - (int) (13 * camZoom), (int) (10 * camZoom), (int) (11 * camZoom));
				g.setColor(Color.WHITE);
				g.drawString(i + "", x + (int) (2 * sizeRatio), y - (int) (4 * sizeRatio));
			}
		}
	}

	public Thread paint = new Thread() {

		public void run() {
			while (true) {
				repaint();
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	@Override
	public void mouseDragged(MouseEvent e) {
		if (buttonPressed == MouseEvent.BUTTON3) {
			camX -= tempX - e.getX();
			camY -= tempY - e.getY();
		} else if (editor.list.getSelectedIndex() > -1) {
			WorldObject o = objects.get(editor.list.getSelectedIndex());
			o.setX(o.getX() + (e.getX() - tempX));
			o.setY(o.getY() + (e.getY() - tempY));
		}
		tempX = e.getX();
		tempY = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	int	tempX	= 0;
	int	tempY	= 0;

	int buttonPressed = 0;

	@Override
	public void mousePressed(MouseEvent e) {
		buttonPressed = e.getButton();
		tempX = e.getX();
		tempY = e.getY();
		if (e.getButton() == MouseEvent.BUTTON1) {
			for (int i = 0; i < objects.size(); i++) {
				WorldObject wo = objects.get(i);
				int x = (int) (((wo.getX() + camX) * sizeRatio) * camZoom);
				int y = (int) (((wo.getY() + camY) * sizeRatio) * camZoom);
				int w = (int) ((wo.getWidth() * sizeRatio) * camZoom);
				int h = (int) ((wo.getHeight() * sizeRatio) * camZoom);
				Rectangle rect = new Rectangle(x, y, w, h);

				if (rect.contains(e.getX(), e.getY())) {
					editor.list.select(i);
					return;
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttonPressed = 0;
		reloadObjects();
	}

	public void reloadObjects() {
		editor.list.removeAll();
		for (int i = 0; i < objects.size(); i++) {
			int x = (int) objects.get(i).getX();
			int y = (int) objects.get(i).getY();
			int w = (int) objects.get(i).getWidth();
			int h = (int) objects.get(i).getHeight();
			editor.list.add("[" + i + "]   \tx: " + x + " y: " + y + " width: " + w + " height: " + h);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		camZoom += e.getWheelRotation() * -0.01f;
	}

	public void save() {

	}

}
