package paquet_principal;
import collection_mobs.*;
import classe_Perso.*;

public class Jeu{ 
	
	private int lvl = 0;
	private int i = 1;
	public Jeu() throws InterruptedException 
	{
		
		//Initialisation du joueur
		Joueur j = new Joueur();
		j.setTypeClass(TypeClass.GUERRIER);
		while(i==1)
		{
			
			Affichage aff = new Affichage();
			aff.afficherJoueur(1,1,j);
	
			//Collection des mobs de la carte
			CollectionMobs mobs = new CollectionMobs(aff,lvl);
			
			aff.afficherpalier(lvl);
			
				//Boucle du jeu
				while (j.enVie() && (j.p.getI()!=20 || j.p.getJ()!= 17))
				{
					aff.afficherGrille();
					aff.etatHUDj(j);
			
					//Combat
					j.combattre(mobs.getList(),aff);
					Thread.sleep(500);
					mobs.combattre(j);
			
					System.out.println("Deplacement : Z Haut Q Gauche S Bas D Droite ");
					aff.deplacement(j);
					//j.looter(aff.getGrille());
					System.out.println("\n\n\n\n\n\n");
			
				}
				
				if(j.enVie())
				{
					System.out.println("Niveau Suivant");
					i = 1;
				}
				else
				{
					System.out.println("Game Over");
					i=0;
				}
			
			// Niveau supérieur
			etage_superieur();
		 }
	}
	
	public void etage_superieur()
	{
		this.lvl = lvl + 1;
		
	}
	
}
