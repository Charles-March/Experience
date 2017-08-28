package display;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import types.Map;
import types.Objet;
import types.Point;
import types.Trajet;
import engine.Launcher;

@SuppressWarnings("serial")
public class LecturePannelJeu extends JPanel{
	boolean writing=false;
	boolean customising=false;
	int whichObject=1;
	Point lastposition;
	Trajet currentTrajet;
	
	public LecturePannelJeu(){
		super();
		
	}
	
	public void ChangeSize(int x){
		setLocation(x, getHeight());
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		setOpaque(true);
		for(int i=0;i<Launcher.map.width;i++){
			for(int j=0;j<Launcher.map.heigth;j++){
				
				Objet obj=Launcher.map.get(i,j);
				if(obj.isLink()){
					g.setColor(new Color(0,0,0));
					System.out.println("I print a Link");
					g.fillRect((i*Launcher.WidthCase),(j*Launcher.HeigthCase),Launcher.WidthCase,Launcher.WidthCase);
				}
				else if(obj.isMaison() && !obj.isShadow()){
					g.setColor(new Color(255,0,0));
					System.out.println("I print a house");
					g.fillOval((i*Launcher.WidthCase),(j*Launcher.HeigthCase),Launcher.WidthCase*Map.MaisonSize,Launcher.WidthCase*Map.MaisonSize);
				}
				else if(obj.isService()&& !obj.isShadow()){
					g.setColor(new Color(0,0,255));
					System.out.println("I print a service");
					g.fillOval((i*Launcher.WidthCase),(j*Launcher.HeigthCase),Launcher.WidthCase*Map.ServiceSize,Launcher.WidthCase*Map.ServiceSize);;
				}
				
				

				/* AFFICHAGE GRILLE
				g.setColor(new Color(0,0,0));
				g.drawRect(i*Launcher.WidthCase, j*Launcher.HeigthCase, Launcher.WidthCase, Launcher.HeigthCase);
				*/
			}
		}
	}
	
}
