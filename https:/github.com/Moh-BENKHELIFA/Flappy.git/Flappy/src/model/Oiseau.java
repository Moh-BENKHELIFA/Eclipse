package model;

import java.util.Random;

public class Oiseau extends Thread{
	
	public int delai = 150;
	private static final int JUMP = 10;
	private int move = 10;
	private int dimensionX ;
	private int dimensionY ;
	private int hauteur;
	private int position;
	private int LWindow = 1500;
	private int HWindow = 800;
	private boolean inScreen;
	public int img;
	
	
	public Oiseau() {
		this.inScreen = true;
		this.img = 1;
		hauteur = initH();
		position = initP();
		setDimension();
		delai = initD();
	}
	
	public void nextImg() {
		if(img == 8) {
			img=1;
		}else {
			img++;
		}
	}

	public void run() {
		
		while(inScreen) {
			updateH();
			updateP();
			nextImg();
			try { Thread.sleep(this.delai); }
		    catch (Exception e) { e.printStackTrace(); }
		}
		
	}
	
	/**
	 * Defini aleatoirement les dimensions de l'image
	 */
	private void setDimension() {
		int r = (int) (25 + (Math.random() * (100 - 25))); 		//genere aleatoirement un nombre entre 25 et 100
		this.dimensionX = 600*r/100;
		this.dimensionY = 469*r/100;
	}
	
	public int getDimensionX() {
		return this.dimensionX;
	}
	
	public int getDimensionY() {
		return this.dimensionY;
	}
	
	private int initD() {
		this.move = (int) ((Math.random() * (30)));
		return (int) (80 + (Math.random() * (150 - 80)))	;
	}


	private int initP() {
		return (int) (Math.random() * 1500);
	}


	private int initH() {
		return (int) (Math.random() * 200);
	}
	
	private void checkinScreen() {
		if(this.hauteur > this.HWindow+500 || this.hauteur < -500 || this.position < -600 || this.position > this.LWindow+600 )
			this.inScreen = false;
	}
	
	public boolean getInScreen() {
		return this.inScreen;
	}

	private void updateH() {
		Random rd = new Random();
		if(rd.nextBoolean()) {
			this.hauteur -= JUMP;
		}else {
			this.hauteur += JUMP;
		}
		checkinScreen();

	}
	
	public int getHauteur() {
		
		return this.hauteur;
	}

	public int getPosition() {
		
		return this.position;
	}

	//TODO
	//FAIRE EN SORTE QUE LES OISEAUX SOIENT PLUS LENT DUCOUP LES FAIRE GLISSER VERS LA GAUCHE
	private void updateP() {
		Random rd = new Random();
		if(rd.nextBoolean()) {
			this.position += move;
		}else {
			this.position += move;
		}
		checkinScreen();
	}
}
