package paquet_principal;
import collection_mobs.*;
import classe_Perso.*;

public class Jeu{ 
	
	public Jeu() throws InterruptedException {
		Affichage aff = new Affichage();
		int i;
		
		//Initialisation du joueur
		Joueur j = new Joueur();
		j.setTypeClass(TypeClass.GUERRIER);
		aff.afficherJoueur(2,2,j);
		
		//Collection des mobs de la carte
		CollectionMobs mobs = new CollectionMobs(aff);
	
		//Boucle du jeu
		for (i=0;i<20;i++)
		{
			aff.afficherGrille();
			aff.etatHUDj(j);
			
			//Combat
			j.combattre(mobs.getList(),aff);
			Thread.sleep(500);
			mobs.combattre(j);
			
			System.out.println("Deplacement : Z Haut Q Gauche S Bas D Droite ");
			aff.deplacement(j);
			System.out.println("\n\n\n\n\n\n");
			
		}
	}
	
}
