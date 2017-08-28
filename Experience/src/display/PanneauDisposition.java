package display;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import engine.Launcher;
import engine.OSValidator;

@SuppressWarnings("serial")
public class PanneauDisposition extends JPanel{
	ImageIcon dis1,dis2,dis3,dis4,dis5;
	
	public static int dispImageX=340;
	public static int dispImageY=245;
	JButton b1,b2,b3,b4,b5,bcus;
	
	public PanneauDisposition() {
		System.out.println("créé !");

		setSize(dispImageX*2+4,dispImageY*3+4);
		if(OSValidator.isWindows()){
		dis1 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition0.png").replace('/','\\'));
		dis2 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition1.png").replace('/','\\'));
		dis3 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition2.png").replace('/','\\'));
		dis4 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition3.png").replace('/','\\'));
		dis5 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition4.png").replace('/','\\'));
		}
		else{
			dis1 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition0.png").replace('\\','/'));
			dis2 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition1.png").replace('\\','/'));
			dis3 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition2.png").replace('\\','/'));
			dis4 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition3.png").replace('\\','/'));
			dis5 = new ImageIcon((System.getProperty("user.dir")+"/Ressources/disposition4.png").replace('\\','/'));
	
		}
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
		
		bcus=new JButton("Disposition libre");
		
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

		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(bcus);
		
		int heigth = 250,width = 340;
		bcus.setSize(new Dimension(width,heigth));
		bcus.setMaximumSize(new Dimension(width,heigth));
		bcus.setMinimumSize(new Dimension(width,heigth));
		
		b2.setSize(new Dimension(width,heigth));
		b2.setMaximumSize(new Dimension(width,heigth));
		b2.setMinimumSize(new Dimension(width,heigth));
		
		b3.setSize(new Dimension(width,heigth));
		b3.setMaximumSize(new Dimension(width,heigth));
		b3.setMinimumSize(new Dimension(width,heigth));
		
		b4.setSize(new Dimension(width,heigth));
		b4.setMaximumSize(new Dimension(width,heigth));
		b4.setMinimumSize(new Dimension(width,heigth));
		
		b5.setSize(new Dimension(width,heigth));
		b5.setMaximumSize(new Dimension(width,heigth));
		b5.setMinimumSize(new Dimension(width,heigth));

		
		
		setEnabled(true);
		setVisible(true);
		
			}
}