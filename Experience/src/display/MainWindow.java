package display;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import types.Dispositions;
import types.Map;
import engine.Launcher;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
		Frame_Disposition fd;
		PannelJeu pannel;
		public MainWindow(String title,int Sizex, int Sizey){
			super(title);
			setSize(Sizex, Sizey);
			setLocationRelativeTo(null);
			addWindowListener(new MainWindowsEvent());
		}
		
		public void Jeu(){
			/*	  MenuBar 	*/
			MenuBar menuBar = new MenuBar();
			this.setJMenuBar(menuBar);
			menuBar.setVisible(true);	
			
			System.out.println("Menu Ajouté");
			
			pannel = new PannelJeu();
			Dispositions.dispose();
			add(pannel);
			setVisible(true);
		}
		
		public void ChoixDisposition(){
			fd = new Frame_Disposition("choix disposition");
			fd.setLocationRelativeTo(null);
		}
		
		public void TurnDispositionOff(){
			fd.setVisible(false);
			fd.setEnabled(false);
			fd=null;
		}

		public void CustomDisposition(){
			MenuBar menuBar = new MenuBar();
			this.setJMenuBar(menuBar);
			menuBar.setVisible(true);	
			
			pannel = new PannelJeu();
			add(pannel);
			setVisible(true);
			
			
			System.out.println("Menu Ajouté");
			JOptionPane.showMessageDialog(Launcher.display, "Clickez pour poser dans cet ordre : \n- 3 pions rouges\n- 3 pions bleus");
			
			pannel.customising=true;
			pannel.whichObject=1;
		}
		
		public void paint() {
			setVisible(false);
			setVisible(true);
		}
		
		public void reset(){
			setVisible(false);
			int Heigth = Launcher.map.heigth;
			int Width = Launcher.map.width;
			
			Launcher.map=new Map(Width, Heigth);
			
			JOptionPane.showMessageDialog(Launcher.display, "Veuillez choisir une disposition");
			ChoixDisposition();						
		}
}
