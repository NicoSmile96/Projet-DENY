package paquet_principal;

public class Item 
{
	// var
	private int prix;
	private int quantite;
	private String nom;
	
	// constructeurs
	public Item() {}
	public Item(int prix, int quantite, String nom) {
		this.prix = prix;
		this.quantite = quantite;
		this.nom = nom;
	}
	
	// setters
	public void diminuerQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	// getters
	public int getPrix() {
		return prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public String getNom() {
		return nom;
	}
}
