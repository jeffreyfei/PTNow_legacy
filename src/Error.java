import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Error extends JFrame {
	public Error(String title) {
		super(title);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(new JLabel("Invalid Input"), gc);
	}
}
