import java.awt.BorderLayout;
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
/*This frame functions as a way to change the rotation periods in the future when the schedule changes*/

public class SettingsFrame extends JFrame {
	JLabel monthTitle;
	JLabel dateTitle;
	JLabel yearTitle;
	JLabel title1;
	JLabel title2;
	JLabel title3;
	JLabel title4;
	JLabel title5;
	JLabel spacing;
	JTextField month1Text;
	JTextField month2Text;
	JTextField month3Text;
	JTextField month4Text;
	JTextField month5Text;
	JTextField date1Text;
	JTextField date2Text;
	JTextField date3Text;
	JTextField date4Text;
	JTextField date5Text;
	JTextField year1Text;
	JTextField year2Text;
	JTextField year3Text;
	JTextField year4Text;
	JTextField year5Text;
	JButton save;
	JButton cancel;
	JButton setTime;
	Dimension screenSize;
	Boolean hasError;

	
	
	public SettingsFrame(String title) throws IOException {
		super(title);
		final BlockRotation br = new BlockRotation();
		ArrayList<Integer> data = br.readSettings();
		hasError = false;
		
		monthTitle = new JLabel("Month");
		dateTitle = new JLabel("Date");
		yearTitle = new JLabel("Year");
		monthTitle.setFont(new Font("Arial", Font.BOLD, 15));
		dateTitle.setFont(new Font("Arial", Font.BOLD, 15));
		yearTitle.setFont(new Font("Arial", Font.BOLD, 15));
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		title1 = new JLabel("First Day of School");
		title2 = new JLabel("First Block Rotation");
		title3 = new JLabel("Second Block Rotation");
		title4 = new JLabel("Third Block Rotation");
		title5 = new JLabel("Last Day of School");
		spacing = new JLabel("");
		date1Text = new JTextField();
		date2Text = new JTextField();
		date3Text = new JTextField();
		date4Text = new JTextField();
		date5Text = new JTextField();
		month1Text = new JTextField();
		month2Text = new JTextField();
		month3Text = new JTextField();
		month4Text = new JTextField();
		month5Text = new JTextField();
		year1Text = new JTextField();
		year2Text = new JTextField();
		year3Text = new JTextField();
		year4Text = new JTextField();
		year5Text = new JTextField();
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		setTime = new JButton("Set Time");
		
		date1Text.setText(data.get(5) + "");
		date2Text.setText(data.get(8) + "");
		date3Text.setText(data.get(11) + "");
		date4Text.setText(data.get(14) + "");
		date5Text.setText(data.get(17) + "");
		month1Text.setText(data.get(6) + "");
		month2Text.setText(data.get(9) + "");
		month3Text.setText(data.get(12) + "");
		month4Text.setText(data.get(15) + "");
		month5Text.setText(data.get(18) + "");
		year1Text.setText(data.get(7) + "");
		year2Text.setText(data.get(10) + "");
		year3Text.setText(data.get(13) + "");
		year4Text.setText(data.get(16) + "");
		year5Text.setText(data.get(19) + "");
		
		int textFieldWidth = 3;
		date1Text.setColumns(textFieldWidth);
		date2Text.setColumns(textFieldWidth);
		date3Text.setColumns(textFieldWidth);
		date4Text.setColumns(textFieldWidth);
		date5Text.setColumns(textFieldWidth);
		month1Text.setColumns(textFieldWidth);
		month2Text.setColumns(textFieldWidth);
		month3Text.setColumns(textFieldWidth);
		month4Text.setColumns(textFieldWidth);
		month5Text.setColumns(textFieldWidth);
		year1Text.setColumns(textFieldWidth);
		year2Text.setColumns(textFieldWidth);
		year3Text.setColumns(textFieldWidth);
		year4Text.setColumns(textFieldWidth);
		year5Text.setColumns(textFieldWidth);
		
		///////////////////////Action Listener for save//////////////////////
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					br.saveSettings(getSettings());
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
		
		/////////////////////////////Action Listener for cancel///////////////////
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
			}
			
		});
		
		setTime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame timeSettings = new TimeSettings("Set Time");
				int frameWidth = 400;
				int frameHeight = 200;
				timeSettings.setSize(frameWidth, frameHeight);
				timeSettings.setResizable(false);
				timeSettings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				timeSettings.setVisible(true);
				timeSettings.setLocation(screenSize.width / 2 - frameWidth / 2, screenSize.height / 2 - frameHeight / 2);
				
			}
			
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridx = 0;
		add(monthTitle, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(dateTitle, gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		add(yearTitle, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(title1, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(month1Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(date1Text, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(year1Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(title2, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add(month2Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		add(date2Text, gc);
		
		gc.gridx = 2;
		gc.gridy = 4;
		add(year2Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		add(title3, gc);
		
		gc.gridx = 0;
		gc. gridy = 6;
		add(month3Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 6;
		add(date3Text, gc);
		
		gc.gridx = 2;
		gc.gridy = 6;
		add(year3Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 7;
		add(title4, gc);
		
		gc.gridx = 0;
		gc.gridy = 8;
		add(month4Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 8;
		add(date4Text, gc);
		
		gc.gridx = 2;
		gc.gridy = 8;
		add(year4Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 9;
		add(title5, gc);
		
		gc.gridx = 0;
		gc.gridy = 10;
		add(month5Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 10;
		add(date5Text, gc);
		
		gc.gridx = 2;
		gc.gridy = 10;
		add(year5Text, gc);
		
		gc.gridx = 1;
		gc.gridy = 11;
		add(spacing, gc);
		
		gc.gridx = 0;
		gc.gridy = 12;
		add(save, gc);
		
		gc.gridx = 1;
		gc.gridy = 12;
		add(cancel, gc);
		
		gc.gridx = 2;
		gc.gridy = 12;
		add(setTime, gc);

	}
	
	// method to retrieve data from the text field and catch exceptions caused by invalid inputs
	private int[] getSettings() throws IOException {
			Time t = new Time();
		try{
			ArrayList<Integer> temp = (new BlockRotation()).readSettings();
			int dI1 = Integer.parseInt(date1Text.getText());
			int dI2 = Integer.parseInt(date2Text.getText());
			int dI3 = Integer.parseInt(date3Text.getText());
			int dI4 = Integer.parseInt(date4Text.getText());
			int dI5 = Integer.parseInt(date5Text.getText());
			int mI1 = Integer.parseInt(month1Text.getText());
			int mI2 = Integer.parseInt(month2Text.getText());
			int mI3 = Integer.parseInt(month3Text.getText());
			int mI4 = Integer.parseInt(month4Text.getText());
			int mI5 = Integer.parseInt(month5Text.getText());
			int yI1 = Integer.parseInt(year1Text.getText());
			int yI2 = Integer.parseInt(year2Text.getText());
			int yI3 = Integer.parseInt(year3Text.getText());
			int yI4 = Integer.parseInt(year4Text.getText());
			int yI5 = Integer.parseInt(year5Text.getText());
			
			int[] settings = {t.convertDateOfYear(dI1, mI1, yI1), t.convertDateOfYear(dI2, mI2, yI2), t.convertDateOfYear(dI3, mI3, yI3), t.convertDateOfYear(dI4, mI4, yI4), 
					t.convertDateOfYear(dI5, mI5, yI5), dI1, mI1, yI1, dI2, mI2, yI2, dI3, mI3, yI3, dI4, mI4, yI4, dI5, mI5, yI5, temp.get(20)};
			
			if(dI1 > 31 || dI2 > 31 || dI3 > 31 || dI4 > 31 || dI5 > 31 || mI1 > 12  || mI2 > 12  || mI3 > 12  || mI4 > 12  || mI5 > 12 ) {	
				settings = new int[temp.size()];
				hasError = true;
				for(int i = 0; i < temp.size(); ++i) {
					settings[i] = temp.get(i);
				}
			} 
			else {
				hasError = false;
			}
			return settings;
		}
		catch(NumberFormatException nfe) {
			ArrayList<Integer> temp = (new BlockRotation()).readSettings();
			int[] settings = new int[temp.size()];
			for(int i = 0; i < temp.size(); ++i) {
				settings[i] = temp.get(i);
			}
			hasError = true;
			return settings;
		} catch(ArrayIndexOutOfBoundsException aiobe) {				
			ArrayList<Integer> temp = (new BlockRotation()).readSettings();
			int[] settings = new int[temp.size()];
			for(int i = 0; i < temp.size(); ++i) {
				settings[i] = temp.get(i);
			}
			hasError = true;
			return settings;
		}
	}
	
}
