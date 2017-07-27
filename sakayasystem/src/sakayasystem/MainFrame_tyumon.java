package sakayasystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame_tyumon extends JFrame{
	public String[] useless = {"", ""};
	public String[] nowstatus = {"",""};
    public String[] PanelNames = {"top","request","confirm","finishOrder","fin","err","finishArrive","show"};
    
    public static ArrayList<String> zaiko_name = new ArrayList<String>();
	public static ArrayList<String> zaiko_num = new ArrayList<String>();
	
    TopPanel top = new TopPanel(this,PanelNames[0]);
    RequestPanel request = new RequestPanel(this,PanelNames[1]);
    ConfirmPanel confirm = new ConfirmPanel(this,PanelNames[2],useless);
    FinishOrderPanel finishOrder = new FinishOrderPanel(this, PanelNames[3],useless);
    FinPanel fin = new FinPanel(this,PanelNames[4]);
    ErrPanel err = new ErrPanel(this,PanelNames[5],useless);
    FinishArrivePanel finishArrive = new FinishArrivePanel(this,PanelNames[6],useless);
    ShowPanel show = new ShowPanel(this,PanelNames[7], useless, nowstatus);

   
    public MainFrame_tyumon(){
    	this.add(top);top.setVisible(true);
    	this.add(request);request.setVisible(false);
    	this.add(confirm);confirm.setVisible(false);
    	this.add(finishOrder);finishOrder.setVisible(false);
    	this.add(fin);fin.setVisible(false);
    	this.add(err);err.setVisible(false);
    	this.add(finishArrive);finishArrive.setVisible(false);
    	this.add(show);show.setVisible(false);
    	this.setBounds(350,250,400,300);
    }
    

    public static void main(String[] args){
    	//###########ファイルの読み込み&配列に保存######################
    	String a="";
    	try{
    		  File file = new File("src/sakayasystem/zaiko.txt");
    		  FileReader filereader = new FileReader(file);

    		  int ch = filereader.read();
    		  while(ch != -1){
    		    if((char)ch == ','){
    		    	zaiko_name.add(a);
    		    	a="";
    		    }
    		    else if((char)ch == '\n'){
    		    	zaiko_num.add(a);
    		    	a="";
    		    }
    		    else{
        			a+=(char)ch; 
    		    }
    		    ch = filereader.read();
    		    //zaiko.add((char)ch);
    		  }
    		}catch(FileNotFoundException e){
    		  System.out.println(e);
    		}catch(IOException e){
    		  System.out.println(e);
    		}
    	zaiko_num.add(a);
    	// デバック
    	System.out.println("ファイルから読み取ったデータは:");
    	  for(int i = 0, l = zaiko_num.size();i<l; i++){
    		System.out.println(zaiko_name.get(i)+":"+zaiko_num.get(i));
    	}
    	System.out.println("--------------------------");
    	//###############################################################
    	//------------------ファイルへの書き込み-----------------------------
       
    //----------------------------------------------------------------
    	
    	
    	
    	
    	MainFrame_tyumon mf = new MainFrame_tyumon();
    	mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	mf.setVisible(true);
    }
    
    private static boolean checkBeforeWritefile(File file){
        if (file.exists()){
          if (file.isFile() && file.canWrite()){
            return true;
          }
        }

        return false;
      }
    
    public void PanelChange(JPanel jp, String str, String[] usel){
    	System.out.println(jp.getName()+ "->"  + str);
    	String name = jp.getName();
    	if(name == PanelNames[0]){
    		top = (TopPanel)jp;
    		top.setVisible(false);
    	}else if (name == PanelNames[1]){
    		request = (RequestPanel)jp;
    		request.setVisible(false);
    		useless = usel;
    	}else if (name == PanelNames[2]){
    		confirm = (ConfirmPanel)jp;
    		confirm.setVisible(false);
    	}else if (name == PanelNames[3]){
    		finishOrder = (FinishOrderPanel)jp;
    		finishOrder.setVisible(false);
    		useless = null;
    		nowstatus = null;
    	}else if (name == PanelNames[4]){
    		fin = (FinPanel)jp;
    		fin.setVisible(false);
    		useless = usel;
    	}else if (name == PanelNames[5]){
    		err = (ErrPanel)jp;
    		err.setVisible(false);
    		useless = null;
    		nowstatus = null;
    	}else if (name == PanelNames[6]){
    		finishArrive = (FinishArrivePanel)jp;
    		finishArrive.setVisible(false);
    	}else if (name == PanelNames[7]){
    		
    		show = (ShowPanel)jp;
    		show.setVisible(false);
    		//ファイルへの書き込み
    		//**************
    		useless = null;
    		nowstatus = null;
    	}

		if(str == PanelNames[0]){
		    top.setVisible(true);
		}else if(str == PanelNames[1]){
			this.remove(request);
			request = new RequestPanel(this,PanelNames[1]);
			this.add(request);
		    request.setVisible(true);
		}else if(str == PanelNames[2]){
			this.remove(confirm);
			confirm = new ConfirmPanel(this,PanelNames[2],useless);
			this.add(confirm);
		    confirm.setVisible(true);
		}else if(str == PanelNames[3]){
			this.remove(finishOrder);
			finishOrder = new FinishOrderPanel(this, PanelNames[3],useless);
			this.add(finishOrder);
		    finishOrder.setVisible(true);
		}else if(str == PanelNames[4]){
			this.remove(fin);
			fin = new FinPanel(this,PanelNames[4]);
			this.add(fin);
		    fin.setVisible(true);
		}else if(str == PanelNames[5]){
			this.remove(err);
			err = new ErrPanel(this,PanelNames[5],useless);
			this.add(err);
		    err.setVisible(true);
		}else if(str == PanelNames[6]){
			this.remove(finishArrive);
			finishArrive = new FinishArrivePanel(this,PanelNames[6],useless);
			this.add(finishArrive);
		    finishArrive.setVisible(true);
		}else if(str == PanelNames[7]){
		    this.remove(show);
		    check();
		    write_file();
		    show = new ShowPanel(this,PanelNames[7], useless, nowstatus);
		    this.add(show);
			show.setVisible(true);
		}
	
    }
    
    private void write_file(){
    	 try{
             File file = new File("src/sakayasystem/a.txt");

             if (checkBeforeWritefile(file)){
               FileWriter filewriter = new FileWriter(file);

               for(int i = 0, l = zaiko_num.size();i<l;i++){
             	  filewriter.write(zaiko_name.get(i)+","+zaiko_num.get(i)+'\n');
               }
               filewriter.close();
             }else{
               System.out.println("ファイルに書き込めません");
             }
           }catch(IOException e){
             System.out.println(e);
           }
    }


	private void check() {
		
		int i , l;
		
		
		
		System.out.println("更新する前の配列の中身のデータは:");
		for(i = 0, l = zaiko_num.size();i<l; i++){
			System.out.println(zaiko_name.get(i)+":"+zaiko_num.get(i));
		}
		System.out.println("--------------------------");
		
		for(i = 0, l = zaiko_name.size() ; i< l ; i++){

			if(zaiko_name.get(i).equals( useless[0])) {
				int inp=Integer.parseInt(zaiko_num.get(i)) + Integer.parseInt(useless[1]);
				zaiko_num.set(i,String.valueOf(inp));
				nowstatus[0]=zaiko_name.get(i);
				nowstatus[1]=zaiko_num.get(i);
				break;
			}
		}
		if(i==l){
			nowstatus = useless;
			zaiko_name.add(useless[0]);
			zaiko_num.add(useless[1]);
		}
		System.out.println("更新した配列の中身のデータは:");
		for(i = 0, l = zaiko_num.size();i<l; i++){
			System.out.println(zaiko_name.get(i)+":"+zaiko_num.get(i));
		}
		System.out.println("--------------------------");
	}
    
}
