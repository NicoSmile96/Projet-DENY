package paquet_principal;
import java.io.Serializable;

public class Affichage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Grille G = new Grille(23,20);
	
	
	public void afficherGrille()
	{
		G.afficher();
	}
	
	public void afficherJoueur(int i,int j,Joueur jo)
	{
		G.setCase(i,j,Element.PERSONNAGE);
		Position pos = new Position(i,j);
		jo.setPos(pos);
	}
	
	public void afficherArcher(int i,int j,Mob a)
	{
		G.setCase(i,j,Element.ARCHER);
		Position pos = new Position(i,j);
		a.setPos(pos);
	}
	
	public void afficherGuerrier(int i,int j,Mob g)
	{
		G.setCase(i,j,Element.GUERRIER);
		Position pos = new Position(i,j);
		g.setPos(pos);
	}
	
	public void afficherMage(int i,int j, Mob m)
	{
		G.setCase(i,j,Element.MAGE);
		Position pos = new Position(i,j);
		m.setPos(pos);
	}
	

	public void deplacement(Joueur j)
	{
		try {
				j.deplacerJoueur(G);
				
			} catch (MurException e) {}
	}
	
	public void supprimerMob(int i,int j)
	{
		G.setCase(i,j,Element.LOOT);
	}
	
	public void etatHUDm(Mob m)
	{
		System.out.println("Vie monstre : " + m.getVie() +"/"+ m.getVieMax());
	}
	
	public void etatHUDj(Joueur j)
	{
		System.out.println("Vous -> Lvl : "+j.getLvl()+"     Vie : " + j.getVie() +"/"+ j.getVieMax() + "      Xp : " + j.getXp() + "/" + j.getXpMax());
	}
}
