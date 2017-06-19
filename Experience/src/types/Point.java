package types;

public class Point {
	public int x;
	public int y;
	
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public boolean isEqual(Point p){
		return (x==p.x && y==p.y);
	}
	
	public boolean isDifferent(Point p){
		return (!(x==p.x && y==p.y));
	}
	
	
	public boolean isNear(Point p){
		boolean a = (p.x == x-1);
		boolean b = (p.x == x+1);
		boolean c = (p.y == y-1);
		boolean d = (p.y == y+1);
		return (distance(p)==1) && (a||b||c||d);
	}
	
	public int distance(Point p){
		return (Math.abs(p.x-x) + Math.abs(p.y-y));
	}
}
