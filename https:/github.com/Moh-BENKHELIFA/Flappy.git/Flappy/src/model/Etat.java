package model;
import java.awt.Point;
import java.util.ArrayList;


public class Etat {
	
	/*Constantes*/
	private int x_pos = 220;
	private int hauteur = 50; 						
	private int hauteur_fenetre;
	private Parcours parcours;
	private final int SAUT = 100;
	private final int CHUTE = 10;
	private final int MONTE = 10;
	public Point test = new Point(0,0);
	public boolean collision = false;
	private boolean jumped = false;
	private int objective;
	private int SCORE = 0;
	
	public Etat(Parcours p) {
		this.parcours = p;	
	}
	
	public void upgradeScore() {
		SCORE ++;
	}
	
	public void afficheScore() {
		System.out.println("Vous avez obtenu un score de : " + SCORE);
	}
	
	/**
	 * Retourne la position de l'objet dans la fenetre
	 * 
	 * @return 	la position de l'objet
	 */
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getPosition() {
		return this.parcours.getPosition();
	}
	public void initHauteurFenetre(int y) {
		this.hauteur_fenetre = y;
	}
	
	/**
	 * Modifie la hauteur pour que l'objet monte
	 */
	public void jump() {
		
		this.hauteur -= SAUT;
		
		if(this.hauteur < 0)
			this.hauteur = 0;
	}
	
	public void jump2() {
		
		upgradeScore();
		
		this.objective = this.hauteur - SAUT;
//		System.out.println(objective);     
		this.jumped = true; 
		
		if(this.hauteur < 0)
			this.hauteur = 0;
	}
	
	/**
	 * Modifie la hauteur pour que l'objet descende 
	 */
	public void fall() {
		
		this.hauteur += SAUT;
		
	}
	
	/**
	 * Modifie la hauteur pour que l'objet tombe sans sortir de l'ecran	 
	 */
	public void moveDown() {
		
		this.hauteur += CHUTE;
		if(this.hauteur > this.hauteur_fenetre-250)
			this.hauteur = this.hauteur_fenetre-250;
		
	}
	
	private void moveUp() {
		this.hauteur -= MONTE;
		if(this.hauteur <= this.objective) {
			this.jumped = false;
		}
	}
	
	public void jumped() {
		this.jumped = true;
	}
	
		public void move() {
//		System.out.println(jumped);  
		if(jumped) {
			moveUp();			
		}else {
			moveDown();
		}
		
	}
//	public Point[] getParcours() {
//		return this.parcours.getParcours();
//	}
	
	public Point[] getParcours() {
		
		ArrayList<Point> temp = this.parcours.getParcours();
		
		Point[] tab = new Point[temp.size()];
		int i=0;
		for(Point p : temp) {
			tab[i] = p;
			i++;
		}
		
		return tab;
	}
	
	
	private Point nose() {
		Point[] tab = getParcours();
		int y ;
		if(this.x_pos == tab[1].x){
			return tab[1];
		}
		else if(tab[1].x < this.x_pos) {
		
			y = point2points(tab[1],tab[2]);
		}else {
			y = point2points(tab[0],tab[1]);
		}
		
		return new Point(this.x_pos ,y);
	}
	
//	public void nose2() {
//		Point[] tab = getParcours();
//		
//		int y = 0;
//		
//		if(this.x_pos == tab[1].x){
//			test = tab[1];
//		}
//		else if(tab[1].x < this.x_pos) {
//			y = point2points(tab[1],tab[2]);
//			System.out.println("quand P[1]G  y= " + y);
//			test =  new Point(this.x_pos ,tab[1].y+y);
//			System.out.println("Tab[1] : " +tab[1] +"\nTaille : "+ tab.length);
//		}else {
//			y = point2points(tab[0],tab[1]);
//			System.out.println("quand P[1]D  y= " + y);
//			test =  new Point(this.x_pos ,tab[1].y+y);
//
//		}
//		
//	}
	
	
	public void nose2() {
		Point[] tab = getParcours();
		
		
		if(this.x_pos == tab[1].x){
			test = tab[1];
		}
		else if(tab[1].x < this.x_pos) {
			//Comparer entre p1 et p2
			int y = point2points(tab[1],tab[2]);
			test =  new Point(this.x_pos ,tab[2].y-y);
		}else {
			//Comparer entre p0 et p1
	//		test =  new Point(this.x_pos ,tab[2].y);
			int y = point2points(tab[0],tab[1]);
			test =  new Point(this.x_pos ,tab[1].y-y);
		}
		
	}
	
	

	/**
	 * 
	 * @param a 	le point a gauche de l'oval
	 * @param b		le point a droite de l'oval
	 */
	private int point2points(Point a, Point b) {
		
		Point vecteur = new Point(a.x - b.x, a.y-b.y);
//		System.out.println("vecteur " +vecteur.x+" : " + vecteur.y);
		float posX = b.x - this.x_pos;
//		System.out.println("posX " +posX);

//		System.out.println("a " +a.x+" : " + a.y);
//		System.out.println("b " +b.x+" : " + b.y);

		float f = ((posX)/vecteur.x);
//		System.out.println("return f : " + f);
		
		float i = (float) vecteur.y * f;
//		System.out.println("return " + (int) i);
		
//		return vecteur.y * ((posX)/vecteur.x);
		return (int) i;
	
	}
	
	private int point2points2(Point a, Point b) {
		
		Point vecteur = new Point(a.x - b.x, a.y-b.y);
		
		int X;
		if(b.x < this.x_pos) {
			 X = b.x - this.x_pos;	
		}else {
			 X = b.x + this.x_pos;
		}
		
		float temp = (float) vecteur.y * (float) (X/vecteur.x);
		
		return (int) temp ;
	
	}
	
	public ArrayList<Point> getParocurs(){
		return this.parcours.getParcours();
	}


	public void checkCollision() {
		if(this.test.y == this.getHauteur()+30 || this.test.y > this.getHauteur()+165) {
//			System.out.println("CONTACT");
//			this.collision = true;
		}
		
	}
}
