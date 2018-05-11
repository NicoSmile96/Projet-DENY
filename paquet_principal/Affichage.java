package paquet_principal;

import java.io.Serializable;
import java.util.Scanner;

import classe_Perso.TypeClass;
import collection_mobs.Marchand;

public class Affichage implements Serializable{
	private static final long serialVersionUID = 1L;
	private Grille G = new Grille(20,23);
	
	// Méthodes d'affichage
	public void afficherMenuClasse(Joueur j) {
		System.out.println();
		System.out.println("              Bienvenue dans DENY!               ");
		System.out.println();
		System.out.println("Veillez choisir une classe pour votre personnage ");
		System.out.println("       mage    |    guerrier    |    archer      ");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		
		if (choix.equals("guerrier")){
			j.setTypeClass(TypeClass.GUERRIER);	
		}
		else if (choix.equals("mage")) {
			j.setTypeClass(TypeClass.MAGE);
		}
		else if (choix.equals("archer"))	{
			j.setTypeClass(TypeClass.ARCHER);
		}
		else {
			System.out.println("Nous n'avons pas saisi votre commande");
			afficherMenuClasse(j);
		}
	}
	
	public void afficherGrille(){
		G.afficher();
	}
	
	// Get grille
	public Grille getGrille() {
		return G;
	}
	
	// Joueur
	public void afficherJoueur(int i,int j,Joueur jo){
		G.setCase(i,j,Element.PERSONNAGE);
		Position pos = new Position(i,j);
		jo.setPos(pos);
	}
	
	// Marchand
	public void afficherMarchand(int i,int j,Marchand m){
		if(Math.random()*3 == 0) {
			G.setCase(i,j,Element.MARCHAND);
			Position pos = new Position(i,j);
			m.setPosition(pos);
		}
	}
	
	// Mob Archer
	public void afficherArcher(int i,int j,Mob a){
		G.setCase(i,j,Element.ARCHER);
		Position pos = new Position(i,j);
		a.setPos(pos);
	}
	
	// Mob Guerrier
	public void afficherGuerrier(int i,int j,Mob g){
		G.setCase(i,j,Element.GUERRIER);
		Position pos = new Position(i,j);
		g.setPos(pos);
	}
	
	// Mob Mage
	public void afficherMage(int i,int j, Mob m){
		G.setCase(i,j,Element.MAGE);
		Position pos = new Position(i,j);
		m.setPos(pos);
	}
	
	// supprimer Mob
	public void supprimerMob(int i,int j){
		double nb;
		nb = (int)(Math.random() * 2);
		if ((int)nb == 0) 
		{
			G.setCase(i,j,Element.VIDE);
		}

		else if ((int)nb == 1) 
		{
			G.setCase(i,j,Element.LOOT);
		}
	}
	
	// palier
	public void afficherpalier(int lvl){
		System.out.println("Palier numero "+(lvl+1));
	}
	
	// hud mob
	public void etatHUDm(Mob m){
		System.out.println("Vie monstre : " + m.getVie() +"/"+ m.getVieMax());
	}
	
	// hud joueur
	public void etatHUDj(Joueur j){
		System.out.println("Vous -> Lvl : "+j.getLvl()+"     Vie : " + j.getVie() +"/"+ j.getVieMax() + "      Xp : " + j.getXp() + "/" + j.getXpMax());
	}
}
