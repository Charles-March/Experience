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
public class LecturePopupForceQuit extends JDialog{
	JLabel jl1,jl2;
	JTextField jf;
	JPanel jp1,jp2;
	JCheckBox jc1,jc2,jc3,jc4,jc5;
	JButton end;
	
	public LecturePopupForceQuit(){
		super();
		setTitle("Questions");
		
		
		
		jl1 = new JLabel();
		jl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl1.setText("<html><p>Vous avez décidé d’arrêter l’expérimentation.</p>"
        		+ "<p>Pourquoi avez-vous choisi d’arrêter avant la fin du temps imparti?</p>"
        		+ "<p>Choisissez une ou plusieurs réponses parmi les propositions.</p>"
        		+ "<p> </p></html>");

        
       
        
        jc1 = new 	JCheckBox("Je me suis lassé (e)");
        jc2 = new 	JCheckBox("Je tournais en rond");
        jc3 = new 	JCheckBox("Je trouve que ce problème est trop difficile");
        jc4 = new 	JCheckBox("Je pense que ce problème n’a pas de solution");
        jc5 = new 	JCheckBox("J’avais envie d’arrêter tout simplement");
        
        
        jl2 = new JLabel();
        jl2.setText("     Autre : ");
        jf = new JTextField(" ");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp2.setLayout(new BoxLayout(jp2, BoxLayout.X_AXIS));
        
 /*       jf.setSize(jl2.getWidth(), 20);
        jf.setMaximumSize(new Dimension(300, jl2.getHeight()));
        jf.setMinimumSize(new Dimension(300, jl2.getHeight()));
        jf.setSize(300, jl2.getHeight());
 */   
        jp2.add(jl2);
        jp2.add(jf);
        
        jp2.setVisible(true);
        
        end = new JButton("Quitter");
        
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
        jp1.add(jc4);
        jp1.add(jc5);
        jp1.add(jp2);
        jp1.add(end);
        add(jp1);
        
        setLocationRelativeTo(null);
        setSize(575, 275);
        
        fillValues();
       
        setVisible(true);
        
	}
	
	public void fillValues() {
		for(int i=0;i<Launcher.Reponses.size();i++){
			Reponse rep= Launcher.Reponses.get(i);
			System.out.println("reponse id:"+rep.id+" Value='"+rep.value+"'");
			if(rep.id==1 && rep.value=="TRUE"){
				jc1.setSelected(true);
			}
			else if(rep.id==2 && rep.value.equalsIgnoreCase("TRUE")){
				System.out.println("2 ok");
				jc2.setSelected(true);
			}
			else if(rep.id==3 && rep.value.equalsIgnoreCase("TRUE")){
				jc3.setSelected(true);
			}
			else if(rep.id==4 && rep.value.equalsIgnoreCase("TRUE")){
				jc4.setSelected(true);
			}
			else if(rep.id==5 && rep.value.equalsIgnoreCase("TRUE")){
				jc5.setSelected(true);
			}
			else if(rep.id==6){
				jf.setText(rep.value);
			}
		}
	}
}
