import javax.swing.JFrame;

import View.*;
import Controller.*;
import Model.*;


public class main {

	public static void main(String[] args) {
		
		Geo_Canvas canvas = new Geo_Canvas(1600, 850);
		Geo_UI ui = new Geo_UI(canvas);
		Geo_Model model = new Geo_Model(); 
		
		Geo_Controller controller = new Geo_Controller(ui, model);
		
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.setSize(1600, 900);
		ui.setVisible(true);
		ui.setResizable(false);

	}

}
