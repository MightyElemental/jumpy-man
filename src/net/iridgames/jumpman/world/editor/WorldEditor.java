package net.iridgames.jumpman.world.editor;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import net.iridgames.jumpman.world.objects.WorldObject;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Checkbox;

@SuppressWarnings( "serial" )
public class WorldEditor extends JFrame {

	private JPanel contentPane;

	public JRadioButtonMenuItem	rdbtnmntmNoTexture;
	public JRadioButtonMenuItem	rdbtnmntmTexture;

	public JSpinner	spinnerGridSize;
	public Checkbox	checkboxShowNumbers;
	public Checkbox	checkboxShowGrid;

	List list;

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
		Field[] temp = Material.class.getDeclaredFields();
		for (Field f : temp) {
			if (f.getType().equals(Material.class)) {
				String tex = (((Material) f.get("")).getTexLoc());
				map.put(f.getName(), tex);
			}
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
		setBounds(100, 100, 1274, 811);

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

		JMenuItem mntmNewObject = new JMenuItem("New Object");
		mnEdit.add(mntmNewObject);
		mntmNewObject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desPanel.objects.add(new WorldObject(desPanel.getWidth() / 2, desPanel.getHeight() / 2, 50, 50, Material.matNull));
				desPanel.reloadObjects();
				desPanel.repaint();
			}

		});

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		ButtonGroup group = new ButtonGroup();

		rdbtnmntmNoTexture = new JRadioButtonMenuItem("No Texture");
		mnView.add(rdbtnmntmNoTexture);
		group.add(rdbtnmntmNoTexture);

		rdbtnmntmTexture = new JRadioButtonMenuItem("Texture");
		mnView.add(rdbtnmntmTexture);
		group.add(rdbtnmntmTexture);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		list = new List();
		list.setBounds(1024, 39, 234, 538);
		contentPane.add(list);

		desPanel = new Designer(this);
		desPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		desPanel.setBounds(10, 11, 1008, 566);
		contentPane.add(desPanel);

		Label label = new Label("Objects");
		label.setAlignment(Label.CENTER);
		label.setBounds(1024, 11, 234, 22);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 588, 428, 163);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblProperties = new JLabel("Properties");
		lblProperties.setBounds(10, 11, 64, 14);
		panel.add(lblProperties);

		JLabel lblGridSize = new JLabel("Grid Size");
		lblGridSize.setBounds(10, 36, 62, 14);
		panel.add(lblGridSize);

		spinnerGridSize = new JSpinner();
		spinnerGridSize.setBounds(66, 33, 39, 20);
		panel.add(spinnerGridSize);
		spinnerGridSize.setModel(new SpinnerNumberModel(8, 2, 20, 2));

		checkboxShowNumbers = new Checkbox("Show Object Numbers");
		checkboxShowNumbers.setBounds(10, 56, 143, 23);
		panel.add(checkboxShowNumbers);

		checkboxShowGrid = new Checkbox("Show Grid");
		checkboxShowGrid.setState(true);
		checkboxShowGrid.setBounds(10, 85, 101, 23);
		panel.add(checkboxShowGrid);
	}
}
