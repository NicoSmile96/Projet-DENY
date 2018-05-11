package classe_Perso;

public enum TypeClass implements Action{
	GUERRIER(1,3,20,20),
	MAGE(2,2,15,15),
	ARCHER(3,1,10,10);
	
	private int range;
	private int degats;
	private int vie;
	private int vieMax;
	
	// constructeur
	TypeClass(int range, int degats, int vie, int viemax){
		this.range = range;
		this.degats = degats;
		this.vie = vie;
		this.vieMax = viemax;
		
	}
	
	// accesseur
	public int getRange() {
		return range;
	}
	
	public int getDegats() {
		return degats;
	}
	
	public int getVie() {
		return vie;
	}
	
	public int getVieMax() {
		return vieMax;
	}

	// méthodes interface
	// combat
	public void combattre() {
		
		
	}
	// déplacement
	public void deplacer() {
		
	}
	
	
}
