package collection_mobs;
import paquet_principal.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Marchand implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Item> inventaire;
	private Position p;
	
	// constructeur
	public Marchand(){
		inventaire = new ArrayList<Item>();
		inventaire.add(new Item(50,5,"Potions"));
	}
	
	// setters
	public void setPosition(Position p) {
		this.p = p;
	}
	
	// getters
	public Position getPosition() {
		return p;
	}
	
	public ArrayList<Item> getInventaire(){
		return inventaire;
	}
	
	// afficher la marchandise !
	public void printMarchandise() {
		for(Item i : inventaire) {
			if(i.getQuantite() == 0) System.out.println("Ce marchand n'a plus rien à vous vendre !");
			else System.out.println("Acheter " +i.getNom()+ "(" +i.getQuantite()+ ") ? Tapez '" +i.getNom()+ "' - Prix : " +i.getPrix());
		}
	}
}
