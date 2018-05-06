
public class JeuMain {

	public static void main(String[] args) {
		Grille g1 = new Grille(11,8);
		Perso p = new Perso();
		Action a = new Action();
		
		g1.afficher();
		p.etatHUD();
		a.deplacer(g1);
		
//		int i = 1;
		
//		while(i == 1) {
//			a.deplacer();
//			g1.afficher();
//		}
	}

}