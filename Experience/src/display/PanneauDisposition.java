package display;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Launcher;

@SuppressWarnings("serial")
public class PanneauDisposition extends JPanel{
	ImageIcon dis1,dis2,dis3,dis4,dis5;
	
	public static int dispImageX=340;
	public static int dispImageY=245;
	JButton b1,b2,b3,b4,b5,bcus;
	
	public PanneauDisposition() {
		System.out.println("créé !");

		setSize(dispImageX*2+4,dispImageY*3+4);
		
		setLayout(new BorderLayout());
		
		dis1 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition0.png").replace('/','\\'));
		dis2 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition1.png").replace('/','\\'));
		dis3 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition2.png").replace('/','\\'));
		dis4 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition3.png").replace('/','\\'));
		dis5 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition4.png").replace('/','\\'));
		
		b1=new JButton(dis1);
		
		b1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {	}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Launcher.DispositionChoice=0;
				Launcher.display.Jeu();
				Launcher.display.TurnDispositionOff();
			}
		});
		
		b2=new JButton(dis2);
		
		b2.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {	}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Launcher.DispositionChoice=1;
				Launcher.display.Jeu();
				Launcher.display.TurnDispositionOff();
			}
		});
		
		b3=new JButton(dis3);
		
		b3.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {	}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Launcher.DispositionChoice=2;
				Launcher.display.Jeu();
				Launcher.display.TurnDispositionOff();
			}
		});
		
		b4=new JButton(dis4);
		
		b4.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {	}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Launcher.DispositionChoice=3;
				Launcher.display.Jeu();
				Launcher.display.TurnDispositionOff();
			}
		});
		
		b5=new JButton(dis5);
		
		b5.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {	}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Launcher.DispositionChoice=4;
				Launcher.display.Jeu();
				Launcher.display.TurnDispositionOff();
			}
		});
		
		bcus=new JButton("Disposition custom");
		
		bcus.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {	}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Launcher.DispositionChoice=0;
				Launcher.display.CustomDisposition();
				Launcher.display.TurnDispositionOff();
			}
		});
		
		add(bcus,BorderLayout.PAGE_START);
		//add(b1,BorderLayout.NORTH);
		add(b2,BorderLayout.WEST);
		add(b3,BorderLayout.EAST);
		add(b4,BorderLayout.SOUTH);
		add(b5,BorderLayout.CENTER);
		setEnabled(true);
		setVisible(true);
	}
}