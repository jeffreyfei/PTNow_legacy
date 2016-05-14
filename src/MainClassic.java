import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.Timer;



public class MainClassic extends JFrame {
    

    
    public MainClassic(String title) throws IOException {
        //Layout setups
        super(title);
        
        setLayout(new BorderLayout());   
        final CentralPanel cp = new CentralPanel();       
        ////////////Action Listeners//////////////////////
        //In order to constantly update the clock and schedule
        ActionListener updateClockAction = new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  try {
					cp.updateTime();
					 cp.updateDate();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
                 
               }
        };
        Timer t = new Timer(1000, updateClockAction);
        t.start();
        
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
        
        //////Layout///////
        
        Container c = getContentPane();
        
        c.add(cp, BorderLayout.CENTER);
    }
    //method for updating the clock

}
