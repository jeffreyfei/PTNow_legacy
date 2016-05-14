import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class MainFrame extends JFrame {
    
    int i = 0;
    boolean alt = true;
    public MainFrame(String title) throws IOException {
        //Layout setups
        super(title);      
        setLayout(new BorderLayout());     
        final RightPanel rightPanel = new RightPanel();
        final CentralPanel cp = new CentralPanel();
        final Container c = getContentPane();
        
        JPanel border = new JPanel();
        border.setBorder(BorderFactory.createTitledBorder("Schedule"));
        border.add(rightPanel);
        
        c.add(cp, BorderLayout.CENTER);
        c.add(border, BorderLayout.EAST);
        ////////////Action Listeners//////////////////////
        //In order to constantly update the clock and schedule
        ActionListener updateClockAction = new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  try {
                	cp.updateTime(); 
                	cp.updateDate();
                	if(i == 10) {
                		alt = !alt;
	                	i = 0;
                	}
                	if(alt) {
                		rightPanel.updateSchedule();
                	} else {
                		rightPanel.updateCNBR();
                	}
                	++i;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
               }
              
              
        };
        Timer t1 = new Timer(1000, updateClockAction);
        t1.start();
        
        
        
        /////////Action listener for exiting back//////////////////
        cp.back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				////////////////////////Welcome Frame/////////////////////////
				final int stFrameWidth = 400;
				final int stFrameHeight = 300;
				JFrame start;
				try {
					start = new StartFrame("Pinetree Clock");
					start.setSize(stFrameWidth, stFrameHeight);
					start.setResizable(false);
					start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					start.setVisible(true);
					start.setLocation(screenSize.width / 2 - stFrameWidth / 2, screenSize.height / 2 - stFrameHeight / 2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				
			}
        	
        });
        
        
       
        
    }
}
