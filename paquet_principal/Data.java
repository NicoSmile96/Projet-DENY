package paquet_principal;
import java.io.Serializable;

import collection_mobs.CollectionMobs;

public class Data implements Serializable{

	private static final long serialVersionUID = 1L;
	private Joueur joueur;
	private CollectionMobs mobs;
	private Affichage affichage;
	
	// constructeurs
	public Data() {}
	public Data(Joueur j, CollectionMobs m, Affichage aff) {
		this.joueur = j;
		this.mobs = m;
		this.affichage = aff;
	}
	
	// accesseurs
	public Joueur getJoueur() {
		return joueur;
	}
	public CollectionMobs getMobs() {
		return mobs;
	}
	public Affichage getAffichage() {
		return affichage;
	}	
}
