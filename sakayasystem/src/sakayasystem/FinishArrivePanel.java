package sakayasystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinishArrivePanel extends JPanel{
    JButton lef,rig;
    JLabel paneltitle;
    JLabel panename, panenum;
    MainFrame_tyumon mf;
    String str;
    public FinishArrivePanel(MainFrame_tyumon m, String s, String[] useless){
    	mf = m;
    	str = s;
    	this.setName("finishArrive");
    	this.setLayout(null);
    	this.setSize(400,300);
    	paneltitle = new JLabel("以下の入荷依頼でよろしいでしょうか.");
    	paneltitle.setBounds(15,5,400,40);
    	panename = new JLabel("[酒の銘柄]:"+ useless[0]);
    	panename.setBounds(15, 45, 200, 40);
    	panenum = new JLabel("[酒の本数:]" + useless[1]);
    	panenum.setBounds(15, 85, 200, 40);
    	this.add(paneltitle);
    	this.add(panename);
    	this.add(panenum);
    	
    	lef = new JButton("OK");
    	lef.setBounds(20, 200, 150, 40);
    	lef.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			pc(mf.PanelNames[7]);
    		}
	    });
    	this.add(lef);
    	rig = new JButton("Cancel");
    	rig.setBounds(220,200,150,40);
    	rig.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			pc(mf.PanelNames[4]);
    		}
	    	});
    	this.add(rig);
        //this.setBackground(Color.getHSBColor(65, 0.7f, 0.9f));
    	}

    public void pc(String str){
    	mf.PanelChange((JPanel)this, str, null);
    }
}
