package sakayasystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class ShowPanel extends JPanel {
    JButton btn = new JButton("OK");
    JLabel alltitle,paneltitle;
    JLabel panename,panenum;
    JLabel allname, allnum;
    
    MainFrame_tyumon mf;
    String str;
    public ShowPanel(MainFrame_tyumon m,String s, String[] useless, String[] nowstatus){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(400, 300);
        JLabel paneltitle = new JLabel("以下の入荷を完了しました.");
        paneltitle.setBounds(15,5,400,40);
        JLabel alltitle = new JLabel("現在の在庫は以下のようになっています.");
        alltitle.setBounds(15,110,400,40);
    	panename = new JLabel("[酒の銘柄]:"+ useless[0]);
    	panename.setBounds(15, 40, 200, 40);
    	panenum = new JLabel("[酒の本数:]" + useless[1]);
    	panenum.setBounds(15, 75, 200, 40);
    	allname = new JLabel("[酒の銘柄]:"+ nowstatus[0]);
    	allname.setBounds(15, 145, 200, 40);
    	allnum = new JLabel("[酒の本数:]" + nowstatus[1]);
    	allnum.setBounds(15, 180, 200, 40);
    	this.add(paneltitle);
    	this.add(alltitle);
    	this.add(panename);
    	this.add(panenum);
        this.add(allname);
        this.add(allnum);
        paneltitle.setBounds(0, 5, 400, 40);
        this.add(paneltitle);
        btn.setBounds(220, 215, 150, 40);
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