package display;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Frame_Regles extends JFrame{
	
	public Frame_Regles(){
		super("Régles du jeu");
		setLocationRelativeTo(null);
		setLocationByPlatform(true);
		setAlwaysOnTop(true);
		JPanel jp= new JPanel();
		JTextArea label = new JTextArea("<p>Vous disposez de trois jetons rouges et de trois jetons bleus pour ce jeu. Vous pouvez positionner les jetons comme vous le souhaitez en d&eacute;but de partie. Le but du jeu est de relier chaque jeton rouge aux trois jetons bleus.&nbsp;Mais vous ne pouvez pas croisez les lignes ni relier deux jetons de m&ecirc;me couleurs entre eux.</p><p>Le bouton recommencer vous permet de lancer&nbsp;une nouvelle page vierge. Le bouton Arr&ecirc;ter vous permet d'arr&ecirc;ter le jeu &agrave; tout moment.</p>");
		
		jp.add(label);
		add(jp);
		jp.setVisible(true);
		label.setVisible(true);
		pack();
		this.setVisible(true);
	}

}
