
// Personnage, héritages et interfaces à redéfinir (Nico)
public class Perso extends Element implements Action{

	private int argent;
	private int xp;
	private int xpMax;
	private float vie;
	private float vieMax;
	int degat;
	int armure;
	int objetsMax;
	
	// constructeur défaut - valeurs à modifier
	public Perso() {
		super.type = ElementType.PERSONNAGE;
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
	
		// dégats
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
	
	// actions d'interface à redéfinir plus tard dans les classes filles
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
		
	// affichage à mettre dans affichage
	public void etatHUD() {
		System.out.println("Vie : " + vie +"/"+ vieMax + "      Xp : " + xp + "/" + xpMax);
	}
}
