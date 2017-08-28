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
public class PannelBouton extends JPanel{
	JButton NouvelEssai;
	JButton ChangerDisposition;
	JButton Arreter;
	int height=75;
	int width = 150;
	
	public PannelBouton(){
		NouvelEssai = new JButton("Nouvel Essai");
		ChangerDisposition = new JButton("Changer disposition");
		Arreter = new JButton("Arrêter");

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
				Launcher.savecurrent();
				Launcher.start(2);
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
					Launcher.display.forcequit();
				}
				
			}
		});
		Arreter.setMinimumSize(new Dimension(width, height));
		Arreter.setPreferredSize(new Dimension(width, height));
		Arreter.setMaximumSize(new Dimension(width, height));
		
		NouvelEssai.setMinimumSize(new Dimension(width, height));
		NouvelEssai.setPreferredSize(new Dimension(width, height));
		NouvelEssai.setMaximumSize(new Dimension(width, height));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(NouvelEssai);
		//add(ChangerDisposition);
		add(Arreter);
		
		setVisible(true);
	}
}
