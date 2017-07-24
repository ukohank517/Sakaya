package sakayasystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class ErrPanel extends JPanel {
    JButton btn = new JButton("ok");
    JLabel paneltitle;
    JLabel panename,panenum;
    MainFrame_tyumon mf;
    String str;
    public ErrPanel(MainFrame_tyumon m,String s, String[] useless){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(400, 300);
        JLabel paneltitle = new JLabel("以下の入力は適切ではありません.");
        paneltitle.setBounds(15,5,400,40);
    	panename = new JLabel("[酒の銘柄]:"+ useless[0]);
    	panename.setBounds(15, 45, 200, 40);
    	panenum = new JLabel("[酒の本数:]" + useless[1]);
    	panenum.setBounds(15, 85, 200, 40);
    	this.add(paneltitle);
    	this.add(panename);
    	this.add(panenum);
    	
        btn.setBounds(20, 200, 150, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc();
            }
        });
        this.add(btn);
        //Float f = (float) Math.random();
        //this.setBackground(Color.getHSBColor(f, 0.5f, 0.8f));
    }
    public void pc(){
        mf.PanelChange((JPanel)this, mf.PanelNames[0], null);
    }
}