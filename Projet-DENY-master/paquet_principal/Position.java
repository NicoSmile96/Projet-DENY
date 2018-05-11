package paquet_principal;

// position d'un element dans la grille
public class Position {
	private int i;
	private int j;
	
	// constructeurs
	public Position(){
		i = 0;
		j = 0;
	}
	public Position(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	// accesseurs
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}
	
	// mutateurs
	public void setI(int i) {
		this.i = i;
	}
	
	public void setJ(int j) {
		this.j = j;
	}
}
