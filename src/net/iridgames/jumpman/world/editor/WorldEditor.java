package net.iridgames.jumpman.world.editor;

import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.iridgames.jumpman.world.objects.Material;
import net.iridgames.jumpman.world.objects.WorldObject;
import javax.swing.JButton;

@SuppressWarnings( "serial" )
public class WorldEditor extends JFrame {

	private JPanel contentPane;

	public JRadioButtonMenuItem	rdbtnmntmNoTexture;
	public JRadioButtonMenuItem	rdbtnmntmTexture;

	public JSpinner	spinnerGridSize;
	public Checkbox	checkboxShowNumbers;
	public Checkbox	checkboxShowGrid;

	public JSpinner	spinnerXpos;
	public JSpinner	spinnerYpos;
	public JSpinner	spinnerWidth;
	public JSpinner	spinnerHeight;

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

	private JTextField textField;

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
		setBounds(100, 100, 1290, 811);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					desPanel.save();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnFile.add(mntmSave);

		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					desPanel.load();
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		mnFile.add(mntmLoad);

		JMenuItem mntmExport = new JMenuItem("Export");
		mnFile.add(mntmExport);

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

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(1024, 11, 248, 566);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		list = new List();
		list.setBounds(10, 38, 228, 518);
		panel_2.add(list);

		Label label = new Label("Objects");
		label.setBounds(10, 10, 214, 22);
		panel_2.add(label);
		label.setAlignment(Label.CENTER);

		desPanel = new Designer(this);
		desPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		desPanel.setBounds(10, 11, 1008, 566);
		contentPane.add(desPanel);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 588, 163, 163);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblProperties = new JLabel("Properties");
		lblProperties.setHorizontalAlignment(SwingConstants.CENTER);
		lblProperties.setBounds(10, 11, 143, 14);
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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(185, 588, 273, 162);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblObjectProperies = new JLabel("Object Properies");
		lblObjectProperies.setHorizontalAlignment(SwingConstants.CENTER);
		lblObjectProperies.setBounds(12, 12, 251, 16);
		panel_1.add(lblObjectProperies);

		JLabel lblXPos = new JLabel("X Pos");
		lblXPos.setBounds(12, 40, 41, 16);
		panel_1.add(lblXPos);

		JLabel lblYPos = new JLabel("Y Pos");
		lblYPos.setBounds(12, 68, 41, 16);
		panel_1.add(lblYPos);

		JLabel lblWidth = new JLabel("Width");
		lblWidth.setBounds(12, 96, 55, 16);
		panel_1.add(lblWidth);

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(12, 124, 55, 16);
		panel_1.add(lblHeight);

		spinnerXpos = new JSpinner();
		spinnerXpos.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinnerXpos.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				desPanel.setXOfCurrentObject((int) spinnerXpos.getValue());
			}
		});
		spinnerXpos.setBounds(57, 38, 41, 20);
		panel_1.add(spinnerXpos);

		spinnerYpos = new JSpinner();
		spinnerYpos.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinnerYpos.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				desPanel.setYOfCurrentObject((int) spinnerYpos.getValue());
			}
		});
		spinnerYpos.setBounds(57, 66, 41, 20);
		panel_1.add(spinnerYpos);

		spinnerWidth = new JSpinner();
		spinnerWidth.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinnerWidth.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent arg0) {
				desPanel.setWidthOfCurrentObject((int) spinnerWidth.getValue());
			}
		});
		spinnerWidth.setBounds(57, 94, 41, 20);
		panel_1.add(spinnerWidth);

		spinnerHeight = new JSpinner();
		spinnerHeight.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinnerHeight.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				desPanel.setHeightOfCurrentObject((int) spinnerHeight.getValue());
			}
		});
		spinnerHeight.setBounds(57, 122, 41, 20);
		panel_1.add(spinnerHeight);

		JLabel lblLabel = new JLabel("Label");
		lblLabel.setBounds(117, 40, 55, 16);
		panel_1.add(lblLabel);

		textField = new JTextField();
		textField.setBounds(160, 38, 103, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				desPanel.deleteCurrentObj();
			}
		});
		btnDelete.setBounds(160, 119, 101, 31);
		panel_1.add(btnDelete);
	}
}
