package engine;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import types.Point;
import types.Reponse;
import types.Trajet;


public class Import extends DefaultHandler {

	boolean bx=false;
	boolean by=false;
	boolean btrajet=false;
	boolean bcode=false;
	boolean btrajetList=false;
	boolean bpoint=false;
	boolean btime=false;
	boolean bstart=false;
	boolean breponse=false;
	boolean bvalue=false;
	boolean bid=false;
	
	String code;
	int x;
	int y;
	int timer;
	int id;
	String value;
	Point p;
	List<Integer> lti = new LinkedList<Integer>();
	List<Trajet> ltr = new LinkedList<Trajet>();
	List<Point> lp = new LinkedList<Point>();
	List<Point> sl = new LinkedList<Point>();
	List<List<Integer>> TimerList = new LinkedList<List<Integer>>();
	List<List<Trajet>> TrajetList = new LinkedList<List<Trajet>>();
	List<List<Point>> StartingList = new LinkedList<List<Point>>();
	List<Reponse> ReponseList = new LinkedList<Reponse>();
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("code")){ 
			bcode=true;
		} else if (qName.equalsIgnoreCase("x")) {
			bx= true;
		} else if (qName.equalsIgnoreCase("y")) {
			by= true;
		} else if (qName.equalsIgnoreCase("trajet")) {
			btrajet= true;
		} else if (qName.equalsIgnoreCase("reponse")) {
			breponse= true;
		} else if (qName.equalsIgnoreCase("id")) {
			bid= true;
		} else if (qName.equalsIgnoreCase("value")){
			bvalue=true;
		} else if (qName.equalsIgnoreCase("trajetList")){
			btrajetList=true;
		} else if (qName.equalsIgnoreCase("point")){
			bpoint=true;
		} else if (qName.equalsIgnoreCase("start")){
			bstart=true;
		} else if (qName.equalsIgnoreCase("timer")){
			btime=true;
		}
	}
	
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equalsIgnoreCase("point")) {
				p=new Point(x,y);
				lp.add(p);
			} else if(qName.equalsIgnoreCase("start")){
				sl.add(new Point(x,y));
			} else if(qName.equalsIgnoreCase("trajet")){
				lti.add(timer);
				ltr.add(new Trajet(lp));
				lp=new LinkedList<Point>();
			} else if(qName.equalsIgnoreCase("trajetList")){
				TimerList.add(lti);
				StartingList.add(sl);
				TrajetList.add(ltr);
				System.out.println("Trajet de taille :" +ltr.size());
				sl = new LinkedList<Point>();
				lti = new LinkedList<Integer>();
				ltr = new LinkedList<Trajet>();
			} else if(qName.equalsIgnoreCase("reponse")){
				ReponseList.add(new Reponse(id, value));
			}
		}
		
		public void characters(char ch[], int start, int length) throws SAXException {
			String lecture = new String(ch, start, length);
			if (bcode) {
				bcode=false;
				code=lecture;
			} else if (bx) {
				bx=false;
				x = Integer.parseInt(lecture);
			} else if (by){
				by = false;
				y = Integer.parseInt(lecture);
			} else if(btime){
				btime=false;
				timer=Integer.parseInt(lecture);
				System.out.println(timer);
			} else if (bvalue){
				bvalue=false;
				value=lecture;
			} else if(bid){
				bid=false;
				id=Integer.parseInt(lecture);
			}
			
		}
		
	}
