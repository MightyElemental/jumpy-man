package net.iridgames.jumpman.world.editor;

import java.awt.EventQueue;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.iridgames.jumpman.world.objects.Material;

public class WorldEditor extends JFrame {

	private JPanel contentPane;

	private Designer desPanel;

	/** Launch the application. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					WorldEditor frame = new WorldEditor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Map<String, Object> map = new HashMap<String, Object>();

	public void getMaterials() throws IllegalArgumentException, IllegalAccessException {// Please fix world editor :(
		Field[] temp = Material.class.getFields();
		for (Field f : temp) {
			if (f.getType().equals(Material.class)) {
				map.put(f.getName(), f.get("matName"));
			}
		}
		for (String s : map.keySet()) {
			System.out.println(map.get(s));
		}
	}

	/** Create the frame. */
	public WorldEditor() {
		try {
			getMaterials();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
		setTitle("JumpMan World Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 647);

		desPanel = new Designer();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		ButtonGroup group = new ButtonGroup();

		JRadioButtonMenuItem rdbtnmntmNoTexture = new JRadioButtonMenuItem("No Texture");
		mnView.add(rdbtnmntmNoTexture);
		group.add(rdbtnmntmNoTexture);

		JRadioButtonMenuItem rdbtnmntmTexture = new JRadioButtonMenuItem("Texture");
		mnView.add(rdbtnmntmTexture);
		group.add(rdbtnmntmTexture);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		desPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		desPanel.setBounds(10, 11, 1008, 566);
		contentPane.add(desPanel);
	}
}
