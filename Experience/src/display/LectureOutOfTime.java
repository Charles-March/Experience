package display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import types.Reponse;
import engine.Launcher;

@SuppressWarnings("serial")
public class LectureOutOfTime extends JDialog{
	JLabel jl1,jl2,jl3;
	JTextField jf;
	JPanel jp1,jp2;
	JCheckBox jc1,jc2,jc3,jc4,jc5,jc6,jc7,jc8;
	JButton end;
	
	public LectureOutOfTime(){
		super();
		setTitle("Questions");

		jl1 = new JLabel();
		jl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl1.setText("<html><p>Votre temps imparti est terminé.</p>"
        		+ "<p>Pensez-vous réussir à trouver une solution si je vous accordais plus de temps :</p>"
        		+ "<p> </p></html>");

        
       
        
        jc1 = new 	JCheckBox("Oui");
        jc2 = new 	JCheckBox("Non");
        jc3 = new 	JCheckBox("Peut-être");
        
        jl2 = new JLabel();
        jl2.setText("<html><br><p>Si vous avez répondu Non, pourquoi pensez-vous ne pas y arriver?</p>");
        
        jc4 = new 	JCheckBox("Je finirais par me lasser");
        jc5 = new 	JCheckBox("Je finirais par m’ennuyer");
        jc6 = new 	JCheckBox("Je pense que le problème est difficile");
        jc7 = new 	JCheckBox("Je pense que le problème n’a pas de solution");
        
        jl3 = new JLabel();
        jl3.setText("     Autre : ");
        jf = new JTextField("");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp2.setLayout(new BoxLayout(jp2, BoxLayout.X_AXIS));
        
 /*       jf.setSize(jl2.getWidth(), 20);
        jf.setMaximumSize(new Dimension(300, jl2.getHeight()));
        jf.setMinimumSize(new Dimension(300, jl2.getHeight()));
        jf.setSize(300, jl2.getHeight());
 */   
        jp2.add(jl3);
        jp2.add(jf);
        
        jp2.setVisible(true);
        
        end = new JButton("Suivant");
        
        end.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				setEnabled(false);
			}


		});
        
        jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
        jp1.add(jl1);
        jp1.add(jc1);
        jp1.add(jc2);
        jp1.add(jc3);
        
        jp1.add(jl2);
        
        jp1.add(jc4);
        jp1.add(jc5);
        jp1.add(jc6);
        jp1.add(jc7);
        jp1.add(jp2);
        jp1.add(end);
        add(jp1);
        
        setLocationRelativeTo(null);
        setSize(550, 335);
        
        fillValues();
       
        setVisible(true);
        
	}
	
	private void fillValues() {
		for(int i=0;i<Launcher.Reponses.size();i++){
			Reponse rep= Launcher.Reponses.get(i);
			if(rep.id==11 && rep.value.equalsIgnoreCase("TRUE")){
				jc1.setSelected(true);
			}
			else if(rep.id==12 && rep.value.equalsIgnoreCase("TRUE")){
				jc2.setSelected(true);
			}
			else if(rep.id==13 && rep.value.equalsIgnoreCase("TRUE")){
				jc3.setSelected(true);
			}
			else if(rep.id==14 && rep.value.equalsIgnoreCase("TRUE")){
				jc4.setSelected(true);
			}
			else if(rep.id==15 && rep.value.equalsIgnoreCase("TRUE")){
				jc5.setSelected(true);
			}
			else if(rep.id==16 && rep.value.equalsIgnoreCase("TRUE")){
				jc5.setSelected(true);
			}
			else if(rep.id==17 && rep.value.equalsIgnoreCase("TRUE")){
				jc5.setSelected(true);
			}
			else if(rep.id==18){
				jf.setText(rep.value);
			}
		}
	}
}
