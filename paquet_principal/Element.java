package paquet_principal;
import java.io.Serializable;

public enum Element implements Serializable{

	// playmobiles
	PERSONNAGE('@'),
	MAGE('M'),
	ARCHER('A'),
	GUERRIER('G'),
	// playpasmobiles
	VIDE('.'),
	MUR('#'),
	LOOT('*'),
	COFFRE('+');
	
	private char c;
	
	// constructeur
	Element(char c){
		this.c = c;
	}
	
	// accesseur
	public char getChar() {
		return c;
	}
}
