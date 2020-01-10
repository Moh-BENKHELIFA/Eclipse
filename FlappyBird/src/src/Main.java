package src;

import javax.swing.JFrame;


public class Main {
	
	
	public static void newWindow(int width, int height) {
		
		JFrame fenetre = new JFrame("titre de la fenêtre");
//		fenetre.add(composant);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		fenetre.setSize(width, height);
	    fenetre.setLocationRelativeTo(null); //Centrer la fenêtre
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		newWindow(1500, 1300);
	}

}
