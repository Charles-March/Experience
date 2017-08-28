package engine;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import types.Point;
import types.Reponse;
import types.Trajet;


public class ParserPartie {
	List<List<Integer>> TimerList = new LinkedList<List<Integer>>();
	List<List<Trajet>> TrajetList = new LinkedList<List<Trajet>>();
	List<List<Point>> StartingList = new LinkedList<List<Point>>();
	List<Reponse> ReponseList = new LinkedList<Reponse>();
	String code;
	public ParserPartie(String FilePath){
		SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
		try {
			parser = factory.newSAXParser();
        
        File f=new File(FilePath);
        Import imp = new Import();
		parser.parse(f, imp);
		
		TimerList = imp.TimerList;
		TrajetList = imp.TrajetList;
		StartingList = imp.StartingList;
		ReponseList = imp.ReponseList;
		code=imp.code;
		
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
        
	}
}