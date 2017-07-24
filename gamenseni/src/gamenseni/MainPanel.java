package gamenseni;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class MainPanel extends JPanel {
    JButton btn,btn2,btn3;
    JLabel paneltitle;
    MainFrame mf;
    String str;
    public MainPanel(MainFrame m,String s){
        mf = m;
        str = s;
        this.setName("mp");
        this.setLayout(null);
        this.setSize(400, 200);
        paneltitle = new JLabel("これは"
                +getClass().getCanonicalName()+"クラスのパネルです");
        paneltitle.setBounds(0, 5, 400, 40);
        this.add(paneltitle);
        btn = new JButton("SubPanelに移動");
        btn.setBounds(20, 50, 150, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[1]);
            }
        });
        this.add(btn);
        btn2 = new JButton("SubPanel2に移動");
        btn2.setBounds(20, 100, 150, 40);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[2]);
            }
        });
        this.add(btn2);
        btn3 = new JButton("SubPanel3に移動");
        btn3.setBounds(200, 100, 150, 40);
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[3]);
            }
        });
        this.add(btn3);
        this.setBackground(Color.getHSBColor(65, 0.7f, 0.9f));
    }
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);
    }
}