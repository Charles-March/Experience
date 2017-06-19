package types;

import javax.swing.JOptionPane;

import engine.Launcher;

public class Map {
	public int heigth;
	public int width;
	public Objet[][] content;
	public boolean[][] done;
	
	public static int MaisonSize = 6;
	public static int ServiceSize = 6;
	
	public boolean putMaison(int s, Point position){
		if(position.x > 0 && position.x <width-MaisonSize){
			if(position.y > 0 && position.y<heigth-MaisonSize){
				for(int i=position.x;i<position.x+MaisonSize;i++){
					for(int j=position.y;j<position.y+MaisonSize;j++){
						content[i][j].setid(s);
						content[i][j].setShadow(true);
					}
				}
				content[position.x][position.y].setShadow(false);
			}
			else{
				JOptionPane.showMessageDialog(Launcher.display, "Veuillez choisir un position à l'intérieur de l'écran");
				return false;
			}
		}
		else{
			JOptionPane.showMessageDialog(Launcher.display, "Veuillez choisir un position à l'intérieur de l'écran");
			return false;
		}
	System.out.println("Maison mise !");
	return true;
	}
	
	public void putLink(Point position){
		if(position.x >0 && position.x<width && position.y>0 && position.y<heigth){
			content[position.x][position.y].setid(7);
		}
	}
	
	public boolean putService(int s, Point position){
		if(position.x > 0 && position.x <width-ServiceSize){
			if(position.y > 0 && position.y<heigth-ServiceSize){
				for(int i=position.x;i<position.x+ServiceSize;i++){
					for(int j=position.y;j<position.y+ServiceSize;j++){
						content[i][j].setid(s);
						content[i][j].setShadow(true);
					}
				}
				content[position.x][position.y].setShadow(false);
			}
			else{
				System.out.println("out : "+position.x+" "+position.y);
				JOptionPane.showMessageDialog(Launcher.display, "Veuillez choisir un position à l'intérieur de l'écran");
				return false;
			}
		}
		else{
			System.out.println("out : "+position.x+" "+position.y);
			JOptionPane.showMessageDialog(Launcher.display, "Veuillez choisir un position à l'intérieur de l'écran");
			return false;
		}
		System.out.println("Service mis !");	
	return true;
	}
	
	public boolean canPutMaison(Point p){
		if(p.x > 0 && p.x+MaisonSize<width && p.y>0 && p.y+MaisonSize<heigth){
			for(int i=p.x;i<p.x+MaisonSize;i++){
				for(int j=p.y;j<p.y+MaisonSize;j++){
					if(content[i][j].isObject()){
						return false;
					}
				}
			}
			return true;
		}
		else return false;
	}
	
	public boolean canPutService(Point p){
		if(p.x > 0 && p.x+ServiceSize<width && p.y>0 && p.y+ServiceSize<heigth){
			for(int i=p.x;i<p.x+ServiceSize;i++){
				for(int j=p.y;j<p.y+ServiceSize;j++){
					if(content[i][j].isObject()){
						return false;
					}
				}
			}	
			return true;
		}
		else return false;
	}
	
	
	public boolean isDone(int mais, int serv){
		if(mais>0 && mais<4 && serv>3 && serv<7){
			serv-=4;
			mais-=1;
			return done[mais][serv];
		}
		return false;
	}
	
	public void setDone(int mais,int serv){
		if(mais>0 && mais<4 && serv>3 && serv<7){
			serv-=4;
			mais-=1;
			done[mais][serv]=true;
		}
		else System.out.println("probleme avec DONE");
	}
	
	public Map(int SizeX, int SizeY){
		content = new Objet[SizeX][SizeY];
		done = new boolean[3][3];
		heigth = SizeY;
		width = SizeX;
		
		for(int i=0;i<SizeX;i++){
			for(int j=0;j<SizeY;j++){
				content[i][j]= new Objet();
			}
		}
	}

	public Objet get(int x, int y) {
		return content[x][y];
	}
	
	public Objet get(Point p){
		return content[p.x][p.y];
	}
	
	public boolean isIn(Point p){
		return (p.x>=0 && p.x<width && p.y>=0 &&p.y<heigth);
	}
}
