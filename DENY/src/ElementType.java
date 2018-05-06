
public enum ElementType {
	// playmobiles
	PERSONNAGE('@'),
	MAGE('M'),
	ARCHER('A'),
	GUERRIER('G'),
	// playpasmobiles
	VIDE('.'),
	MUR('#'),
	COFFRE('+');
	
	private char c;
	
	// constructeur
	ElementType(char c){
		this.c = c;
	}
	
	// accesseur
	public char toChar() {
		return c;
	}
}
