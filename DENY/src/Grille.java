
public class Grille {
	private int lignes;
	private int colonnes;
	private Element[][] element;

	// Constructeur
	public Grille (int l, int c) {
		lignes = l;
		colonnes = c;
		element = new Element[l][c];
		
		for (int i=0; i<lignes; i++) {
			for(int j=0; j<colonnes; j++) {
				element[i][j] = Element.VIDE;
			}
		}
	}
	
	// Accesseurs
		// Récupérer longueur tableau
		public int getLignes() {
			return lignes;
		}
		public int getColonnes() {
			return colonnes;
		}
	
	// R�cup�rer un �l�ment dans grille
	public Element getCase(int i, int j) {
		return element[i][j];
	}
	
	// Ajouter un �l�ment dans la grille
	// Permet aussi de supprimer un �l�ment d'une case en y ins�rant l'�l�ment vide
	public void setCase(int i, int j, Element e) {
		element[i][j] = e;
	}
	
	// Echanger deux �l�ments
	public void switchElements(Position p1, Position p2) {
		Element tmp = element[p1.getI()][p1.getJ()];
		element[p1.getI()][p1.getJ()] = element[p2.getI()][p2.getJ()];
		element[p2.getI()][p2.getJ()] = tmp;
	}
	
	// Afficher la grille
	public void afficher() {
		System.out.println();
		
		for (int j=colonnes-1; j>=0; j--) {
			for(int i=0; i<lignes; i++) {
				System.out.print(" " + element[i][j].getChar());				
			}
			System.out.println(" ");
		}
		
		System.out.println();
	}
}