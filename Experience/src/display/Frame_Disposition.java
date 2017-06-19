package display;

import java.awt.Dimension;

import javax.swing.JFrame;


public class Frame_Disposition extends JFrame{
	public static int dispImageX=340;
	public static int dispImageY=245;
	private static final long serialVersionUID = 1L;
	
	PanneauDisposition jp;
	public Frame_Disposition(String title){
		super(title);
		setSize(dispImageX*2+100, dispImageY*3+100);
		setLocationRelativeTo(null);
		//setLayout(new BorderLayout());
		
		jp = new PanneauDisposition();
		add(jp);
		jp.setMinimumSize(new Dimension(dispImageX*2+4, dispImageY*3+4));

		addWindowListener(new MainWindowsEvent());
		
		pack();
		setEnabled(true);
		setVisible(true);
	}
	
}
