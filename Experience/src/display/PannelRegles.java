package display;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PannelRegles extends JPanel{

	@SuppressWarnings("static-access")
	public PannelRegles() {
		
		JLabel label = new JLabel("<html><p>Vous disposez de trois jetons rouges et de trois jetons bleus pour ce jeu.</p>"
				+ "<p>Vous pouvez positionner les jetons comme vous le souhaitez en début de partie.</p>"
				+ "<p>Le but du jeu est de relier chaque jeton rouge aux trois jetons bleus.</p>"
				+ "<p>Mais vous ne pouvez pas croisez les lignes ni relier deux jetons de même couleur entre eux.</p>"
				+ "<p>Le bouton <strong>Nouvel Essai</strong> vous permet de lancer une nouvelle page vierge. Le bouton <strong>Arrêter</strong></p>"
				+ "<p>vous permet d'arrêter le jeu à tout moment.</p>"
				+ "</html>");
		setFont(label.getFont().deriveFont(label.getFont().PLAIN));
			this.add(label);
			setVisible(true);
	}
}
