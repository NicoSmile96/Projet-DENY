package fr.deny.jvpr_;

import java.util.*;

public class JeuMain {

	public static void main(String[] args) {
		Grille g1 = new Grille(11,8);
		Perso p = new Perso();
		Action a =new Action();
		
		p.etatHUD();
		
		a.deplacer();
		 
	}

}
