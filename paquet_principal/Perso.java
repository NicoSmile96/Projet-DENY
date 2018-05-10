package paquet_principal;

// Classe abstraite dont heritent les classes Mob et Joueur
public abstract class Perso{
	
	// vars liees aux tableaux
	protected Position p;
	protected Element e;
	
	// vars liees au jeu
	protected int argent;
	protected float vie;
	protected int vieMax;
	protected int degats;
	protected int objetsMax;
	protected int lvl;
	protected int range;
	
	
	// accesseurs
	
	public float getVie() {
		return vie;
	}
	
	
	public int getArgent() {
		return argent;
	}
	
	public int getVieMax() {
		return vieMax;
	}
	
	public int getDegats() {
		return degats;
	}
	
	public int getObjetsMax() {
		return objetsMax;
	}
	
	public int getLvl() {
		return lvl;
	}
	
	public Position getPos() {
		return p;
	}
	
	public int getRange() {
		return range;
	}
	
	
	// mutateurs

	public void setVie(float v) {
		this.vie = v;
	}
	
	
	public void setDegats(int dmg) {
		this.degats = dmg; 
	}
	
	public void setArgent(int arg) {
		this.argent = arg;
	}
	
	public void setVieMax(int viemax) {
		this.vieMax = viemax;
	}
	
	public void setObjetsMax(int objm) {
		this.objetsMax = objm;
	}
	
	public void setlvl(int Lvl) {
		this.lvl = Lvl;
	}
	
	public void setPos(Position pos) {
		this.p = pos;
	}
	
	public void setRange(int rng) {
		this.range = rng; 
	}
	
	
	public void utiliserPotion()
	{
		setVie(this.vie+3);
		if (this.vie+3>this.vieMax) 
		{
			setVie(this.vieMax);
		}
	}
	
	
	public void attaquer(Perso en)
	{
		en.setVie(en.getVie()-this.degats);	
	}
	
	// Booleen deplacement autorise ?
	
	public boolean deplacementAutorise(int i, int j, int iMax, int jMax) {
		if (i == 0 && j == 0)
			return false;
		if(this.p.getI()+i < 0 || this.p.getI()+i >= iMax || this.p.getJ()+j < 0 || this.p.getJ()+j >= jMax)
			return false;

		return true;
	}
	
	//Booleen attaque autorisee ?
	public boolean canAttack(Perso en)
	{
		if ((en.p.getI()>= this.p.getI()-this.range && en.p.getI()<= this.p.getI()+this.range)
		  &&(en.p.getJ()>= this.p.getJ()-this.range && en.p.getJ()<= this.p.getJ()+this.range))
		return true;
		
		else
		return false;
	
	}
	
		
}
