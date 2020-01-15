package theGame;

import control.Control;
import model.Avancer;
import model.Etat;
import model.Parcours;
import model.Voler;
import view.Affichage;
import view.Window;

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
		(new Thread(new Voler(state, Affi))).start();
		(new Thread(new Avancer(par))).start();

	}
}
