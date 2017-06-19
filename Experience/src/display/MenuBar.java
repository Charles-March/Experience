package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import engine.Launcher;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar{
	JMenuItem reset;
	JMenuItem close,open,save;

	public MenuBar(){
		super();
		//Build the first menu.
		reset = new JMenuItem("Recommencer");
		//reset.setMnemonic(KeyEvent.VK_A);
		add(reset);


		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Launcher.display.setVisible(false);
				Launcher.display.setEnabled(false);
				Launcher.start(2);
			}
		});
		/*
		//a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

		add(menu);
		 */
	}
}
