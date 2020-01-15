package model;
import java.awt.Point;


public class Etat {
	
	/*Constantes*/
	private int hauteur = 400; 						
	private int hauteur_fenetre;
	private Parcours parcours;
	private final int SAUT = 100;
	private final int CHUTE = 10;

	
	public Etat(Parcours p) {
		this.parcours = p;	
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
	
	public Point[] getParcours() {
		return this.parcours.getParcours();
	}

}
