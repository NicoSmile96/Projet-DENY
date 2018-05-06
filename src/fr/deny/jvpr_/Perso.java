package fr.deny.jvpr_;

public class Perso {

	private int argent;
	private int xp;
	private int xpMax;
	private float vie;
	private float vieMax;
	int degat;
	int armure;
	int objetsMax;
	
	public Perso() {
		//nouveau perso
		vie = 100;
		vieMax=100;
		xp = 0;
		xpMax = 100;
	}
	
	public float getVie() {
		return vie;
	}
	
	public int getXp() {
		return xp;
	}
	
	public int getArgent() {
		return argent;
	}
	
	public void setVie(int v) {
		vie = v;
	}
	
	public void setArmure(int arm) {
		armure = arm; //pour modifier la resistance du perso par raport a son equipement
	}
	
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
	
	public int attaquer(int i) {
		return i + degat;
	}
	public void lvlUp() {
		if (xp == xpMax) { 
			vieMax +=10; //augmentation des Pv de base
			degat +=10; // augmentation des degats de base
			xp =0; 
			xpMax+=10; //augemenation de la barre d'xp
		}
		
	}
	
	public void etatHUD() {
		System.out.println("Vie : " + vie +"/"+ vieMax + "      Xp : " + xp + "/" + xpMax);
	}
}
