
public class Grille {

	private int lignes;
	private int colonnes;
	private Element[][] grille;

	// Constructeur
	public Grille() {}
	public Grille (int l, int c) {
		lignes = l;
		colonnes = c;
		
		for (int i=0; i<lignes; i++) {
			for(int j=0; j<colonnes; j++) {
				grille[i][j].type = ElementType.VIDE; //sol
			}
		}
	}
	
	// Récupérer un élément
	public ElementType getCase(int i, int j) {
		return grille[i][j].type;
	}
	
	// Ajouter un élément dans la grille
	// Permet aussi de supprimer un élément d'une case en y insérant l'élément vide
	public void setCase(int i, int j, ElementType type) {
		grille[i][j].type = type;
		grille[i][j].p.i = i;
		grille[i][j].p.j = j;
	}
	
	// Echanger deux éléments
	public void switchElements(Element e1, Element e2) {
		Element tmp = e1;
		e1 = e2;
		e2 = tmp;
	}
	
	// Afficher la grille
	public void afficher() {
		System.out.println();
		
		for (int j=colonnes-1; j>=0; j--) {
			for(int i=0; i<lignes; i++) {
				System.out.print(" " + grille[i][j]);				
			}
			System.out.println(" ");
		}
		
		System.out.println();
	}
	
	// Booléen déplacement autorisé ?
	public int deplacementAutorise(int i, int j) {
		if(i == 0 && j == 0)
			return 0;
		if(iPersonnage+i < 0 || iPersonnage+i >= lignes || jPersonnage+j < 0 || jPersonnage+j >= colonnes)
			return 0;
		
		return 1;
	}
	
	// Déplacer personnage
	public void deplacerPersonnage(String deplacement) {	
		int i = 0, j = 0;
		
		if(deplacement.contains("haut")) 			j++;
		else if(deplacement.contains("bas")) 		j--;
		else if(deplacement.contains("gauche"))		i--;
		else if(deplacement.contains("droite")) 	i++;
		
		if(deplacementAutorise(i,j) == 1) {
			grille[iPersonnage][jPersonnage] = '.';
			iPersonnage += i;
			jPersonnage += j;
			grille[iPersonnage][jPersonnage] = '@';
		} 
		else System.out.println("erreur déplacement");
	}
}