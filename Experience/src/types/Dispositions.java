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
			Launcher.map.putMaison(1, new Point(50, 35));
			Launcher.map.putMaison(2, new Point(50, 70));
			Launcher.map.putMaison(3, new Point(50, 105));

			Launcher.map.putService(4, new Point(150, 35));
			Launcher.map.putService(5, new Point(150, 70));
			Launcher.map.putService(6, new Point(150, 105));
		break;
		/*
		 * m	m	m
		 * s	s	s
		 * 
		 */
		
		case 1:
			Launcher.map.putMaison(1, new Point(25,  30));
			Launcher.map.putMaison(2, new Point(100,  30));
			Launcher.map.putMaison(3, new Point(175, 30));

			Launcher.map.putService(4, new Point(25,  120));
			Launcher.map.putService(5, new Point(100,  120));
			Launcher.map.putService(6, new Point(175, 120));
		break;
		
		case 2:
			/*
			 * 	  m   m
			 * 	s	s	s
			 * 		m
			 */
			Launcher.map.putMaison(1, new Point(67,  30));
			Launcher.map.putMaison(2, new Point(100,  125));
			Launcher.map.putMaison(3, new Point(133, 30));

			Launcher.map.putService(4, new Point(25,  75));
			Launcher.map.putService(5, new Point(100,  75));
			Launcher.map.putService(6, new Point(175, 75));
		break;
		
		case 3:
			/*
			 *	s	m	s	m	s	m
			 */
			Launcher.map.putMaison(1, new Point(50,  90));
			Launcher.map.putMaison(2, new Point(140,  90));
			Launcher.map.putMaison(3, new Point(230, 90));

			Launcher.map.putService(4, new Point(20,  90));
			Launcher.map.putService(5, new Point(95,  90));
			Launcher.map.putService(6, new Point(185, 90));
		break;
		
		case 4:
			/*		s
			 * 	m		m
			 * 	s		s
			 * 		m
			 */
			
			Launcher.map.putMaison(1, new Point(25,  60));
			Launcher.map.putMaison(2, new Point(175,  60));
			Launcher.map.putMaison(3, new Point(100, 120));

			Launcher.map.putService(4, new Point(100,  30));
			Launcher.map.putService(5, new Point(25,  90));
			Launcher.map.putService(6, new Point(175, 90));
			
		break;
		default:
		break;
		}
		
	}
}
