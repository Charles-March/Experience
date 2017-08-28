package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.Launcher;

@SuppressWarnings("serial")
public class LecturePannelBouton extends JPanel{
	JButton NouvelEssai;
	JButton ChangerDisposition;
	JButton Arreter;
	JButton Back;
	int height=75;
	int width = 150;
	
	public LecturePannelBouton(){
		NouvelEssai = new JButton("Avancer");
		Back = new JButton("Reculer");
		ChangerDisposition = new JButton("Reponses");
		Arreter = new JButton("Quitter");

		NouvelEssai.setBackground(new Color(240,255,240));
		Arreter.setSize(NouvelEssai.getWidth(),NouvelEssai.getHeight());
		NouvelEssai.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				LectureEvent.putNextTrajet();
			}
		});
		
		Arreter.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int choice = JOptionPane.showConfirmDialog(Launcher.display, "Êtes-vous sûr de vouloir quitter ?");
				if(choice==0){
					Launcher.displayLecture.quit();
				}
				
			}
		});
		
		Back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				LectureEvent.back();
				Launcher.displayLecture.pannel.repaint();
			}
		});
		
		ChangerDisposition.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				LectureEvent.printRep();
				
			}
		});
		
		Arreter.setMinimumSize(new Dimension(width, height));
		Arreter.setPreferredSize(new Dimension(width, height));
		Arreter.setMaximumSize(new Dimension(width, height));
		
		ChangerDisposition.setMinimumSize(new Dimension(width, height));
		ChangerDisposition.setPreferredSize(new Dimension(width, height));
		ChangerDisposition.setMaximumSize(new Dimension(width, height));
		
		Back.setMinimumSize(new Dimension(width, height));
		Back.setPreferredSize(new Dimension(width, height));
		Back.setMaximumSize(new Dimension(width, height));
		
		
		NouvelEssai.setMinimumSize(new Dimension(width, height));
		NouvelEssai.setPreferredSize(new Dimension(width, height));
		NouvelEssai.setMaximumSize(new Dimension(width, height));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(NouvelEssai);
		add(Back);
		add(ChangerDisposition);
		add(Arreter);
		
		setVisible(true);
	}
}
