package gamenseni;

import javax.swing.JPanel;

public class SubSubPanel extends SubPanel {
    public SubSubPanel(MainFrame m,String s){
        super(m,s);
        btn.setText("SubPanel2に移動");
    }
    @Override
    public void pc(){
        mf.PanelChange((JPanel)this, mf.PanelNames[2]);
    }
}