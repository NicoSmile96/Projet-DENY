package classe_Perso;
import java.io.Serializable;

public enum TypeClass implements Action, Serializable{
	GUERRIER(1,3,20),
	ARCHER(2,3,10),
	MAGE(3,1,15);
	
	private int range;
	private int degats;
	private int vie;
	
	// constructeur
	TypeClass(int range, int degats, int vie){
		this.range = range;
		this.degats = degats;
		this.vie = vie;
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

	// méthodes interface
	// combat
	public void combattre() {
		
		
	}
	// déplacement
	public void deplacer() {
		
	}
	
	
}
