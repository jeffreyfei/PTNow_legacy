import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class RightPanel extends JPanel {
    
    JLabel txt1;
    JLabel txt2;
    JLabel txt3;
    JLabel txt4;
    JLabel txt5;
    JLabel txt6;
    JLabel txt7;
    JLabel txt8;
    //c for class
    JLabel txt1c;
    JLabel txt2c;
    JLabel txt3c;
    JLabel txt4c;
    JLabel txt5c;
    JLabel txt6c;
    JLabel txt7c;
    JLabel txt8c;
    
    int fontSize = 25;
    String fontType = "Arial";
    
    public RightPanel() throws IOException {
        Dimension size = getPreferredSize();
        size.width = 400;
        size.height = 220;
        setPreferredSize(size);
        //Labels for displaying the schedule
        txt1 = new JLabel();
        txt2 = new JLabel();
        txt3 = new JLabel();
        txt4 = new JLabel();
        txt5 = new JLabel();
        txt6 = new JLabel();
        txt7 = new JLabel();
        txt8 = new JLabel();
        txt1c = new JLabel();
        txt2c = new JLabel();
        txt3c = new JLabel();
        txt4c = new JLabel();
        txt5c = new JLabel();
        txt6c = new JLabel();
        txt7c = new JLabel();
        txt8c = new JLabel();
        
        
        txt1.setText("Block 1");
        txt2.setText("Block 2");
        txt3.setText("Break");
        txt4.setText("Block 3");
        txt5.setText("Block 4");
        txt6.setText("Lunch");
        txt7.setText("Block 5");
        txt8.setText("");
        txt1c.setText("");
        txt2c.setText("");
        txt3c.setText("");
        txt4c.setText("");
        txt5c.setText("");
        txt6c.setText("");
        txt7c.setText("");
        txt8c.setText("");
        
        
        
        //fonts
        txt1.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt2.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt3.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt4.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt5.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt6.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt7.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt8.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt1c.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt2c.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt3c.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt4c.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt5c.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt6c.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt7c.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt8c.setFont(new Font(fontType, Font.BOLD, fontSize));
        
        
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        GridLayout gl = new GridLayout(8, 40, 0, 0);
        
        this.setLayout(gl);
        
        this.add(txt1);
        this.add(txt1c);
        this.add(txt2);
        this.add(txt2c);
        this.add(txt3);
        this.add(txt3c);
        this.add(txt4);
        this.add(txt4c);
        this.add(txt5);
        this.add(txt5c);
        this.add(txt6);
        this.add(txt6c);
        this.add(txt7);
        this.add(txt7c);
		
        /*
        ///////////////Layout Setups//////////////////////
        setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.VERTICAL;
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.ipady = 0;
        
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 0;    
        add(txt1, gc);
        
        gc.weightx = 0;
        gc.gridx = 1;
        gc.gridy = 0;
        add(txt1c, gc);
        
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 2;
        add(txt2, gc);
        
        gc.weightx = 0;
        gc.gridx = 1;
        gc.gridy = 2;
        add(txt2c, gc);
        
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 4;
        add(txt3, gc);
        
        gc.weightx = 0;
        gc.gridx = 1;
        gc.gridy = 4;
        add(txt3c, gc);
        
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 6;
        add(txt4, gc);
        
        gc.weightx = 0;
        gc.gridx = 1;
        gc.gridy = 6;
        add(txt4c, gc);
        
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 8;
        add(txt5, gc);
        
        gc.weightx = 0;
        gc.gridx = 1;
        gc.gridy = 8;
        add(txt5c, gc); 
        
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 10;        
        add(txt6, gc);
        
        gc.weightx = 0;
        gc.gridx = 1;
        gc.gridy = 10;
        add(txt6c, gc);
        
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 12;        
        add(txt7, gc);
        
        gc.weightx = 0;
        gc.gridx = 1;
        gc.gridy = 12;
        add(txt7c, gc);
        
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 14;
        add(txt8, gc);

        gc.weightx = 0;
        gc.gridx = 1;
        gc.gridy = 14;
        add(txt8c, gc);*/
    }
    
    //Method for updating the schedule
    public void updateSchedule() throws IOException {
        Time t = new Time();
        BlockRotation br = new BlockRotation();
        int dayOfWeek = t.getDayOfWeek();
        txt2.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt3.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt5.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt6.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt7.setFont(new Font(fontType, Font.BOLD, fontSize));
        txt8.setFont(new Font(fontType, Font.BOLD, fontSize));
        //this updates the schedule of different days of the week
        if(dayOfWeek != 4 && dayOfWeek != 1 && dayOfWeek != 7 && br.ifHasSchool()) {
            txt1.setText("8:00 - 9:19 ");
            txt1c.setText(br.getTableLine(dayOfWeek, 1));
            
            txt2.setText("9:24 - 10:43 ");
            txt2c.setText(br.getTableLine(dayOfWeek, 2));
            
            txt3.setText("10:48 - 12:07 ");
            txt3c.setText(br.getTableLine(dayOfWeek, 3));
            
            txt4.setText("12:07 - 12:47 ");
            txt4c.setText("Lunch");
            
            txt5.setText("12:47 - 2:06 ");
            txt5c.setText(br.getTableLine(dayOfWeek, 4));
            
            txt6.setText("2:11 - 3:30 ");
            txt6c.setText(br.getTableLine(dayOfWeek, 5));
            
            txt7.setText("");
            txt8.setText("");
        }
        if(dayOfWeek == 4 && br.ifHasSchool()) {
            txt1.setText("8:00 - 9:14 ");
            txt1c.setText(br.getTableLine(dayOfWeek, 1));
            
            txt2.setText("9:19 - 10:33");
            txt2c.setText(br.getTableLine(dayOfWeek, 2));
            
            txt3.setText("10:38 - 11:52");
            txt3c.setText(br.getTableLine(dayOfWeek, 3));
            
            txt4.setText("11:57 - 12:22");
            txt4c.setText("Pack");
            
            txt5.setText("12:22 - 1:02");
            txt5c.setText("Lunch");
            
            txt6.setText("1:02 - 2:16");
            txt6c.setText(br.getTableLine(dayOfWeek, 4));
            
            txt7.setText("2:21 - 3:35");
            txt7c.setText(br.getTableLine(dayOfWeek, 5));
            
            txt8.setText("");
        }
        if(dayOfWeek == 7 || dayOfWeek == 1) {
            txt1.setText("No School Today!");
            txt2.setText("Have a nice weekend!");
            txt3.setText("");
            txt4.setText("");
            txt5.setText("");
            txt6.setText("");
            txt7.setText("");
            txt8.setText("");
            
            txt1c.setText("");
            txt2c.setText("");
            txt3c.setText("");
            txt4c.setText("");
            txt5c.setText("");
            txt6c.setText("");
            txt7c.setText("");
            txt8c.setText("");
            
        }
        if(!br.ifHasSchool()) {
            txt1.setText("No School Today!");
            txt2.setText("Have a nice Holiday!");
            txt3.setText("");
            txt4.setText("");
            txt5.setText("");
            txt6.setText("");
            txt7.setText("");
            txt8.setText("");
            
            txt1c.setText("");
            txt2c.setText("");
            txt3c.setText("");
            txt4c.setText("");
            txt5c.setText("");
            txt6c.setText("");
            txt7c.setText("");
            txt8c.setText("");
        }
        //this highlights the current block
        if(dayOfWeek == 4) {
            switch(br.getCurrentRow()) {
                case 1:
                    txt1.setForeground(Color.blue);
                    txt1c.setForeground(Color.blue);
                    txt2.setForeground(Color.darkGray);
                    txt2c.setForeground(Color.darkGray);
                    txt3.setForeground(Color.darkGray);
                    txt3c.setForeground(Color.darkGray);
                    txt4.setForeground(Color.darkGray);
                    txt4c.setForeground(Color.darkGray);
                    txt5.setForeground(Color.darkGray);
                    txt5c.setForeground(Color.darkGray);
                    txt6.setForeground(Color.darkGray);
                    txt6c.setForeground(Color.darkGray);
                    txt7.setForeground(Color.darkGray);
                    txt7c.setForeground(Color.darkGray);
                    txt8.setForeground(Color.darkGray);
                    txt8c.setForeground(Color.darkGray);
                    break;
                case 2:
                    txt1.setForeground(Color.darkGray);
                    txt1c.setForeground(Color.darkGray);
                    txt2.setForeground(Color.blue);
                    txt2c.setForeground(Color.blue);
                    txt3.setForeground(Color.darkGray);
                    txt3c.setForeground(Color.darkGray);
                    txt4.setForeground(Color.darkGray);
                    txt4c.setForeground(Color.darkGray);
                    txt5.setForeground(Color.darkGray);
                    txt5c.setForeground(Color.darkGray);
                    txt6.setForeground(Color.darkGray);
                    txt6c.setForeground(Color.darkGray);
                    txt7.setForeground(Color.darkGray);
                    txt7c.setForeground(Color.darkGray);
                    txt8.setForeground(Color.darkGray);
                    txt8c.setForeground(Color.darkGray);
                    break;
                case 3:
                	txt1.setForeground(Color.darkGray);
                    txt1c.setForeground(Color.darkGray);
                    txt2.setForeground(Color.darkGray);
                    txt2c.setForeground(Color.darkGray);
                    txt3.setForeground(Color.blue);
                    txt3c.setForeground(Color.blue);
                    txt4.setForeground(Color.darkGray);
                    txt4c.setForeground(Color.darkGray);
                    txt5.setForeground(Color.darkGray);
                    txt5c.setForeground(Color.darkGray);
                    txt6.setForeground(Color.darkGray);
                    txt6c.setForeground(Color.darkGray);
                    txt7.setForeground(Color.darkGray);
                    txt7c.setForeground(Color.darkGray);
                    txt8.setForeground(Color.darkGray);
                    txt8c.setForeground(Color.darkGray);
                    break;
                case 4:
                	txt1.setForeground(Color.darkGray);
                    txt1c.setForeground(Color.darkGray);
                    txt2.setForeground(Color.darkGray);
                    txt2c.setForeground(Color.darkGray);
                    txt3.setForeground(Color.darkGray);
                    txt3c.setForeground(Color.darkGray);
                    txt4.setForeground(Color.blue);
                    txt4c.setForeground(Color.blue);
                    txt5.setForeground(Color.darkGray);
                    txt5c.setForeground(Color.darkGray);
                    txt6.setForeground(Color.darkGray);
                    txt6c.setForeground(Color.darkGray);
                    txt7.setForeground(Color.darkGray);
                    txt7c.setForeground(Color.darkGray);
                    txt8.setForeground(Color.darkGray);
                    txt8c.setForeground(Color.darkGray);
                    break;
                case 5:
                	txt1.setForeground(Color.darkGray);
                    txt1c.setForeground(Color.darkGray);
                    txt2.setForeground(Color.darkGray);
                    txt2c.setForeground(Color.darkGray);
                    txt3.setForeground(Color.darkGray);
                    txt3c.setForeground(Color.darkGray);
                    txt4.setForeground(Color.darkGray);
                    txt4c.setForeground(Color.darkGray);
                    txt5.setForeground(Color.blue);
                    txt5c.setForeground(Color.blue);
                    txt6.setForeground(Color.darkGray);
                    txt6c.setForeground(Color.darkGray);
                    txt7.setForeground(Color.darkGray);
                    txt7c.setForeground(Color.darkGray);
                    txt8.setForeground(Color.darkGray);
                    txt8c.setForeground(Color.darkGray);
                    break;
                case 6:
                	txt1.setForeground(Color.darkGray);
                    txt1c.setForeground(Color.darkGray);
                    txt2.setForeground(Color.darkGray);
                    txt2c.setForeground(Color.darkGray);
                    txt3.setForeground(Color.darkGray);
                    txt3c.setForeground(Color.darkGray);
                    txt4.setForeground(Color.darkGray);
                    txt4c.setForeground(Color.darkGray);
                    txt5.setForeground(Color.darkGray);
                    txt5c.setForeground(Color.darkGray);
                    txt6.setForeground(Color.blue);
                    txt6c.setForeground(Color.blue);
                    txt7.setForeground(Color.darkGray);
                    txt7c.setForeground(Color.darkGray);
                    txt8.setForeground(Color.darkGray);
                    txt8c.setForeground(Color.darkGray);
                    break;
                case 7:
                	txt1.setForeground(Color.darkGray);
                    txt1c.setForeground(Color.darkGray);
                    txt2.setForeground(Color.darkGray);
                    txt2c.setForeground(Color.darkGray);
                    txt3.setForeground(Color.darkGray);
                    txt3c.setForeground(Color.darkGray);
                    txt4.setForeground(Color.darkGray);
                    txt4c.setForeground(Color.darkGray);
                    txt5.setForeground(Color.darkGray);
                    txt5c.setForeground(Color.darkGray);
                    txt6.setForeground(Color.darkGray);
                    txt6c.setForeground(Color.darkGray);
                    txt7.setForeground(Color.blue);
                    txt7c.setForeground(Color.blue);
                    txt8.setForeground(Color.darkGray);
                    txt8c.setForeground(Color.darkGray);
                    break;
                case 8:
                	txt1.setForeground(Color.darkGray);
                    txt1c.setForeground(Color.darkGray);
                    txt2.setForeground(Color.darkGray);
                    txt2c.setForeground(Color.darkGray);
                    txt3.setForeground(Color.darkGray);
                    txt3c.setForeground(Color.darkGray);
                    txt4.setForeground(Color.darkGray);
                    txt4c.setForeground(Color.darkGray);
                    txt5.setForeground(Color.darkGray);
                    txt5c.setForeground(Color.darkGray);
                    txt6.setForeground(Color.darkGray);
                    txt6c.setForeground(Color.darkGray);
                    txt7.setForeground(Color.darkGray);
                    txt7c.setForeground(Color.darkGray);
                    txt8.setForeground(Color.blue);
                    txt8c.setForeground(Color.blue);
                    break;
                default:
                	txt1.setForeground(Color.darkGray);
                    txt1c.setForeground(Color.darkGray);
                    txt2.setForeground(Color.darkGray);
                    txt2c.setForeground(Color.darkGray);
                    txt3.setForeground(Color.darkGray);
                    txt3c.setForeground(Color.darkGray);
                    txt4.setForeground(Color.darkGray);
                    txt4c.setForeground(Color.darkGray);
                    txt5.setForeground(Color.darkGray);
                    txt5c.setForeground(Color.darkGray);
                    txt6.setForeground(Color.darkGray);
                    txt6c.setForeground(Color.darkGray);
                    txt7.setForeground(Color.darkGray);
                    txt7c.setForeground(Color.darkGray);
                    txt8.setForeground(Color.darkGray);
                    txt8c.setForeground(Color.darkGray);
    
            }
        }else{
            switch(br.getCurrentRow()) {
	            case 1:
	                txt1.setForeground(Color.blue);
	                txt1c.setForeground(Color.blue);
	                txt2.setForeground(Color.darkGray);
	                txt2c.setForeground(Color.darkGray);
	                txt3.setForeground(Color.darkGray);
	                txt3c.setForeground(Color.darkGray);
	                txt4.setForeground(Color.darkGray);
	                txt4c.setForeground(Color.darkGray);
	                txt5.setForeground(Color.darkGray);
	                txt5c.setForeground(Color.darkGray);
	                txt6.setForeground(Color.darkGray);
	                txt6c.setForeground(Color.darkGray);
	                txt7.setForeground(Color.darkGray);
	                txt7c.setForeground(Color.darkGray);
	                txt8.setForeground(Color.darkGray);
	                txt8c.setForeground(Color.darkGray);
	                break;
	            case 2:
	                txt1.setForeground(Color.darkGray);
	                txt1c.setForeground(Color.darkGray);
	                txt2.setForeground(Color.blue);
	                txt2c.setForeground(Color.blue);
	                txt3.setForeground(Color.darkGray);
	                txt3c.setForeground(Color.darkGray);
	                txt4.setForeground(Color.darkGray);
	                txt4c.setForeground(Color.darkGray);
	                txt5.setForeground(Color.darkGray);
	                txt5c.setForeground(Color.darkGray);
	                txt6.setForeground(Color.darkGray);
	                txt6c.setForeground(Color.darkGray);
	                txt7.setForeground(Color.darkGray);
	                txt7c.setForeground(Color.darkGray);
	                txt8.setForeground(Color.darkGray);
	                txt8c.setForeground(Color.darkGray);
	                break;
	            case 3:
	            	txt1.setForeground(Color.darkGray);
	                txt1c.setForeground(Color.darkGray);
	                txt2.setForeground(Color.darkGray);
	                txt2c.setForeground(Color.darkGray);
	                txt3.setForeground(Color.blue);
	                txt3c.setForeground(Color.blue);
	                txt4.setForeground(Color.darkGray);
	                txt4c.setForeground(Color.darkGray);
	                txt5.setForeground(Color.darkGray);
	                txt5c.setForeground(Color.darkGray);
	                txt6.setForeground(Color.darkGray);
	                txt6c.setForeground(Color.darkGray);
	                txt7.setForeground(Color.darkGray);
	                txt7c.setForeground(Color.darkGray);
	                txt8.setForeground(Color.darkGray);
	                txt8c.setForeground(Color.darkGray);
	                break;
	            case 4:
	            	txt1.setForeground(Color.darkGray);
	                txt1c.setForeground(Color.darkGray);
	                txt2.setForeground(Color.darkGray);
	                txt2c.setForeground(Color.darkGray);
	                txt3.setForeground(Color.darkGray);
	                txt3c.setForeground(Color.darkGray);
	                txt4.setForeground(Color.blue);
	                txt4c.setForeground(Color.blue);
	                txt5.setForeground(Color.darkGray);
	                txt5c.setForeground(Color.darkGray);
	                txt6.setForeground(Color.darkGray);
	                txt6c.setForeground(Color.darkGray);
	                txt7.setForeground(Color.darkGray);
	                txt7c.setForeground(Color.darkGray);
	                txt8.setForeground(Color.darkGray);
	                txt8c.setForeground(Color.darkGray);
	                break;
	            case 5:
	            	txt1.setForeground(Color.darkGray);
	                txt1c.setForeground(Color.darkGray);
	                txt2.setForeground(Color.darkGray);
	                txt2c.setForeground(Color.darkGray);
	                txt3.setForeground(Color.darkGray);
	                txt3c.setForeground(Color.darkGray);
	                txt4.setForeground(Color.darkGray);
	                txt4c.setForeground(Color.darkGray);
	                txt5.setForeground(Color.blue);
	                txt5c.setForeground(Color.blue);
	                txt6.setForeground(Color.darkGray);
	                txt6c.setForeground(Color.darkGray);
	                txt7.setForeground(Color.darkGray);
	                txt7c.setForeground(Color.darkGray);
	                txt8.setForeground(Color.darkGray);
	                txt8c.setForeground(Color.darkGray);
	                break;
	            case 6:
	            	txt1.setForeground(Color.darkGray);
	                txt1c.setForeground(Color.darkGray);
	                txt2.setForeground(Color.darkGray);
	                txt2c.setForeground(Color.darkGray);
	                txt3.setForeground(Color.darkGray);
	                txt3c.setForeground(Color.darkGray);
	                txt4.setForeground(Color.darkGray);
	                txt4c.setForeground(Color.darkGray);
	                txt5.setForeground(Color.darkGray);
	                txt5c.setForeground(Color.darkGray);
	                txt6.setForeground(Color.blue);
	                txt6c.setForeground(Color.blue);
	                txt7.setForeground(Color.darkGray);
	                txt7c.setForeground(Color.darkGray);
	                txt8.setForeground(Color.darkGray);
	                txt8c.setForeground(Color.darkGray);
	                break;
	            case 7:
	            	txt1.setForeground(Color.darkGray);
	                txt1c.setForeground(Color.darkGray);
	                txt2.setForeground(Color.darkGray);
	                txt2c.setForeground(Color.darkGray);
	                txt3.setForeground(Color.darkGray);
	                txt3c.setForeground(Color.darkGray);
	                txt4.setForeground(Color.darkGray);
	                txt4c.setForeground(Color.darkGray);
	                txt5.setForeground(Color.darkGray);
	                txt5c.setForeground(Color.darkGray);
	                txt6.setForeground(Color.darkGray);
	                txt6c.setForeground(Color.darkGray);
	                txt7.setForeground(Color.blue);
	                txt7c.setForeground(Color.blue);
	                txt8.setForeground(Color.darkGray);
	                txt8c.setForeground(Color.darkGray);
	                break;
                default:
                	txt1.setForeground(Color.darkGray);
                    txt1c.setForeground(Color.darkGray);
                    txt2.setForeground(Color.darkGray);
                    txt2c.setForeground(Color.darkGray);
                    txt3.setForeground(Color.darkGray);
                    txt3c.setForeground(Color.darkGray);
                    txt4.setForeground(Color.darkGray);
                    txt4c.setForeground(Color.darkGray);
                    txt5.setForeground(Color.darkGray);
                    txt5c.setForeground(Color.darkGray);
                    txt6.setForeground(Color.darkGray);
                    txt6c.setForeground(Color.darkGray);
                    txt7.setForeground(Color.darkGray);
                    txt7c.setForeground(Color.darkGray);
    
            }
        }
    }
    
    public void updateCNBR() throws IOException {
    	BlockRotation br = new BlockRotation();
    	
    	
    	if(br.ifHasSchool() && br.ifHasClass()) {
	    	txt1.setText(" ");
	    	txt2.setText(br.getTimeInterval(br.getCurrentRow()));
	    	txt3.setText(br.getCurrentBlk());
	    	txt4.setText(" ");
	    	txt5.setText(br.getTimeInterval(br.getCurrentRow() + 1));
	    	txt6.setText(br.getNextBlk());
	    	txt7.setText("");
	    	txt8.setText(" ");
	    	
	    	txt2.setFont(new Font(fontType, Font.BOLD, fontSize + 6));
	    	txt2.setForeground(Color.blue);
	    	txt3.setFont(new Font(fontType, Font.BOLD, fontSize + 24));
	    	txt3.setForeground(Color.blue);
	    	txt5.setFont(new Font(fontType, Font.BOLD, fontSize + 6));
	    	txt5.setForeground(Color.darkGray);
	    	txt6.setFont(new Font(fontType, Font.BOLD, fontSize + 24));
	    	txt6.setForeground(Color.darkGray);
	    	
	    	txt1c.setText("");
            txt2c.setText("");
            txt3c.setText("");
            txt4c.setText("");
            txt5c.setText("");
            txt6c.setText("");
            txt7c.setText("");
            txt8c.setText("");
    	} else {
	    	txt1.setText("");
	    	txt2.setText("");
	    	txt3.setText(br.getCurrentBlk());
	    	txt4.setText("");
	    	txt5.setText("");
	    	txt6.setText("");
	    	txt7.setText("");
	    	txt8.setText("");
	    	
	    	txt1c.setText("");
            txt2c.setText("");
            txt3c.setText("");
            txt4c.setText("");
            txt5c.setText("");
            txt6c.setText("");
            txt7c.setText("");
            txt8c.setText("");
	    	
	    	

	    	txt3.setFont(new Font(fontType, Font.BOLD, fontSize + 5));
	    	txt3.setForeground(Color.blue);
	    	
    	}
    } 
    
    public String autoSpacing(String word) {
        String spacing = "";
        for(int i = 27; i >= word.length(); --i) {
            spacing += " ";
        }
        return spacing;
    }
}
