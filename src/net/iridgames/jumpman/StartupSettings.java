package net.iridgames.jumpman;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;

@SuppressWarnings( "serial" )
public class StartupSettings extends JFrame {

	private JPanel contentPane;

	/** Launch the application. */
	public void startUp() {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					StartupSettings frame = new StartupSettings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JComboBox<String>	aspComboBox			= new JComboBox<String>();
	JComboBox<String>	resComboBox			= new JComboBox<String>();
	JCheckBox			chckbxShowFps		= new JCheckBox("Show FPS");
	JSlider				slider				= new JSlider();
	JCheckBox			chckbxFullscreen	= new JCheckBox("Fullscreen");
	JCheckBox			chckbxVsync			= new JCheckBox("VSync");
	private JPanel		panel;

	/** Create the frame. */
	public StartupSettings() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle(JumpMan.GAME_NAME + " | Game setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 300, 276);
		contentPane.add(panel);
		panel.setLayout(null);

		final JLabel lblNewLabel = new JLabel("60 Frames Per Second");
		lblNewLabel.setBounds(136, 116, 154, 23);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < JumpMan.commonRatios.length; i++) {
			aspComboBox.addItem((int) JumpMan.commonRatios[i][0] + ":" + (int) JumpMan.commonRatios[i][1]);
		}
		aspComboBox.setBounds(136, 21, 154, 20);
		panel.add(aspComboBox);

		aspComboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				LoadResolution();
			}
		});
		slider.setBounds(136, 92, 154, 31);
		panel.add(slider);

		slider.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				lblNewLabel.setText(slider.getValue() + " Frames Per Second");
			}
		});

		slider.setPaintLabels(true);
		slider.setMinimum(30);
		slider.setValue(60);
		slider.setMaximum(240);
		chckbxShowFps.setBounds(115, 171, 85, 23);
		panel.add(chckbxShowFps);
		chckbxShowFps.setSelected(true);
		chckbxVsync.setBounds(215, 171, 67, 23);
		panel.add(chckbxVsync);
		chckbxVsync.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (chckbxVsync.isSelected()) {
					slider.setEnabled(false);
					lblNewLabel.setForeground(new Color(155, 155, 155));

				} else {
					slider.setEnabled(true);
					lblNewLabel.setForeground(new Color(0, 0, 0));
				}
			}
		});

		LoadResolution();
	}

	public void launchGame() {
		this.setVisible(false);
		JumpMan.width = JumpMan.commonResolutions[aspComboBox.getSelectedIndex()][resComboBox.getSelectedIndex()];
		JumpMan.aspectRatio = JumpMan.commonRatios[aspComboBox.getSelectedIndex()];
		JumpMan.maxFPS = slider.getValue();
		JumpMan.fullscreen = chckbxFullscreen.isSelected();
		JumpMan.showFPS = chckbxShowFps.isSelected();
		JumpMan.vsync = chckbxVsync.isSelected();
		JumpMan.startGame();
	}

	public void LoadResolution() {
		resComboBox.setBounds(136, 58, 154, 20);
		panel.add(resComboBox);

		JLabel resolutionLabel = new JLabel("Resolution:");
		resolutionLabel.setBounds(10, 61, 106, 14);
		panel.add(resolutionLabel);

		JLabel lblAspectRatio = new JLabel("Aspect Ratio:");
		lblAspectRatio.setBounds(10, 24, 106, 14);
		panel.add(lblAspectRatio);

		JButton btnNewButton = new JButton("Launch");
		btnNewButton.setBounds(10, 202, 280, 63);
		panel.add(btnNewButton);
		chckbxFullscreen.setBounds(15, 171, 85, 23);
		panel.add(chckbxFullscreen);

		JLabel lblMaxFps = new JLabel("Max FPS:");
		lblMaxFps.setBounds(10, 100, 106, 14);
		panel.add(lblMaxFps);

		JButton btnEditControls = new JButton("Edit controls");
		btnEditControls.setEnabled(false);
		btnEditControls.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ControlSettings.startUp();
			}
		});
		btnEditControls.setBounds(10, 141, 280, 23);
		panel.add(btnEditControls);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				launchGame();
			}
		});
		resComboBox.removeAllItems();
		for (int i = 0; i < JumpMan.commonResolutions[aspComboBox.getSelectedIndex()].length; i++) {
			int height = (int) (JumpMan.commonResolutions[aspComboBox.getSelectedIndex()][i]
					* (JumpMan.commonRatios[aspComboBox.getSelectedIndex()][1] / JumpMan.commonRatios[aspComboBox.getSelectedIndex()][0]));
			resComboBox.addItem(JumpMan.commonResolutions[aspComboBox.getSelectedIndex()][i] + ":" + height);
		}
	}
}
