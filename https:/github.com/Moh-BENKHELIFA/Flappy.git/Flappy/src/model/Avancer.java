package model;

import view.Affichage;

public class Avancer extends Thread{

	public Etat e;
	public Affichage a;
	public Parcours p;
	int i;
	
    /**
     * Constructeur de la classe Voler 
     * @param e
     * @param a
     */
	public Avancer(Parcours p, Etat e) {
		this.p = p;
		this.e = e;
	}
	
	/**
	 * Run
	 */
	@Override
	public void run() {
		
		boolean b = true;
		while(!e.collision ) {
			this.p.change();
			this.e.nose2();
			this.e.checkCollision();
			if(p.lastPoint != null)
			this.p.suppPoint(p.lastPoint);
//			this.p.addNewPoint();
		//	this.p.setPosition();
			try { Thread.sleep(50); }
		    catch (Exception e) { e.printStackTrace(); }
		}
	}
}
