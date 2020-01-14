package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Etat;

public class Affichage extends JPanel{

	
	private Etat e;
	private final int width;
	private final int height;
	
	public Affichage(Etat e, int width, int height) {
		this.e = e;
		this.width = width;
		this.height = height;

	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.blue);
		g.drawOval(500, e.getHauteur(), 100, 200);
	
	}
	
	//TODO
	// La methode paint
	//Les constante des trucs à dessiner
}
