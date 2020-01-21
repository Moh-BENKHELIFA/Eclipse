package view;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Etat;

public class Affichage extends JPanel{

	
	private Etat e;
	private final int width;
	private final int height;
	public BufferedImage image ;
	private viewOiseau vO = null;
	
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
	
	
//	private void drawLine(Graphics g) {
//		Point[] p = this.e.getParcours();
//		
//		for(int i=0; i<p.length-1; i++) {
//			g.drawLine(p[i].x, p[i].y, p[i+1].x, p[i+1].y);		
//		}
//		
//	}
	
	public void addVO(viewOiseau v) {
		this.vO = v;
	}
	
	private void drawLine(Graphics2D g) {
		Point[] p = this.e.getParcours();
		g.setStroke(new BasicStroke(2.0f));

		for(int i=0; i<p.length-1; i++) {
			g.drawLine(p[i].x, p[i].y, p[i+1].x, p[i+1].y);		
		}
		
		g.setColor(Color.red);
		g.setStroke(new BasicStroke(1.0f));

	} 
	
	/**
	 * Dessine sur le JPanel 
	 * 
	 * @ g 	Element Graphics
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(vO!=null) {
			vO.dessiner(g);
		}
		g.setColor(Color.black);
		Graphics2D g1 = (Graphics2D) g;
		drawLine(g1);
//		g.drawOval(150, e.getHauteur(), 100, 200);
		try {
			image = ImageIO.read(new File("/home/tp-home002/mbenkhe/eclipse-workspace/Flappy/images/Circle.png"));
			g.drawImage(image, 150, e.getHauteur(), null);
//			g.drawImage(image, 150, e.test.y-35, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		g.drawOval(e.test.x, e.test.y, 5, 5);
		
		/*Affiche les zone de collision*/
		g.setColor(Color.black);
		g.drawOval(e.test.x, e.getHauteur()+30, 5, 5);
		g.drawOval(e.test.x, e.getHauteur()+165, 5, 5);

		
		
		
	}
	
	//TODO
	// La methode paint
	//Les constante des trucs à dessiner
}
