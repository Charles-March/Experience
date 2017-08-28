package engine;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import types.Map;
import types.Point;
import types.Reponse;
import types.Trajet;
import display.LectureEvent;
import display.LectureMainWindows;
import display.MainWindow;


public class Launcher {
	public static int HeigthCase=4;
	public static int WidthCase=4;
	public static Map map;
	public static MainWindow display;
	public static int DispositionChoice=0;
	public static LectureMainWindows displayLecture;
	public static JFrame Regles=null;
	public static boolean starting=true;
	public static String code=null;
	public static int NbEssai=0;
	public static List<Trajet> listeTrajet;
	public static List<Integer> listeTimer;
	public static List<List<Integer>> FinalTimer;
	public static List<Point> SaveStart;
	public static List<List<Trajet>> Save;
	public static List<List<Point>> ListeStart;
	public static List<Reponse> Reponses;
	
	public static void main(String[] args) {
		listeTrajet = new LinkedList<Trajet>();
		ListeStart = new LinkedList<List<Point>>();
		SaveStart = new LinkedList<Point>();
		Reponses = new LinkedList<Reponse>();
		listeTimer = new LinkedList<Integer>();
		FinalTimer = new LinkedList<List<Integer>>();
		Save = new LinkedList<List<Trajet>>();
		start(0);
	}
	
	public static void mainRedif(String[] args){ 
		JFileChooser chooser;
		chooser = new JFileChooser();
		chooser.setDialogTitle("Choose load file");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (chooser.showOpenDialog(Launcher.display) == JFileChooser.APPROVE_OPTION) {
			map = new Map(1000, 1000);
			Launcher.SaveStart = new LinkedList<Point>();
			ParserPartie p = new ParserPartie(chooser.getSelectedFile().getPath());
			System.out.println(chooser.getSelectedFile().getPath());
			FinalTimer = p.TimerList;
			ListeStart = p.StartingList;
			Reponses = p.ReponseList;
			Save = p.TrajetList;
			code=p.code;
			if(Launcher.displayLecture!=null){
			Launcher.displayLecture.setEnabled(false);
			Launcher.displayLecture.setVisible(false);
			}
			Launcher.displayLecture = new LectureMainWindows("Lecture :D", 1366, 768);
			//display.pannelinf.majCode();
			LectureEvent.putNextTrajet();
		}
		else{
			System.out.println("WRONG FILE");
		}
		
	}
	
	public static void start(int time){
		Launcher.NbEssai++;
		if(display!=null){
		display.setVisible(false);
		display.setEnabled(false);
		}
		display = new MainWindow("3 Jetons", 1366, 768);
		
		map = new Map(1000, 1000);
		
		if(time==0) {
			code=JOptionPane.showInputDialog("Bonjour, merci d'entrer votre code");
			display.pannelinf.majCode();
			JOptionPane.showMessageDialog(display, "Veuillez choisir une disposition");
		}
		else JOptionPane.showMessageDialog(display, "Veuillez choisir une disposition");
		
		//if(Regles == null) Regles = new Frame_Regles();
		display.ChoixDisposition();
		
		//Dispositions.dispose();
		
		/*display.Jeu();
		display.paint();
		*/
	}

	public static void savecurrent(){
		Launcher.Save.add(Launcher.listeTrajet);
		Launcher.listeTrajet= new LinkedList<Trajet>();
		
		for(int i=0;i<Launcher.listeTimer.size();i++){
			System.out.println("time = "+Launcher.listeTimer.get(i));
		}
		
		Launcher.FinalTimer.add(Launcher.listeTimer);
		Launcher.listeTimer = new LinkedList<Integer>();
		
		Launcher.ListeStart.add(Launcher.SaveStart);
		Launcher.SaveStart = new LinkedList<Point>();
	}
	public static void end() {
		savecurrent();
			try {
				Export.Save();
				System.out.println("Exportation done correctly");
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				System.out.println("some problem");
				e.printStackTrace();
			}
			
			
			
			System.exit(0);
		
	}

}
