package view;

import java.awt.Component;
import javax.swing.*;

public class Window extends JFrame {

	public Window(int width, int height) {
			
			pack();
			setVisible(true);
			setResizable(false);
			setSize(width, height);
		    setLocationRelativeTo(null); //Centrer la fen�tre
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	
	public void add (JPanel p) {
		setContentPane(p);							//la fenetre affiche le MenuPanel
	}


}
