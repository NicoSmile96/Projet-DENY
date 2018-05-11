package paquet_principal;
import classe_Perso.TypeClass;

// Classe abstraite dont heritent les classes Mob et Joueur
public abstract class Perso{
	
	// vars liees aux tableaux
	protected Position p;
	protected Element e;
	
	// classe personnage
	// degats initialisé à la même valeur que la range dans les constructeurs joueurs/mobs
	// MAGE = 3, ARCHER = 2, GUERRIER = 1 
	// utiliser personnage.t.getRange() pour récupérer la donnée correspondante
	protected TypeClass t = TypeClass.GUERRIER;
	
	// vars liees au jeu
	protected int argent;
	protected float vie;
	protected int vieMax;
	protected int degats;
	protected int objetsMax;
	protected int lvl;	
	protected int range;
	protected int nbPotion;
	
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
	
	public Position getPosition() {
		return p;
	}
	
	public int getRange() {
		return t.getRange();
	}
	
	public TypeClass getType() {
		return t;
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
	
	public void setTypeClass(TypeClass tclass) {
		this.t = tclass;
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
		en.setVie(en.getVie()-this.t.getDegats());	
	}
	
	// Booleen deplacement autorise ?
	
	public boolean deplacementAutorise(Grille g, int i, int j) {
		if (i == 0 && j == 0)
			return false;
		if(this.p.getI()+i < 0 || this.p.getI()+i >= g.getLignes() || this.p.getJ()+j < 0 || this.p.getJ()+j >= g.getColonnes())
			return false;
		if(g.getCase(p.getI()+i , p.getJ()+j) != Element.VIDE && g.getCase(p.getI()+i , p.getJ()+j) != Element.LOOT && g.getCase(p.getI()+i , p.getJ()+j) != Element.PORTE)
			return false;
		return true;
	}
	
	//Booleen attaque autorisee ?
		public boolean canAttack(Perso en)
		{
			if ((en.p.getI()>= this.p.getI()-this.t.getRange() && en.p.getI()<= this.p.getI()+this.t.getRange())
			  &&(en.p.getJ()>= this.p.getJ()-this.t.getRange() && en.p.getJ()<= this.p.getJ()+this.t.getRange()))
			return true;
			
			else
			return false;
		
		}
		
}
