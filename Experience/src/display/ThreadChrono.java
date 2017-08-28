package display;

import engine.Launcher;

public class ThreadChrono extends Thread{
	int mn=30;
	int sec=0;
	
	public ThreadChrono() {
		super();
	}
	

	@Override
	public void run() {
		super.run();
		while(mn>=0){
			try {
				Thread.sleep(990);
				sec--;
				if(sec<0){
					sec=59;
					mn--;
				}
				Launcher.display.pannelinf.majChronoJeu(mn, sec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Launcher.display.end();
	}

}
