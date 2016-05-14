/*This frame prompts the user to start the program*/
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class StartFrame extends JFrame {
	JLabel text1;
	JLabel text2;
	JButton startClock;
	JButton classicClock;
	JButton settings;
	public StartFrame(String title) throws IOException {
		super(title);
		text1 = new JLabel("PTClock ver.2.0 Beta");
		text2 = new JLabel("By: Jeffrey Fei from Pinetree C.S.C.");
		settings = new JButton();
		
		text1.setFont(new Font("TimesRoman", Font.BOLD, 15));
		
		startClock = new JButton();
		startClock.setText("Normal");
		startClock.setSize(10, 10);
		startClock.setFont(new Font("TimesRoman", Font.BOLD, 20));
		startClock.addActionListener(new ActionListener() {
			//action listener that opens up the main program when the button is clicked
			@Override
			public void actionPerformed(ActionEvent arg0) {
				////////////////////////Program Frame/////////////////////////
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				final int frameWidth = screenSize.width;
				final int frameHeight = (int) (screenSize.height * 0.25);
				JFrame frame;
				try {
					frame = new MainFrame("Pinetree Clock");
					frame.setResizable(false);
					frame.setUndecorated(true);
					frame.setSize(frameWidth, frameHeight);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					frame.setAlwaysOnTop(true);
					frame.setLocation(0, screenSize.height - frameHeight);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setVisible(false);
			}
		});
		
		
		classicClock = new JButton();
		classicClock.setText("Classic");
		classicClock.setSize(10, 10);
		classicClock.setFont(new Font("TimesRoman", Font.BOLD, 20));
		classicClock.addActionListener(new ActionListener() {
			//action listener that opens up the main program when the button is clicked
			@Override
			public void actionPerformed(ActionEvent arg0) {
				////////////////////////Program Frame/////////////////////////
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				final int frameWidth = screenSize.width;
				final int frameHeight = (int) (screenSize.height * 0.25);
				JFrame frame;
				try {
					frame = new MainClassic("Pinetree Clock");
					frame.setResizable(false);
					frame.setUndecorated(true);
					frame.setSize(frameWidth, frameHeight);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					frame.setAlwaysOnTop(true);
					frame.setLocation(0, screenSize.height - frameHeight);
					setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		settings = new JButton();
		settings.setText("Settings");
		settings.setSize(10, 10);
		settings.setFont(new Font("TimesRoman", Font.BOLD, 20));
		settings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				////////////////////////Welcome Frame/////////////////////////
				final int stFrameWidth = 500;
				final int stFrameHeight = 400;
				JFrame set;
				try {
					set = new SettingsFrame("Settings");
					set.setSize(stFrameWidth, stFrameHeight);
					set.setResizable(false);
					set.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					set.setVisible(true);
					set.setLocation(screenSize.width / 2 - stFrameWidth / 2, screenSize.height / 2 - stFrameHeight / 2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		

		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 0;
		add(text1, gc);
		

		gc.gridx = 0;
		gc.gridy = 1;
		add(startClock, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(classicClock, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(settings, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add(text2, gc);

		
	}
}
