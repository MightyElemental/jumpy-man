package net.minegeek360.jumpman;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StartupSettings extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 46, 154, 20);
		contentPane.add(comboBox);
		
		
		
		JLabel resolutionLabel = new JLabel("Resolution:");
		resolutionLabel.setBounds(10, 49, 106, 14);
		contentPane.add(resolutionLabel);
		
		JLabel lblAspectRatio = new JLabel("Aspect Ratio:");
		lblAspectRatio.setBounds(10, 18, 106, 14);
		contentPane.add(lblAspectRatio);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(126, 15, 154, 20);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Launch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JumpMan.startGame();
			}
		});
		btnNewButton.setBounds(10, 202, 280, 63);
		contentPane.add(btnNewButton);
		
	} 
}
