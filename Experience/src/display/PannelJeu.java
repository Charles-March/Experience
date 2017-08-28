package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import types.Map;
import types.Objet;
import types.Point;
import types.Trajet;
import engine.Launcher;

@SuppressWarnings("serial")
public class PannelJeu extends JPanel{
	boolean writing=false;
	boolean customising=false;
	int whichObject=1;
	Point lastposition;
	Trajet currentTrajet;
	
	public PannelJeu(){
		super();
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(writing){
					writing=false;
					System.out.println("writing stoped !");
					if(currentTrajet.isvalid()){
						System.out.println("And Traject is valid ! :O");
						Launcher.listeTrajet.add(currentTrajet);
						Launcher.listeTimer.add(Launcher.display.pannelinf.getChrono());
						currentTrajet.PutOnMap();
						currentTrajet.setDone();
						repaint();
					}
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(customising && whichObject>=7){
					customising=false;
					whichObject=1;
				}
				if((e.getPoint().x < Launcher.map.width*Launcher.WidthCase && e.getPoint().y < Launcher.map.heigth*Launcher.HeigthCase) && customising==false){
					writing=true;
					lastposition = new Point(e.getPoint().x/Launcher.WidthCase,e.getPoint().y/Launcher.HeigthCase);
					currentTrajet = new Trajet();
					currentTrajet.add(lastposition);
					System.out.println("Writting !");
				}
				else {
					writing=false;
			//		clearTemp();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {	
				if(customising){
					Point mousePosition = new Point(e.getPoint().x/Launcher.WidthCase, e.getPoint().y/Launcher.HeigthCase);
					if(whichObject> 0 && whichObject<4){
						if(Launcher.map.canPutMaison(mousePosition)){
							Launcher.map.putMaison(whichObject, mousePosition);
							whichObject++;
							repaint();
						}
					}
					else if(whichObject>3 && whichObject < 7){
						if(Launcher.map.canPutService(mousePosition)){
							Launcher.map.putService(whichObject, mousePosition);
							whichObject++;
							repaint();
						}
					}
					else{
						customising=false;
						whichObject=1;
					}
				}
			}
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {					
				}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(customising && whichObject>=7){
					
					customising=false;
					whichObject=1;
				}
				if(writing==true){
					if(e.getPoint().x > Launcher.map.width*Launcher.WidthCase && e.getPoint().y > Launcher.map.heigth*Launcher.HeigthCase){
						writing = false;
						//clearTemp();
					}
					else{
						Point mousePosition = new Point(e.getPoint().x/Launcher.WidthCase, e.getPoint().y/Launcher.HeigthCase);
						if(mousePosition.isDifferent(lastposition)){
							if(!currentTrajet.addNears(mousePosition)){
						//		clearTemp();
								writing=false;
							}
							else{
						//		paint_temp(getGraphics());
							}
						}
					}
				}
				
			}
		});
		
		
		
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
					//System.out.println("I print a Link");
					g.fillRect((i*Launcher.WidthCase),(j*Launcher.HeigthCase),Launcher.WidthCase,Launcher.WidthCase);
				}
				else if(obj.isMaison() && !obj.isShadow()){
					g.setColor(new Color(255,0,0));
					///System.out.println("I print a house");
					g.fillOval((i*Launcher.WidthCase),(j*Launcher.HeigthCase),Launcher.WidthCase*Map.MaisonSize,Launcher.WidthCase*Map.MaisonSize);
				}
				else if(obj.isService()&& !obj.isShadow()){
					g.setColor(new Color(0,0,255));
					//System.out.println("I print a service");
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
