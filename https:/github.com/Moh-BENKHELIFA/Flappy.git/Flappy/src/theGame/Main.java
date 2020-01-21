package theGame;

import control.Control;
import model.*;
import view.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 1500;
		int y = 800;
		
		Window window = new Window(x,y);
		Parcours par = new Parcours(x);
		
		Etat state = new Etat(par);
		
		state.initHauteurFenetre(y);
		Affichage Affi = new Affichage(state, x, y);
		Control ctrl = new Control(Affi, state);
		
		window.add(Affi);
		window.addMouseListener(ctrl);
		window.addKeyListener(ctrl);

		
		
		
		Oiseau petitOiseau = new Oiseau();
		(new Thread(petitOiseau)).start();
		viewOiseau vOi = new viewOiseau();
		vOi.addBird(petitOiseau);
		Affi.addVO(vOi);
		
		
		
		(new Thread(new Voler(state, Affi))).start();
		(new Thread(new Avancer(par,state))).start();
	}
}
