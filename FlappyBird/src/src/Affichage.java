package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Affichage extends JPanel implements MouseListener {
	
	public static final int width = 1500;
	public static final int height = 800;
	public static int x = 500;
	public static int y = 500;
	public Graphics p;
	
	public Affichage() {
		super();
		setPreferredSize(new Dimension(width, height));
		this.p = this.getGraphics();
		
	}
	
	//@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.blue);
		g.drawOval(500, 500, 200, 100);
	
	}
	

	
	
	
	public static void main(String args[]) {
		
		JFrame fenetre = new JFrame ("Affichage");
		Affichage a = new Affichage();
		fenetre.add(new Affichage());
		//a.paint(null);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		fenetre.setSize(width, height);
	    fenetre.setLocationRelativeTo(null); //Centrer la fen�tre
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		if(m.MOUSE_CLICKED==0){
			Affichage.x = this.x - 200;
		//	Graphics.clearRect(this.x, this.y, 200, 100) ;
			repaint();
		}
		
		System.out.println(m.getButton());
		System.out.println(m.getX());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getX());
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getX());

	}

	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
		System.out.println(m.getX());

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getX());
	}

}
