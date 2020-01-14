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
	
	public Control(Affichage a, Etat e) {
		this.a = a;
		this.e = e;
	}

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
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
