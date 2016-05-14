import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class ClockMain {
	
	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable()  {
			public void run()  {
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		

	}

	

}
