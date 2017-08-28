package display;

import javax.swing.JOptionPane;

import types.Map;
import types.Reponse;
import engine.Launcher;

public class LectureEvent {
	static int essai=0;
	static int numeroTrajet=0;
	
	
	public static void putNextTrajet(){
		if(numeroTrajet==0) PutStart();
		if(essai < Launcher.Save.size()){
			if(numeroTrajet < Launcher.Save.get(essai).size()){
				int time =Launcher.FinalTimer.get(essai).get(numeroTrajet);
				System.out.println(time);
				Launcher.displayLecture.pannelinf.majChrono(time/60,time%60); 
				Launcher.NbEssai=essai+1;
				Launcher.displayLecture.pannelinf.majEssai();
				Launcher.Save.get(essai).get(numeroTrajet).PutOnMap();
				numeroTrajet++;
				Launcher.displayLecture.pannel.repaint();
			}
			else{
				numeroTrajet=0;
				Launcher.map = new Map(1000,1000);
				essai++;
			}
			
		}
		else{
			int choice = JOptionPane.showConfirmDialog(Launcher.display, "Il n'y a plus de trait, veux-tu voir les réponses ?");
			if(choice==0){
				printRep();
			}
		}
	}
	
	static void back(){
			if(essai<=0){
			 essai=0;
			 numeroTrajet=0;
			 Launcher.map= new Map(1000, 1000);
			}
			else{
				essai--;
				Launcher.map = new Map(1000,1000);
				numeroTrajet = 0;
				putNextTrajet();
			}
	}
	
	static void printRep(){
		int first = Launcher.Reponses.get(0).id;
		if(first<10){
			new LecturePopupForceQuit();
		}
		else{
			new LectureOutOfTime();
		}
	}
	
	static void PutStart(){
		if(essai < Launcher.ListeStart.size()){
			System.out.println("starting, = " + Launcher.ListeStart.get(essai).size());
			for(int i=0;i<6;i++){
				if(i<3)
					Launcher.map.putMaison(i+1,Launcher.ListeStart.get(essai).get(i));
				else
					Launcher.map.putService(i+1,Launcher.ListeStart.get(essai).get(i));
				
			}
		}
	}
}
