package types;

public class Objet {
	public int id;
	public boolean justfat=false;
	/*
	 * 0 = Vide
	 * 1 = MA
	 * 2 = MB
	 * 3 = MC
	 * 4 = SA
	 * 5 = SB
	 * 6 = SC
	 * 7 = link
	 * 8 = temp link
	 */
	
	public void setShadow(boolean b){
		justfat=b;
	}
	
	public boolean isShadow(){
		return justfat;
	}
	
	public Objet(){
		id=0;
	}
	
	public Objet(int s){
		Changeid(s);
	}
	
	public void setid(int s){
		Changeid(s);
	}
	
	private void Changeid(int i){
		id=i;
	}
	
	public boolean isTemp(){
		return(id==8);
	}
	
	public boolean isMaison(){
		return(id>0 && id<4);
	}
	
	public boolean isService(){
		return(id>3 && id<7);
	}
	
	public boolean isLink(){
		return (id==7);
	}
	
	public boolean isObject(){
		return (id>0 && id<8);
	}
}
