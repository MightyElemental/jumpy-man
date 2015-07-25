package net.minegeek360.jumpman;

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

@SuppressWarnings("serial")
public class StartupSettings extends JFrame
{

	private JPanel contentPane;

	/** Launch the application. */
	public void startUp()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					StartupSettings frame = new StartupSettings();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	JComboBox<String>	aspComboBox	= new JComboBox<String>();
	JComboBox<String>	resComboBox	= new JComboBox<String>();

	/** Create the frame. */
	public StartupSettings()
	{
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

		final JLabel lblNewLabel = new JLabel("60 frames per second");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(126, 101, 154, 23);
		contentPane.add(lblNewLabel);

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
		for (int i = 0; i < JumpMan.commonRatios.length; i++)
		{
			aspComboBox.addItem((int) JumpMan.commonRatios[i][0] + ":" + (int) JumpMan.commonRatios[i][1]);
		}

		aspComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LoadResolution();

			}
		});

		JButton btnNewButton = new JButton("Launch");

		btnNewButton.setBounds(10, 202, 280, 63);
		contentPane.add(btnNewButton);

		final JCheckBox chckbxFullscreen = new JCheckBox("Fullscreen");
		chckbxFullscreen.setBounds(6, 168, 85, 23);
		contentPane.add(chckbxFullscreen);

		JLabel lblMaxFps = new JLabel("Max FPS:");
		lblMaxFps.setBounds(10, 80, 106, 14);
		contentPane.add(lblMaxFps);

		final JSlider slider = new JSlider();
		slider.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				lblNewLabel.setText(slider.getValue() + " frames per second");
			}
		});

		slider.setPaintLabels(true);
		slider.setMinimum(30);
		slider.setValue(60);
		slider.setMaximum(240);
		slider.setBounds(126, 73, 154, 31);

		contentPane.add(slider);

		final JCheckBox chckbxShowFps = new JCheckBox("Show FPS");
		chckbxShowFps.setBounds(93, 168, 106, 23);
		contentPane.add(chckbxShowFps);

		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JumpMan.width = JumpMan.commonResolutions[aspComboBox.getSelectedIndex()][resComboBox.getSelectedIndex()];
				JumpMan.aspectRatio = JumpMan.commonRatios[aspComboBox.getSelectedIndex()];
				JumpMan.maxFPS = slider.getValue();
				JumpMan.fullscreen = chckbxFullscreen.isSelected();
				JumpMan.showFPS = chckbxShowFps.isSelected();
				JumpMan.startGame();
			}
		});

		LoadResolution();
	}

	public void LoadResolution()
	{
		resComboBox.removeAllItems();
		for (int i = 0; i < JumpMan.commonResolutions[aspComboBox.getSelectedIndex()].length; i++)
		{
			int height = (int) (JumpMan.commonResolutions[aspComboBox.getSelectedIndex()][i]
					* (JumpMan.commonRatios[aspComboBox.getSelectedIndex()][1] / JumpMan.commonRatios[aspComboBox.getSelectedIndex()][0]));
			resComboBox.addItem(JumpMan.commonResolutions[aspComboBox.getSelectedIndex()][i] + ":" + height);
		}
	}
}
