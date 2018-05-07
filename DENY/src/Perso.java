
// Personnage, h�ritages et interfaces � red�finir (Nico)
public class Perso implements Action{
	// vars liées aux tableaux
	private Position p;
	private Element e;
	
	// vars liées au jeu
	private int argent;
	private int xp;
	private int xpMax;
	private float vie;
	private float vieMax;
	int degat;
	int armure;
	int objetsMax;
	
	// constructeur d�faut - valeurs � modifier
	public Perso() {
		argent = 0;
		xp = 0;
		xpMax = 100;
		vie = 100;
		vieMax = 100;
		degat = 1;
		armure = 0;
		objetsMax = 5;
	}
	
	// accesseurs
		// vie
	public float getVie() {
		return vie;
	}
	
		// xp
	public int getXp() {
		return xp;
	}
	
		// argent
	public int getArgent() {
		return argent;
	}
	
	// mutateurs
		// vie
	public void setVie(int v) {
		vie = v;
	}
	
		// armure
	public void setArmure(int arm) {
		armure = arm; //pour modifier la resistance du perso par raport a son equipement
	}
	
		// d�gats
	public void setDegat(int dmg) {
		degat = dmg; //pour modifier les dommages du perso par raport a son equipement
	}
	
	public void utiliserPotion(int i) {
		if (i == 1) {
			vie +=10;
			if (vie >vieMax) {
				vie = vieMax;
			}
		}
	}	
	
	// actions d'interface � red�finir plus tard dans les classes filles
		// attaquer
	public int attaquer(int i) {
		return i + degat;
	}
		// level up
	public void lvlUp() {
		if (xp == xpMax) { 
			vieMax +=10; //augmentation des Pv de base
			degat +=10; // augmentation des degats de base
			xp = 0; 
			xpMax+=10; //augemenation de la barre d'xp
		}
	}
	
	// DEPLACEMENT
	// Bool�en d�placement autoris� ?
	public int deplacementAutorise(int i, int j, int iMax, int jMax) {
		if(i == 0 && j == 0)
			return 0;
		if(p.getI()+i < 0 || p.getI()+i >= iMax || p.getJ()+j < 0 || p.getJ()+j >= jMax)
			return 0;
		
		return 1;
	}
	
	// D�placer personnage
	public void deplacerPersonnage(Grille g, String deplacement) {	
		int i = 0, j = 0;
		
		if(deplacement.equals("z")) 			j++;
		else if(deplacement.equals("s")) 		j--;
		else if(deplacement.equals("q"))		i--;
		else if(deplacement.equals("d")) 		i++;
		
		if(deplacementAutorise( i,j,g.getLignes(),g.getColonnes() ) == 1) {
			g.setCase(this.p.getI(),this.p.getJ(),this.e);
			this.p.setI(p.getI()+i);
			this.p.setJ(p.getJ()+j);
			g.setCase(this.p.getI(),this.p.getJ(),this.e);
		} 
		else System.out.println("erreur d�placement");
	}
		
	// affichage � mettre dans affichage
	public void etatHUD() {
		System.out.println("Vie : " + vie +"/"+ vieMax + "      Xp : " + xp + "/" + xpMax);
	}
}
