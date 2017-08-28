package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import engine.Launcher;

@SuppressWarnings("serial")
public class PannelInformation extends JPanel{
JLabel Chrono, nombreEssai,Code;
	int height=75;
	int width = 150;
	
	public PannelInformation(){
		Chrono =new JLabel("", SwingConstants.CENTER);
		nombreEssai =  new JLabel("", SwingConstants.CENTER);
		
		Code =  new JLabel("", SwingConstants.CENTER);
		
		Chrono.setMinimumSize(new Dimension(100, 50));
		Chrono.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
		Chrono.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		Chrono.setMinimumSize(new Dimension(width, height));
		Chrono.setPreferredSize(new Dimension(width, height));
		Chrono.setMaximumSize(new Dimension(width, height));
		
		nombreEssai.setMinimumSize(new Dimension(100, 50));
		nombreEssai.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
		nombreEssai.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		nombreEssai.setMinimumSize(new Dimension(width, height));
		nombreEssai.setPreferredSize(new Dimension(width, height));
		nombreEssai.setMaximumSize(new Dimension(width, height));
		
		Code.setMinimumSize(new Dimension(100, 50));
		Code.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
		Code.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		Code.setMinimumSize(new Dimension(width, height));
		Code.setPreferredSize(new Dimension(width, height));
		Code.setMaximumSize(new Dimension(width, height));
		
		setVisible(true);
		majEssai();
		majCode();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Code);
		add(Chrono);
		add(nombreEssai);
	}
	
	public void majEssai(){
		nombreEssai.setText("Essai : "+Launcher.NbEssai);
	}
	
	public int getChrono(){
		String[] s= (Chrono.getText().split(":"));
		System.out.println("sec="+s[0] + "mn ="+s[1]);
		return Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
		}
	
	public void majChrono(int mn,int sec){
		mn=29-mn;
		sec=59-sec;
		String s="";
		if(mn<10)s="0"+mn+":";
		else s=mn+":";
		
		if(sec<10)s=s+"0"+sec;
		else s=s+sec;
		Chrono.setText(s);
	}
	public void majChronoJeu(int mn, int sec){
		String s="";
		if(mn<10)s="0"+mn+":";
		else s=mn+":";
		
		if(sec<10)s=s+"0"+sec;
		else s=s+sec;
		Chrono.setText(s);
	}
	
	public void majCode(){
		Code.setText(Launcher.code);
	}
	
	
}
