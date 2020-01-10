package src;

import java.awt.Component;

import javax.swing.JFrame;

public class Window {

	public Window(int width, int height) {
			
			JFrame fenetre = new JFrame("titre de la fenêtre");
	//		fenetre.add(composant);
			fenetre.pack();
			fenetre.setVisible(true);
			fenetre.setResizable(false);
			fenetre.setSize(width, height);
		    fenetre.setLocationRelativeTo(null); //Centrer la fenêtre
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	
	public void add (Component p) {
		this.add(p);	
	}

	public static void main(String[] args) {
		
		new Window(1500, 1300);
	}
}
