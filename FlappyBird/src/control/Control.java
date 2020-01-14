package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Etat;
import view.Affichage;

public class Control implements KeyListener, MouseListener {
	
	
	private Affichage a;
	private Etat e;
	
	/**
	 * Constructeur de la classe Control 
	 * Permet de gerer les interactions de l'utilisateur
	 * 
	 * @param a   Le panel ou il faudra rafraichir l'affichage
	 * @param e	  L'etat qui sera modifie
	 */
	public Control(Affichage a, Etat e) {
		this.a = a;
		this.e = e;
	}

	/**
	 * Modifie l'emplacement de l'ovale lors d'un clic
	 * 
	 * @param arg0 	MouseEvent
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getButton()==1) {
			e.jump();
			a.repaint();
		}
		
		if(arg0.getButton()==3) {
			e.fall();
			a.repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void keyPressed(KeyEvent arg0) {}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
