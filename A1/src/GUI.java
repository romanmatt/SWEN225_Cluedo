import java.awt.*;
import javax.swing.*;

public abstract class GUI {
  
  public GUI() {
		initialise();
	}
  
  private void initialise(){
    
    //Suggest Button  
    JButton suggest = new JButton("Suggest");
    //---------------------------------------------------------------------------------
	  
    //Accuse Button	  
    JButton accuse = new JButton("Accuse");
    //---------------------------------------------------------------------------------
	  
    //Quit Button	  
    JButton quit = new JButton("Quit");
    //---------------------------------------------------------------------------------
  }
  
}
