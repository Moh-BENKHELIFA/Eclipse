package view;
import java.awt.Point;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Etat;

public class Affichage extends JPanel{

	
	private Etat e;
	private final int width;
	private final int height;
	
	/**
	 * Constructeur de la classe Affichage qui permet
	 * l'affichage d'un etat donnee
	 * 
	 * @param e 	 L'etat a afficher
	 * @param width	 longueur de la zone d'affichage
	 * @param height hauteur de la zone d'affichage
	 */
	public Affichage(Etat e, int width, int height) {
		this.e = e;
		this.width = width;
		this.height = height;

	}
	
	
	/**
	 * Dessine sur le JPanel 
	 * 
	 * @ g 	Element Graphics
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.blue);
		g.drawOval(150, e.getHauteur(), 100, 200);
		
		Point[] p = this.e.getParcours();
		
		for(int i=0; i<p.length-1; i++) {
			g.drawLine(p[i].x, p[i].y, p[i+1].x, p[i+1].y);		
		}
		
	}
	
	//TODO
	// La methode paint
	//Les constante des trucs à dessiner
}
