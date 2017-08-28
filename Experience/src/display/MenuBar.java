package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import engine.Launcher;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar{
	JMenuItem reset;

	public MenuBar(){
		super();
		//Build the first menu.
		reset = new JMenuItem("Une autre !");
		//reset.setMnemonic(KeyEvent.VK_A);
		add(reset);


		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Launcher.mainRedif(null);
			}
		});
	}
}
