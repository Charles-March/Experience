package engine;

import javax.swing.JOptionPane;

import types.Map;
import display.MainWindow;

public class Launcher {
	public static int HeigthCase=4;
	public static int WidthCase=4;
	public static Map map;
	public static MainWindow display;
	public static int DispositionChoice=0;
	
	public static void main(String[] args) {
		start(0);
	}
	
	public static void start(int time){
		display = new MainWindow("Experience", 1366, 768);
		map = new Map(1000, 1000);
		
		if(time==0) JOptionPane.showMessageDialog(display, "Bonjour, veuillez choisir une disposition");
		else JOptionPane.showMessageDialog(display, "Veuillez choisir une disposition");
		
		display.ChoixDisposition();
		
		//Dispositions.dispose();
		
		/*display.Jeu();
		display.paint();
		*/
	}

}
