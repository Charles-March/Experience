package types;

import engine.Launcher;

public class Dispositions {

	public static void dispose(){
		switch(Launcher.DispositionChoice){
		
		/*
		 * 	m	s
		 * 	m	s
		 * 	m	s
		 * 
		 */
		case 0:
			Launcher.map.putMaison(1, new Point(100, 35));
			Launcher.map.putMaison(2, new Point(100, 70));
			Launcher.map.putMaison(3, new Point(100, 105));

			Launcher.map.putService(4, new Point(200, 35));
			Launcher.map.putService(5, new Point(200, 70));
			Launcher.map.putService(6, new Point(200, 105));
		break;
		/*
		 * m	m	m
		 * s	s	s
		 * 
		 */
		
		case 1:
			Launcher.map.putMaison(1, new Point(75,  30));
			Launcher.map.putMaison(2, new Point(150,  30));
			Launcher.map.putMaison(3, new Point(225, 30));

			Launcher.map.putService(4, new Point(75,  120));
			Launcher.map.putService(5, new Point(150,  120));
			Launcher.map.putService(6, new Point(225, 120));
		break;
		
		case 2:
			/*
			 * 	  m   m
			 * 	s	s	s
			 * 		m
			 */
			Launcher.map.putMaison(1, new Point(113,  30));
			Launcher.map.putMaison(2, new Point(150,  125));
			Launcher.map.putMaison(3, new Point(188, 30));

			Launcher.map.putService(4, new Point(75,  75));
			Launcher.map.putService(5, new Point(150,  75));
			Launcher.map.putService(6, new Point(225, 75));
		break;
		
		case 3:
			/*
			 *	s	m	s	m	s	m
			 */
			Launcher.map.putMaison(1, new Point(90,  90));
			Launcher.map.putMaison(2, new Point(180,  90));
			Launcher.map.putMaison(3, new Point(270, 90));

			Launcher.map.putService(4, new Point(45,  90));
			Launcher.map.putService(5, new Point(135,  90));
			Launcher.map.putService(6, new Point(225, 90));
		break;
		
		case 4:
			/*		s
			 * 	m		m
			 * 	s		s
			 * 		m
			 */
			
			Launcher.map.putMaison(1, new Point(75,  60));
			Launcher.map.putMaison(2, new Point(225,  60));
			Launcher.map.putMaison(3, new Point(150, 120));

			Launcher.map.putService(4, new Point(150,  30));
			Launcher.map.putService(5, new Point(75,  90));
			Launcher.map.putService(6, new Point(225, 90));
			
		break;
		default:
		break;
		}
		
	}
}
