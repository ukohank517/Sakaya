package sakayasystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel{
    JButton lef,rig;
    JLabel paneltitle;
    MainFrame_tyumon mf;
    String str;
    public TopPanel(MainFrame_tyumon m, String s){
    	mf = m;
    	str = s;
    	this.setName("top");
    	this.setLayout(null);
    	this.setSize(400,300);
    	paneltitle = new JLabel("<html><body> 入荷依頼を作成するか、入荷が完了したものをデータベースに"
    			+ "<br />登録するか選んでください。</body></html>");
    	paneltitle.setBounds(15,5,400,40);
    	this.add(paneltitle);
    	lef = new JButton("入荷依頼作成");
    	lef.setBounds(20, 200, 150, 40);
    	lef.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			pc(mf.PanelNames[1]);
    		}
	    });
    	this.add(lef);
    	rig = new JButton("入荷完了");
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
