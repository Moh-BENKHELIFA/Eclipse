package model;
import java.util.Random;

import view.Affichage;

public class Voler extends Thread {

	public Etat e;
	public Affichage a;
	
    /**
     * Constructeur de la classe Voler 
     * @param e
     * @param a
     */
	public Voler(Etat e, Affichage a) {
		this.e = e;
		this.a = a;
	}
	
	/**
	 * Run
	 */
	@Override
	public void run() {
		

		while(!e.collision) {
			e.move();
//			e.nose2();
			a.repaint();
			try { Thread.sleep(50); }
		    catch (Exception e) { e.printStackTrace(); }
		}
		
		e.afficheScore();
	}
}
