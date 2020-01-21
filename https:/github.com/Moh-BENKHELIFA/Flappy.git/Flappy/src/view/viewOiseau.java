package view;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.Oiseau;

public class viewOiseau {
	
	private ArrayList<Oiseau> Oiseaux = new ArrayList();
	private BufferedImage[] sprites = new BufferedImage[9];

	
	public viewOiseau() {
		loadSprites();
		loadBirds();
	}
	
	private void loadBirds() {
		// TODO Auto-generated method stub
		int r = (int) (1 + (Math.random() * (6 - 1)))	;
		for(int i=0; i<r ;i++) {
			Oiseau bird = new Oiseau();
			Oiseaux.add(bird);
			(new Thread(bird)).start();

		}
	}

	public void dessiner(Graphics g) {
//		if(!Oiseaux.isEmpty()) {
			for(Oiseau bird : Oiseaux){
				if(bird.getInScreen()) {
	//			g.drawImage(sprites[bird.img], bird.getPosition(), bird.getHauteur(), null);
				g.drawImage(sprites[bird.img],bird.getPosition(), bird.getHauteur(), bird.getDimensionX(),bird.getDimensionY(),null);
	//			g.drawImage(sprites[bird.img],bird.getPosition(), bird.getHauteur(), 150,117,null);
	
				}else {
					Oiseaux.remove(bird);
					System.err.println("REMOVED");
				}
			}
//		}
	}
	
	
	
	public void loadSprites() {
		for(int i=1; i<9; i++) {
			try {
				sprites[i] = ImageIO.read(new File("/home/tp-home002/mbenkhe/eclipse-workspace/Flappy/images/Bird/animate-bird"+i+".jpg"));			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}
		}
	}
	
	public void addBird(Oiseau bird) {
		Oiseaux.add(bird);
		
	}
}
