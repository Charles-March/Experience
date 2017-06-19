package display;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

	public class MainWindowsEvent implements WindowListener{

		public MainWindowsEvent() {
			super();
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowClosed(WindowEvent e) {
			System.exit(0);		
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {	
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowOpened(WindowEvent e) {
		}
		
	}
