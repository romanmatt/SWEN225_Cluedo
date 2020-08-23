import java.awt.*;
import javax.swing.*;

public abstract class GUI {
  
  public GUI() {
		initialise();
	}
  
  private void initialise(){
    
    //Suggest Button  
    JButton suggest = new JButton("Suggest");
    suggest.addActionListener(new ActionListener(){
	    
    });
    //---------------------------------------------------------------------------------
	  
    //Accuse Button	  
    JButton accuse = new JButton("Accuse");
    accuse.addActionListener(new ActionListener(){
	    
    });
    //---------------------------------------------------------------------------------
	  
    //Quit Button	  
    JButton quit = new JButton("Quit");
    quit.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent event){
		System.exit(0);
	}
    });
    //---------------------------------------------------------------------------------
  }
  
}
