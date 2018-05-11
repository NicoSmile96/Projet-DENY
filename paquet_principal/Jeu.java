package paquet_principal;
import collection_mobs.*;
import java.io.Serializable;
import java.util.Scanner;

public class Jeu implements Serializable{ 
	private static final long serialVersionUID = 1L;
	
	// variables
	private Data data;
	private Affichage aff;
	private Joueur j;
	private Save s;
	private Load l;
	private CollectionMobs mobs;
	private Marchand m;
	private int lvl = 0;
	private int i = 1;
	
	public Jeu() throws InterruptedException {
		// initialisation variables
		j = new Joueur();
		s = new Save();
		l = new Load();
		data = new Data();
		m = new Marchand();
		aff = new Affichage();
				
		// définition de la classe
		aff.afficherMenuClasse(j);		
		
		// boucle principale
		while(i==1){		
			// réinitialisation map
			aff = new Affichage();
			mobs = new CollectionMobs(aff,lvl);
			aff.afficherJoueur(1,1,j);	
			aff.afficherpalier(lvl);
			aff.afficherMarchand(8, 2, m);
			
			//Boucle du jeu
			while (j.enVie() && (j.p.getI()!=20 || j.p.getJ()!= 17)){
				
				// Affichage
				aff.afficherGrille();
				aff.etatHUDj(j);
		
				// scan action joueur
				j.inRange(mobs.getList(),m);
				attendreActionJoueur();
				mobs.combattre(j);
			}
				
			if(j.enVie()){
				System.out.println("Niveau Suivant");
				i = 1;
			}
			else{
				System.out.println("Game Over");
				i=0;
			}
			
			// Niveau supérieur
			etage_superieur();
		 }
	}
	
	// étage supérieur
	public void etage_superieur(){
		this.lvl = lvl + 1;
	}
	
	// attendre action joueur
	public void attendreActionJoueur() throws InterruptedException{
		System.out.println("Deplacement : Z Haut Q Gauche S Bas D Droite ");
		System.out.println("Afficher inventaire : i");
		System.out.println("Boire Potion : boire potion");
		System.out.println("Sauvegarde/chargement : save/load");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String action = sc.nextLine();
		
		// attaquer/combattre
		if(action.equals("attaquer")) {
			if(j.inRange(mobs.getList())) {
				j.combattre(mobs.getList(), aff);
			}
			else {
				System.out.println("Monstres hors de portée !");
				attendreActionJoueur();
			}
		}
		// déplacement
		else if(action.equals("z") || action.equals("q") || action.equals("s") || action.equals("d")) {
			try {
				if(!j.deplacerJoueur(aff.getGrille(), action)) {
					attendreActionJoueur();
				}
			} catch (MurException e) {}
		}
		// sauvegarde/chargement
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
		// marchand
		else if(action.equals("parler")) {
			if(j.inRange(m)) j.acheter(m);
			else {
				System.out.println("aucun marchand à proximité !");
				attendreActionJoueur();
			}
		}
		// inventaire
		else if(action.equals("i")) {
			j.afficherInventaire();
			Thread.sleep(500);
			attendreActionJoueur();
		}
		// potion
		else if(action.equals("boire potion")) {
			if(j.getNbPotion() > 0) j.utiliserPotion();
			else {
				System.out.println("Aucune potion !");
				attendreActionJoueur();
			}
		}
		// rappel récursif
		else{
			System.out.print("Erreur, mauvaise commande !");
			attendreActionJoueur();
		}
	}
	
}
