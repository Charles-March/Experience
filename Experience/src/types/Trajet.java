package types;

import java.util.LinkedList;
import java.util.List;

import engine.Launcher;

public class Trajet {
	public List<Point> pl;
	
	public Trajet(List<Point> lp){
		pl = lp;
	}
	
	public Trajet(){
		pl = new LinkedList<Point>();
	}
	
	public void add(Point p){
		pl.add(p);
	}
	
	public void PutOnMap(){
		System.out.println("put on map : "+pl.size());
		for(int i=1;i<pl.size()-1;i++){
			Point p = pl.get(i);
			if(!Launcher.map.get(p).isObject())
			{
				//System.out.println("printing on map");
				Launcher.map.putLink(pl.get(i));
			}
		}
	}
	
	public boolean Start_end_check(){
		Point StartingPoint = pl.get(0);
		Point EndingPoint = pl.get(pl.size()-1);
		
		int maisId =Launcher.map.get(StartingPoint).id;
		int servId =Launcher.map.get(EndingPoint).id;
		boolean a = Launcher.map.get(StartingPoint).isMaison() && Launcher.map.get(EndingPoint).isService() && !Launcher.map.isDone(maisId, servId);
		boolean b = Launcher.map.get(StartingPoint).isService() && Launcher.map.get(EndingPoint).isMaison() && !Launcher.map.isDone(servId, maisId);
		
		return (a || b );
	}
	
	public boolean TravelCheck(){
		int i=0;
		if(Launcher.map.get(pl.get(0)).isMaison()){
			while(Launcher.map.get(pl.get(i)).isMaison()) i++;
		
			while(!Launcher.map.get(pl.get(i)).isService()){
				if(Launcher.map.get(pl.get(i)).isObject()){
					return false;
				}
				i++;
			}
		
			for(;i<pl.size();i++){
				if(!Launcher.map.get(pl.get(i)).isService()){
					return false;
				}
			}
		
		return true;
		}
		else{
			while(Launcher.map.get(pl.get(i)).isService()) i++;
			
			while(!Launcher.map.get(pl.get(i)).isMaison()){
				if(Launcher.map.get(pl.get(i)).isObject()){
					return false;
				}
				i++;
			}
		
			for(;i<pl.size();i++){
				if(!Launcher.map.get(pl.get(i)).isMaison()){
					return false;
				}
			}
		
		return true;
		}
	}
	
	public void setDone(){
		Point StartingPoint = pl.get(0);
		Point EndingPoint = pl.get(pl.size()-1);
		
		int maisId =Launcher.map.get(StartingPoint).id;
		int servId =Launcher.map.get(EndingPoint).id;
		
		if(Launcher.map.get(StartingPoint).isMaison()){
			Launcher.map.setDone(maisId, servId);
		}
		else{
			Launcher.map.setDone(servId, maisId);
		}
		
	}
	
	public boolean isvalid(){
		return (Start_end_check() && TravelCheck());
	}
	
	public boolean addNears(Point p){
		Point lastpoint = pl.get(pl.size()-1);
		if(p.isNear(lastpoint)){
			if(Launcher.map.isIn(p)){
				pl.add(p);
				Launcher.map.putTempLink(p);
			}
			else return false;
		}
		else{
			int deltaX= p.x - lastpoint.x;
			int deltaY= p.y - lastpoint.y;
			
			if(deltaY!=0){
				for(int i=0;i!=deltaY;i+=Math.signum(deltaY)){
					if(lastpoint.y+i >= Launcher.map.heigth){
						return false;
					}
					pl.add(new Point(lastpoint.x,lastpoint.y+i));
					Launcher.map.putTempLink(new Point(lastpoint.x,lastpoint.y+i));
				}
			}
			if(deltaX!=0){
				for(int i=0;i!=deltaX;i+=Math.signum(deltaX)){
					if(lastpoint.x+i >= Launcher.map.width){
						return false;
					}
					pl.add(new Point(lastpoint.x+i,p.y));
					Launcher.map.putTempLink(new Point(lastpoint.x,p.y));
				}
			}
			
			pl.add(p);
			
		}
	
	return true;
	}
	
	
}
