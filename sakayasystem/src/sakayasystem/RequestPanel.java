package sakayasystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RequestPanel extends JPanel{
    JButton lef,rig;
    JLabel paneltitle;
    JLabel panename,panenum;
    JTextField textname,textnum;
    
    MainFrame_tyumon mf;
    String str;
    public RequestPanel(MainFrame_tyumon m, String s){
    	mf = m;
    	str = s;
    	this.setName("request");
    	this.setLayout(null);
    	this.setSize(400,300);
    	paneltitle = new JLabel("以下の入荷依頼を作成します.");
    	paneltitle.setBounds(15,5,400,40);
    	panename = new JLabel("[酒の銘柄]");
    	panename.setBounds(15, 45, 200, 40);
    	panenum = new JLabel("[酒の本数]");
    	panenum.setBounds(15, 85, 200, 40);
    	this.add(paneltitle);
    	this.add(panename);
    	this.add(panenum);
    	textname = new JTextField(100);
    	textname.setBounds(80, 45, 200, 40);
    	textnum = new JTextField(100);
    	textnum.setBounds(80, 85, 200, 40);
    	this.add(textname);
    	this.add(textnum);
    	
    	
    	lef = new JButton("OK");
    	lef.setBounds(20, 200, 150, 40);
    	lef.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			String a = textnum.getText();
    			if(isNumber(a) && Integer.parseInt(a)>=1) {
    				pc(mf.PanelNames[2]);
    			}
    			else pc(mf.PanelNames[5]);
    		}
	    });
    	this.add(lef);
    	rig = new JButton("cancel");
    	rig.setBounds(220,200,150,40);
    	rig.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			pc(mf.PanelNames[0]);
    		}
	    	});
    	this.add(rig);
        //this.setBackground(Color.getHSBColor(65, 0.7f, 0.9f));
    	}

	
	public void pc(String str){
		String[] useless = {textname.getText(),textnum.getText()};
    	mf.PanelChange((JPanel)this, str, useless);
    }
	
	public boolean isNumber(String num) {
	    try {
	        Integer.parseInt(num);
	        return true;
	        } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
}
