package src;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Affichage extends JPanel {
	
	public static final int width = 1500;
	public static final int height = 800;
	public Graphics p;
	
	public Affichage() {
		setPreferredSize(new Dimension(width, height));
		this.p = getComponentGraphics(p);
	}
	
	public void paint(Graphics g) {
		
		g.drawOval(500, 500, 200, 100);
		
	}
	
	public static void main(String args[]) {
		
		JFrame fenetre = new JFrame ("Affichage");
		Affichage a = new Affichage();
		fenetre.add(new Affichage());
		//fenetre.add()
		Graphics p ;
		a.paint(p);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		fenetre.setSize(width, height);
	    fenetre.setLocationRelativeTo(null); //Centrer la fenêtre
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
