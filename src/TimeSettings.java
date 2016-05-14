import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class TimeSettings extends JFrame {
	JLabel top;
	JLabel hoursText;
	JLabel minText;
	JLabel colon;
	JTextField hours;
	JTextField min;
	JButton save;
	JButton cancel;
	JButton def;
	Dimension screenSize;
	boolean hasError = false;
	
	public TimeSettings(String title) {
		super(title);
		top = new JLabel("24-Hour Format Only");
		hoursText = new JLabel("Hours");
		minText = new JLabel("Minutes");
		colon = new JLabel(":");
		hours = new JTextField();
		min = new JTextField();
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		def = new JButton("Default");
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		top.setFont(new Font("Arial", Font.BOLD, 14));
		
		int textFieldWidth = 3;
		hours.setColumns(textFieldWidth);
		min.setColumns(textFieldWidth);


		
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					saveTime();
					if(hasError) {
						JFrame error = new Error("Error");
						int frameWidth = 100;
						int frameHeight = 100;
						error.setSize(frameWidth, frameHeight);
						error.setResizable(false);
						error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						error.setVisible(true);	
						error.setLocation(screenSize.width / 2 - frameWidth / 2, screenSize.height / 2 - frameHeight / 2);
						error.setAlwaysOnTop(true);
					} else {
						setVisible(false);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
			
		});
		
		
		////////////////Action Listener for Cancel////////////////////////
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
			}
			
		});
		
		/////////////////////Action Listener for Default///////////////////////
		def.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Integer> temp;
				try {
					temp = (new BlockRotation()).readSettings();
				
				int[] settings = new int[temp.size()];
				for(int i = 0; i < temp.size(); ++i) {
					settings[i] = temp.get(i);
				}
				settings[20] = 0;
				new BlockRotation().saveSettings(settings);
				setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		
		/////////////////////Layout//////////////////////
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 1;
		gc.gridy = 0;
		add(top, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(hoursText, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		add(minText, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(hours, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(colon, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(min, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(save, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(cancel, gc);
		
		gc.gridx = 2;
		gc.gridy = 3;
		add(def, gc);
		
		
	}
	
	//index for time data is 20, 21
	private void saveTime() throws IOException {
		ArrayList<Integer> temp = (new BlockRotation()).readSettings();
		
		
		try {
			if(Integer.parseInt(hours.getText()) < 25 && Integer.parseInt(min.getText()) < 61) {
				int[] settings = new int[temp.size()];
				for(int i = 0; i < temp.size(); ++i) {
					settings[i] = temp.get(i);
				}
				Time t = new Time();
				settings[20] = t.convertMinOfDay(Integer.parseInt(hours.getText()), Integer.parseInt(min.getText())) - t.getMinOfDay();
				new BlockRotation().saveSettings(settings);
				hasError = false;
			} else {
				errorHandle();
			}
		}
		catch(NumberFormatException nfe) {
			errorHandle();
		} catch(ArrayIndexOutOfBoundsException aiobe) {	
			errorHandle();
		}
	}
	
	private void errorHandle() throws IOException {
		ArrayList<Integer> temp = (new BlockRotation()).readSettings();
		int[] settings = new int[temp.size()];
		for(int i = 0; i < temp.size(); ++i) {
			settings[i] = temp.get(i);
		}
		settings[20] = 0;
		new BlockRotation().saveSettings(settings);
		hasError = true;
	}
}
