package display;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class LectureMainWindows extends JFrame{
	public Frame_Disposition fd;
	public LecturePannelJeu pannel;
	public JPanel vide;
	public JSplitPane jp1,jp2,left;
	public PannelInformation pannelinf;
	public LecturePannelBouton pannelbout;
	
	public LectureMainWindows(String title, int Sizex, int Sizey){
		super(title);
		setSize(Sizex, Sizey);
		setLocationRelativeTo(null);
		
		jp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		jp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		left= new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		jp1.setLeftComponent(left);
		jp1.setRightComponent(jp2);
		
		pannelinf = new PannelInformation();
		pannelbout = new LecturePannelBouton();
		jp2.setTopComponent(pannelinf);
		jp2.setBottomComponent(pannelbout);
		
		left.setTopComponent(new PannelRegles());
		
		jp1.setDividerLocation(0.80f);
		jp1.setResizeWeight(1.0);
		add(jp1);
		
		setJMenuBar(new MenuBar());
		
		setVisible(true);
		Jeu();
		addWindowListener(new MainWindowsEvent());
	}

	public void Jeu(){
		pannel = new LecturePannelJeu();
		//Dispositions.dispose();
		left.setBottomComponent(pannel);
		setVisible(true);
	}

	public void quit() {
		System.exit(0);
		
	}
}
