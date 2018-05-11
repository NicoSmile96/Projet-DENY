package paquet_principal;
import java.io.Serializable;
import java.util.Scanner;

import classe_Perso.*;
import collection_mobs.*;

public class Jeu implements Serializable{ 
	private static final long serialVersionUID = 1L;
	
	Data data;
	Affichage aff;
	Joueur j;
	Save s;
	Load l;
	CollectionMobs mobs;
	Marchand m;
	
	public Jeu() throws InterruptedException {
		// initialisation variables
		aff = new Affichage();
		j = new Joueur();
		s = new Save();
		l = new Load();
		mobs = new CollectionMobs(aff);
		data = new Data();
		m = new Marchand();
		
		Scanner sc = new Scanner(System.in);
		aff.afficherMarchand(8, 2, m);
		
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
			j.inRange(mobs.getList(),m);
			attendreActionJoueur(sc);
			mobs.combattre(j);
		}
		
		sc.close();
	}
	
	// attendre action joueur
	public void attendreActionJoueur(Scanner sc) throws InterruptedException{
		System.out.println("Deplacement : Z Haut Q Gauche S Bas D Droite ");
		System.out.println("save/load");
		String action = sc.nextLine();
		
		if(action.equals("at")) {
			j.combattre(mobs.getList(), aff);
		}
		else if(action.equals("z") || action.equals("q") || action.equals("s") || action.equals("d")) {
			try {
				if(!j.deplacerJoueur(aff.getGrille(), action)) {
					attendreActionJoueur(sc);
				}
			} catch (MurException e) {}
		}
		else if(action.equals("save")) {
			data = new Data(j,mobs,aff);
			s.save(data);;
		}
		else if(action.equals("load")) {
			data = l.load();
			j = data.getJoueur();
			aff = data.getAffichage();
			mobs = data.getMobs();
			
			aff.afficherGrille();
			aff.etatHUDj(j);
		}
		else if(action.equals("parler")) {
			j.acheter(m);
		}
		else{
			attendreActionJoueur(sc);
		}
	}
}
