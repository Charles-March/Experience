package engine;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import types.Trajet;

public class Export {
	
	static void Save() throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer= null;
		if(OSValidator.isWindows()){
			writer = new PrintWriter((System.getProperty("user.dir")+"/Ressources/save.dat").replace('/','\\'), "UTF-8");	
		}
		else{
			writer = new PrintWriter((System.getProperty("user.dir")+"/Ressources/save.dat").replace('\\','/'), "UTF-8");
		}
		writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    writer.println("<save>");
	    
	    /* EACH GAME */
	    writer.print("  <code>");
	    writer.print(Launcher.code);
	    writer.println("</code>");
	    
	    for(int i=0;i<Launcher.Save.size();i++){
	    	/* EACH RETRY */
	    	List<Integer> timerList = Launcher.FinalTimer.get(i);
	    	List<Trajet> trajetList = Launcher.Save.get(i);	
	    	writer.println("<trajetList>");
	    	for(int k=0;k<6;k++){
    			writer.println("  <start>");
    			
    			writer.print("    <x>");
    			writer.print(Launcher.ListeStart.get(i).get(k).x);
    			writer.println("</x>");
    			
    			writer.print("    <y>");
    			writer.print(Launcher.ListeStart.get(i).get(k).y);
    			writer.println("</y>");
    			
    			writer.println("  </start>");
    			
    		}
	    	for(int j=0;j<trajetList.size();j++){
	    		
	    		Trajet traj = trajetList.get(j);
	    		/*EACH WRITE */
	    		writer.println("  <trajet>");
	    		writer.println("<timer>"+timerList.get(j)+"</timer>");
	    		
	    		
	    		
	    		for(int k=0;k<traj.pl.size();k++){
	    			/*EACH POINT ON THE WRITE*/
	    			writer.println("    <point>");
	    			
	    			writer.print("      <x>");
	    			writer.print(traj.pl.get(k).x);
	    			writer.println("</x>");
	    			
	    			writer.print("      <y>");
	    			writer.print(traj.pl.get(k).y);
	    			writer.println("</y>");
	    			
	    			writer.println("    </point>");
	    		}
	    		writer.println("  </trajet>");
	    		
	    	}
	    	writer.println("</trajetList>");
	    }
	    
	    for(int i=0;i<Launcher.Reponses.size();i++){
	    	writer.println("  <reponse>");
	    	
	    	writer.print("    <id>");
	    	writer.print(Launcher.Reponses.get(i).id);
	    	writer.println("</id>");
	    	
	    	writer.print("    <value>");
	    	writer.print(Launcher.Reponses.get(i).value);
	    	writer.println("</value>");
	    	
	    	writer.println("  </reponse>");
	    	
	    }
	    
	    writer.println("</save>");
	    
	    writer.close();
	}
	
}
