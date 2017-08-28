package display;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import types.Dispositions;
import types.Map;
import engine.Launcher;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
		public Frame_Disposition fd;
		public PannelJeu pannel;
		public JPanel vide;
		public JSplitPane jp1,jp2,left;
		public PannelInformation pannelinf;
		public PannelBouton pannelbout;
		public PopupOutOfTime pot;
		
		public MainWindow(String title,int Sizex, int Sizey){
			super(title);
			setSize(Sizex, Sizey);
			setLocationRelativeTo(null);
			
			jp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			jp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			left= new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			
			jp1.setLeftComponent(left);
			jp1.setRightComponent(jp2);
			
			pannelinf = new PannelInformation();
			pannelbout = new PannelBouton();
			jp2.setTopComponent(pannelinf);
			jp2.setBottomComponent(pannelbout);
			
			left.setTopComponent(new PannelRegles());
			
			jp1.setDividerLocation(0.80f);
			jp1.setResizeWeight(1.0);
			add(jp1);
			
			
			setVisible(true);
			addWindowListener(new MainWindowsEvent());
		}
		
		public void Jeu(){
			pannel = new PannelJeu();
			Dispositions.dispose();
			
			if(Launcher.NbEssai==1){
				ThreadChrono tc;
				tc = new ThreadChrono();
				tc.start();
			}
			left.setBottomComponent(pannel);
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
			left.setBottomComponent(pannel);
			setVisible(true);
			
			
			System.out.println("Menu Ajouté");
			JOptionPane.showMessageDialog(Launcher.display, "Cliquez pour poser dans cet ordre : \n- 3 pions rouges\n- 3 pions bleus");
			
			pannel.customising=true;
			pannel.whichObject=1;
			
			if(Launcher.NbEssai==1){
				ThreadChrono tc;
				tc = new ThreadChrono();
				tc.start();
			}
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

		public void end() {
			pot = new PopupOutOfTime();
		}

		public void forcequit() {
			//JOptionPane.showInputDialog("Pourquoi avoir décidé de quitter le jeu ?");
			new PopupForceQuit();
			//new PopupOutOfTime();
			//System.exit(0);
		}
		
		public void quit(){
			System.exit(0);
		}
}
