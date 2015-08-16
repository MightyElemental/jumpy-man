package net.iridgames.jumpman;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings( "serial" )
public class ControlSettings extends JFrame {

	private JPanel contentPane;

	/** Launch the application. */
	public static void startUp() {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					ControlSettings frame = new ControlSettings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JButton	btnLeft		= new JButton("A");
	JButton	btnRight	= new JButton("D");
	JButton	btnJump		= new JButton("W");

	private boolean	btnJumpEdit		= false;
	private boolean	btnRightEdit	= false;
	private boolean	btnLeftEdit		= false;

	public static int	jumpButton	= 0;
	public static int	leftButton	= 0;
	public static int	rightButton	= 0;

	private final JPanel panel = new JPanel();

	/** Create the frame. */
	public ControlSettings() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle(JumpMan.GAME_NAME + " | Control setup");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 283, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 277, 276);

		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLeft = new JLabel("Left");
		lblLeft.setBounds(34, 11, 46, 14);
		panel.add(lblLeft);
		btnLeft.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (btnLeftEdit) {
					btnLeft.setText(KeyEvent.getKeyText(e.getKeyCode()));
					leftButton = e.getKeyCode();
				}
				btnLeftEdit = false;
				updateKeys();
			}
		});

		btnLeft.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnLeft.setText("<Press a key>");
				btnLeftEdit = true;
			}
		});
		btnLeft.setBounds(114, 7, 127, 23);
		panel.add(btnLeft);

		JLabel lblRight = new JLabel("Right");
		lblRight.setBounds(34, 36, 46, 14);
		panel.add(lblRight);
		btnRight.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (btnRightEdit) {
					btnRight.setText(KeyEvent.getKeyText(e.getKeyCode()));
					rightButton = e.getKeyCode();
				}
				btnRightEdit = false;
				updateKeys();
			}
		});
		btnRight.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnRight.setText("<Press a key>");
				btnRightEdit = true;
			}
		});

		btnRight.setBounds(114, 32, 127, 23);
		panel.add(btnRight);

		JLabel lblJump = new JLabel("Jump");
		lblJump.setBounds(34, 61, 46, 14);
		panel.add(lblJump);
		btnJump.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (btnJumpEdit) {
					btnJump.setText(KeyEvent.getKeyText(e.getKeyCode()));
					jumpButton = e.getKeyCode();
				}
				btnJumpEdit = false;
				updateKeys();
			}
		});
		btnJump.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnJump.setText("<Press a key>");
				btnJumpEdit = true;
			}
		});

		btnJump.setBounds(114, 57, 127, 23);
		panel.add(btnJump);
	}

	private void updateKeys() {

	}

}
