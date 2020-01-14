package theGame;

public class Etat {
	
	private int hauteur = 600;
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public void jump() {
		
		this.hauteur =+ 100;
		
//		if(this.hauteur > max_affichage_h)
//			this.hauteur = max_affichage_h;
	}

}
