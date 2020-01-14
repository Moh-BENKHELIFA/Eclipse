package model;

public class Etat {
	
	private int hauteur = 600;
	
	/**
	 * Retourne la position de l'objet dans la fenetre
	 * 
	 * @return 	la position de l'objet
	 */
	public int getHauteur() {
		return this.hauteur;
	}
	
	
	/**
	 * Modifie la hauteur pour que l'objet monte
	 */
	public void jump() {
		
		this.hauteur -= 100;
		
		if(this.hauteur < 0)
			this.hauteur = 0;
	}
	
	
	/**
	 * Modifie la hauteur pour que l'objet descende 
	 */
	public void fall() {
		
		this.hauteur += 100;
		
	}

}
