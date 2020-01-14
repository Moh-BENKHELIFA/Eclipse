package theGame;

import control.Control;
import model.Etat;
import view.Affichage;
import view.Window;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 1500;
		int y = 800;
		
		Window window = new Window(x,y);
		Etat state = new Etat();
		Affichage Affi = new Affichage(state, x, y);
		Control ctrl = new Control(Affi, state);
		
		window.add(Affi);
		window.addMouseListener(ctrl);
	}
int s;
}
