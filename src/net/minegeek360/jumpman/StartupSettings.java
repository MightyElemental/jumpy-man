package net.minegeek360.jumpman;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
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

	JComboBox<String> aspComboBox = new JComboBox<String>();
	JComboBox<String> resComboBox = new JComboBox<String>();

	/** Create the frame. */
	public StartupSettings() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Game setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		resComboBox.setBounds(126, 46, 154, 20);
		contentPane.add(resComboBox);

		JLabel resolutionLabel = new JLabel("Resolution:");
		resolutionLabel.setBounds(10, 49, 106, 14);
		contentPane.add(resolutionLabel);

		JLabel lblAspectRatio = new JLabel("Aspect Ratio:");
		lblAspectRatio.setBounds(10, 18, 106, 14);
		contentPane.add(lblAspectRatio);

		aspComboBox.setBounds(126, 15, 154, 20);
		contentPane.add(aspComboBox);
		for (int i = 0; i < JumpMan.commonRatios.length; i++) {
			aspComboBox.addItem((int) JumpMan.commonRatios[i][0] + ":" + (int) JumpMan.commonRatios[i][1]);
		}

		aspComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(aspComboBox.getSelectedIndex());
				resComboBox.removeAllItems();
				for (int i = 0; i < JumpMan.commonResolutions[aspComboBox.getSelectedIndex()].length; i++) {
					int height = (int) (JumpMan.commonResolutions[aspComboBox.getSelectedIndex()][i]
							* (JumpMan.commonRatios[aspComboBox.getSelectedIndex()][1]
									/ JumpMan.commonRatios[aspComboBox.getSelectedIndex()][0]));
					resComboBox.addItem(JumpMan.commonResolutions[aspComboBox.getSelectedIndex()][i] + ":" + height);
				}
			}
		});

		JButton btnNewButton = new JButton("Launch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JumpMan.width = JumpMan.commonResolutions[aspComboBox.getSelectedIndex()][resComboBox.getSelectedIndex()];
				JumpMan.aspectRatio = JumpMan.commonRatios[aspComboBox.getSelectedIndex()];
				JumpMan.startGame();
			}
		});
		btnNewButton.setBounds(10, 202, 280, 63);
		contentPane.add(btnNewButton);
	}
}
