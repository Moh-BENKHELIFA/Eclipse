package model;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


import view.Affichage;

public class Parcours {
	
	/** Constantes */
	private ArrayList<Point> Courbe;
	private int LargeurPanel;
    public static final Random rand = new Random();
    private int position = 10;
    private final int avance = 1;
    private static int lastXposition = 0;
    public static Point lastPoint = null;
    private boolean supp = false;
    private int Xposition = 0;
    private int TOPYposition = 200;
    private Etat e;
    
    

	/**Constructeur*/
	public Parcours(int x) {
	//	System.out.println(a.getWidth());
		this.LargeurPanel = x + 200;
		Courbe = new ArrayList();
		init_Courbe(this.LargeurPanel);
	}

	
	public int getPosition() {
		return this.position;
	}
	
	public void setPosition(){
		this.position += avance;
	}
	
//	private void init_Courbe(int LargeurPanel) {
//		int x,y;
//		int oldx = 200;
//		int oldy = 300;
//		Courbe.add(new Point(oldx,oldy));
//		for(int i=0; i<40; i++) {
//			x=rand.nextInt(200);
//			
//			y=rand.nextInt(300);
//			oldx +=x;
//			this.lastXposition = oldx;
//			//oldy +=y;
//			Courbe.add(new Point(oldx,oldy + y));
//			
//	}//Courbe.add(new Point(LargeurPanel-150,200));
	
	/*AFFICHAGE
	System.out.println("Largeur de la Panel : " + (this.LargeurPanel - 200));
	System.out.println("Nombre d'élement dans la liste : " +Courbe.size());
	for(Point p : Courbe) {
		System.out.println("Point(" + p.x + " : " + p.y + ")");
	}*/
// }
	
	private void printPointList() {
		System.out.println("Nombre d'�lement dans la liste : " +Courbe.size());
		for(Point p : Courbe) {
			System.out.println("Point(" + p.x + " : " + p.y + ")");
		}
	}
		
	private void init_Courbe(int LargeurPanel) {
		Courbe.add(new Point(this.Xposition,this.TOPYposition));
		for(int i=0; i<3; i++) {
			Xposition += 200;
			Courbe.add(new Point(this.Xposition,this.TOPYposition));
		}
		
		for(int i=0; i<7; i++) {
			int y=rand.nextInt(300);
			Xposition += 200;
			Courbe.add(new Point(Xposition,TOPYposition + y));
		}
	}
	
	public void change() {		
		for(Point p : this.Courbe) {
			p.x -= this.position;
		}
	}
	
	public void suppPoint(Point p) {
		if(this.supp) {
			Courbe.remove(p);
			addNewPoint();
			this.supp=false;
		}

	}
	
	
	public void suppPoint() {
		for(Point p : Courbe) {
			if(p.x < -200) {			
				Courbe.remove(p);

			}
			
		}
	}
	
	
	public void addNewPoint() {
		int lastXPoint = this.lastXposition ;
		int x=rand.nextInt(200);
		
		int y=rand.nextInt(300);
		//lastXPoint +=x;
		Courbe.add(new Point(Xposition,300 + y));
		
	}
	
//	public Point[] getParcours(){
//		Point[] tab = new Point[Courbe.size()];
//		int i =0;
//		ArrayList<Point> PP = new ArrayList();
//		for(Point p : Courbe) {
//			//if(position - p.x < this.LargeurPanel) {
//			//	p.x -= this.position;
//				tab[i] = p;
//				i++;
//			//}
//		}
//		return tab;
//	}
	
	public ArrayList<Point> getParcours(){
		int i =0;
		ArrayList<Point> PP = new ArrayList();
		for(Point p : Courbe) {
			if(p.x < -200) {
				//printPointList();
				this.lastPoint = p;
				this.supp=true;
//				suppPoint(p);
				//printPointList();
//				addNewPoint();
			}else if(p.x < this.LargeurPanel) {
				PP.add(p);
			}
			
		}
		return PP;
	}

}
