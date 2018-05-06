package fr.deny.jvpr_;

import java.util.Scanner;

public class Action {
	public Action() {
		
	}
	Grille g = new Grille(11,8);
	Perso p = new Perso();
	public void deplacer() {
		g.placer(3, 3, '@');
		g.afficher();
		int i = 0;
		while (i<250) {
			System.out.println("déplacements : 1 haut / 2 bas / 3 gauche / 4 droite");
			Scanner sc = new Scanner(System.in);
			int nb = sc.nextInt();
			switch (nb) {
			case 1 : g.monter();
			break;
			case 2 : g.decendre();
			break;
			case 3 : g.avancerGauche();
			break;
			case 4 : g.avancerDroite();
			break;
			default : System.out.println("NOPE");
			}
			for (int j = 0; j<10;j++) {
				System.out.println();
			}
			g.afficher();
			i++;
		}
	}
}
