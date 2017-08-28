package display;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class PannelLeft extends JPanel{
	public JSplitPane split;
	public PannelLeft(){
		
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		split.setTopComponent(new PannelRegles());
		split.setBottomComponent(new JPanel());
		add(split);
		setVisible(true);
	}
}
