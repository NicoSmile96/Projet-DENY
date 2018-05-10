package paquet_principal;
import java.io.Serializable;

public class Grille implements Serializable{

	private static final long serialVersionUID = 1L;
	private int lignes;
	private int colonnes;
	private Element[][] element;
	
	// Constructeur
	public Grille (int l, int c) 
	{
		lignes = l;
		colonnes = c;
		double nb;
		element = new Element[l][c];
		for (int i=0; i<lignes; i++) {
			for(int j=0; j<colonnes; j++) {
				element[i][j] = Element.VIDE;
			}
		}
		for (int i =0; i<lignes; i++) {
			element[i][0] = Element.MUR; 
		}
		for (int i =0; i<lignes; i++) {
			element[i][colonnes-1] = Element.MUR;
		}
		for (int j =0; j<colonnes; j++) {
			element[0][j] = Element.MUR; 
		}
		for (int j =0; j<colonnes; j++) {
			element[lignes-1][j] = Element.MUR;
		}
		for (int i=0; i<lignes; i++) {
			nb = (int)(Math.random() * colonnes);
			for (int j =0; j<(int)nb; j++) {
				element[i][(int)nb] = Element.MUR;
			}
		}
		for (int j=0; j<colonnes; j++) {
			nb = (int)(Math.random() * lignes);
			for (int i =0; i<(int)nb; i++) {
				element[(int)nb][j] = Element.MUR;
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
	
	// Recuperer un element dans grille
	public Element getCase(int i, int j) {
		return element[i][j];
	}
	
	// Ajouter un element dans la grille
	// Permet aussi de supprimer un element d'une case en y inserant l'element vide
	public void setCase(int i, int j, Element e) {
		this.element[i][j] = e;
	}
	
	// Echanger deux elements
	public void switchElements(Position p1, Position p2) {
		Element tmp = element[p1.getI()][p1.getJ()];
		element[p1.getI()][p1.getJ()] = element[p2.getI()][p2.getJ()];
		element[p2.getI()][p2.getJ()] = tmp;
	}
	
	// Afficher la grille
	public void afficher() 
	{
		
		System.out.println();
		
		for (int j=colonnes-1; j>=0; j--)
		{
			for(int i=0; i<lignes; i++) 
			{
				System.out.print(" " + element[i][j].getChar());
			}
			System.out.println(" ");
		}
		
		System.out.println();
	}
}