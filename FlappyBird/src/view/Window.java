package view;

import java.awt.Component;
import javax.swing.*;

public class Window extends JFrame {

	/**
	 *Constructeur de l'objet Window qui permet de creer une fenetre
	 *de dimension quelconque.
	 *On interdit la redimension de la fenetre
	 *On centre la fenetre sur l'ecran
	 * 
	 * @param width 	longeur de la fenetre
	 * @param height 	hauteur de la fenetre
	 */
	public Window(int width, int height) {
			
		//	pack();
			setVisible(true);
			setResizable(false);
			setSize(width, height);
		    setLocationRelativeTo(null); //Centrer la fenêtre
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	



}
