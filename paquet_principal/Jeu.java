package paquet_principal;
import java.io.Serializable;
import java.util.Scanner;

import classe_Perso.*;
import collection_mobs.CollectionMobs;
//import collection_mobs.*;

public class Jeu implements Serializable{ 
	private static final long serialVersionUID = 1L;
	
	Data data;
	
	public Jeu() throws InterruptedException {
		// initialisation variables
		
		Affichage aff = new Affichage();
		Joueur j = new Joueur();
		Save s = new Save();
		Load l = new Load();
		CollectionMobs mobs = new CollectionMobs(aff);
		data = new Data();
		
		// définition de la classe
		j.setTypeClass(TypeClass.GUERRIER);
		aff.afficherJoueur(2,2,j);		
	
		//Boucle du jeu
		for (int i=0;i<200;i++)
		{
			// affichage
			aff.afficherGrille();
			aff.etatHUDj(j);
			
			// scan action joueur
			System.out.println("save/load");
			Scanner sc = new Scanner(System.in);
			String action = sc.next();
			
			// save/load
			if(action.equals("save")) {
				data = new Data(j,mobs,aff);
				s.save(data);
			}
			if(action.equals("load")) {
				data = l.load();
				j = data.getJoueur();
				aff = data.getAffichage();
				mobs = data.getMobs();
				
				aff.afficherGrille();
				aff.etatHUDj(j);
			}
			
			//Combat
			j.combattre(mobs.getList(),aff);
			Thread.sleep(500);
			mobs.combattre(j);
			
			System.out.println("Deplacement : Z Haut Q Gauche S Bas D Droite ");
			aff.deplacement(j);
			System.out.println("\n\n\n\n\n\n");
			
		}
	}
	
	// fonction toString pour tester load
	public void testLoad() {
	
	}
	
	// attendre action du joueur
	public void attendreActionJoueur(CollectionMobs mobs, Affichage aff, Grille g, Joueur j) throws InterruptedException{
		System.out.println("Deplacement : Z Haut Q Gauche S Bas D Droite ");
		System.out.println("\n\n\n\n\n\n");

		Scanner sc = new Scanner(System.in);
		String action = sc.nextLine();
		
		if(action.equals("at")) {
			j.combattre(mobs.getList(), aff);
			Thread.sleep(500);	
			mobs.combattre(j,aff);
		}
		else if(action.equals("z") || action.equals("q") || action.equals("s") || action.equals("d")) {
			boolean b = false;
			do{
				action = sc.nextLine();
				try {
					b = j.deplacerJoueur(g,action);
				} catch (MurException e) {}
			} while(!b); 
		}
		else if(action.equals("save")) {
			
		}
		else {
			sc.close();
			attendreActionJoueur(mobs,aff,g,j);
		}
	}
}
