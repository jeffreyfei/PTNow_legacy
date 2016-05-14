import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CentralPanel extends JPanel {
	JLabel clock;
	JLabel date;
	JButton back;
	public CentralPanel() throws IOException {
		Time time = new Time();
        clock = new JLabel();
        date = new JLabel();
        back = new JButton();
        Dimension sizeCentral = getPreferredSize();
        sizeCentral.width = 200;
        
        //button setup
        back.setText("i");
        back.setMargin(new java.awt.Insets(2, 2, 2, 2));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.add(back);

        
        //clock text
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenArea = screenSize.width * screenSize.height;
        int clockFont = 100;
        if(screenArea <= 1587200) {
        	if(screenArea <= 480000) {
        		clockFont = (int)(((screenArea * 0.000152587890625) + 30));
        	} else {
        		clockFont = (int)(((screenArea * 0.000152587890625)-20));
        	}
        } else {
            clockFont = (int)(((screenArea * 0.000152587890625)-130));
        }
        clock.setFont(new Font("Arial", Font.BOLD, clockFont));
        clock.setText(time.getTime());
        Color clockColor = new Color(12, 82, 0);
        clock.setForeground(clockColor);
        
        //date text
        date.setText(time.getDate());
        date.setFont(new Font("Arial", Font.BOLD, 35));
        Color dateColor = new Color(12, 82, 0);
        date.setForeground(dateColor);
        
        ///////Layout////////
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
        
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        
        
        
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0;
        gc.gridy = 0;
        add(clock, gc);
        
        gc.weightx = 0.05;
        gc.weighty = 0.05;
        
        gc.gridx = 0;
        gc.gridy = 1;
        add(date, gc);
        
        gc.weightx = 0.3;
        gc.weighty = 0.3;
        
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 0;
        gc.gridy = 3;
        add(buttonPanel, gc);
        
        setBorder(BorderFactory.createTitledBorder("Pinetree Time"));
        
        
        
	}
	
	
	
    public void updateTime() throws IOException {
        Time t = new Time();
        clock.setText(t.getTime(12, "HM"));
    }
    
    public void updateDate() throws IOException {
        Time t = new Time();
        date.setText(t.getDate());
    }
    

}
